package org.aston.exercise;

import java.util.*;

public class myStrings {
    public static String flipString(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.reverse();
        return stringBuilder.toString();

        //return new StringBuilder(text).reverse().toString();
    }

    public static String flipString2(String text) {
        final int N = text.length();

        char[] chars = new char[N];

        for (int i = N - 1, j = 0; i >= 0; i--, j++) {

            chars[j] = text.charAt(i);
        }

        return new String(chars, 0, N);
    }

    public static String flipString3(String text) {
        List<String> list = new ArrayList<>();
        int N = text.length();
        int i = N - 1;
        while (i >= 0) {
            list.add(String.valueOf(text.charAt(i)));
            i--;
        }

        return list.stream().reduce((x, y) -> x + y).get();
    }

    public static String flipString4() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int length = input.length();

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = length - 1; i >= 0; i--) {
            stringBuilder.append(input.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static void reverseInput() {
        System.out.println("Input");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        StringBuilder reverse = new StringBuilder();
        int stringLength = input.length();

        for (int i= stringLength-1; i >= 0; i--) {
            reverse.append(input.charAt(i));
        }

        System.out.println(reverse);
    }

    public static int countCharAtWord(char symbol, String word){
        char[] lowChars = word.toLowerCase().toCharArray();
        char lowSymbol = Character.toLowerCase(symbol);

        int counter = 0;
        for (int i = 0; i < lowChars.length; i++) {
            if (lowSymbol == lowChars[i]) counter++;
        }

        return counter;
    }

    public static boolean isAnagram(String real, String anagram) {
        if (real.length() != anagram.length()) return false;

        char[] realChars = real.toCharArray();
        char[] anagramChars = anagram.toCharArray();
        boolean[] m = new boolean[anagramChars.length];

        for (var symbol : realChars) {

            for (int j = 0; j < anagramChars.length; j++) {
                if (symbol == anagramChars[j]) {
                    if (!m[j]) {
                        m[j] = true;
                        break;
                    }
                }
                if (j == anagramChars.length - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAnagram3(String real, String anagram) {
        if (real.length() != anagram.length()) return false;
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : real.toCharArray()) {
            //map.put(ch, map.getOrDefault(ch, 0) + 1);
            map.merge(ch, 1, Integer::sum);
            System.out.println(map);
        }
        for (char ch : anagram.toCharArray()) {
            if (!map.containsKey(ch)) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }

    //сырой, и не совсем правильный
    public static boolean isValid(String word) {
        if (word == null) {
            return false;
        }
        int square = 0;
        int querly = 0;
        int round = 0;
        for (char symbol : word.toCharArray()) {
            if (symbol == '(') {
                round++;
            } else if (symbol == ')') {
                round--;
//                if (round != 0) return false;
            } else if (symbol == '[') {
                square++;
            } else if (symbol == ']') {
                square--;
//                if (square != 0) return false;
            } else if (symbol == '{') {
                querly++;
            } else if (symbol == '}') {
                querly--;
//                if (querly != 0) return false;
            }
        }
        return square == 0 && querly == 0 && round == 0;
    }

    public static boolean isValidSwitch(String word) {
        if (word == null) {
            return false;
        }

        int square = 0;
        int querly = 0;
        int round = 0;
        for (var symbol : word.toCharArray()) {
            switch (symbol) {
                case ('['):
                    square++;
                    break;
                case (']'):
                    square--;
                    break;
                case ('{'):
                    querly++;
                    break;
                case ('}'):
                    querly--;
                    break;
                case ('('):
                    round++;
                    break;
                case (')'):
                    round--;
                    break;
                default:
                    System.out.println("Это не скобка");
            }
        }

        return round == 0 && querly == 0 && square == 0;
    }

    //        String[] emailList = {"test@mail.ru", "123-kk-df@gmail.com", "123@343.com", "qwerty@.com",
    //        "123123@yandex.com", "test.test@gmailcom", "sdfsdf@gmail."};
    //        System.out.println(isValidate(emailList));
    public static Map<String, Boolean> isValidate(String[] emailList) {
        Map<String, Boolean> hashMap = new HashMap<>();
        for (var email : emailList) {
            if (email.matches("(\\w+[.-]?\\w+)+@\\w+\\.[a-z]{2,4}")) {
                hashMap.put(email, true);
            }
            else {
                hashMap.put(email, false);
            }
        }
        return hashMap;
    }

    public static boolean isValidate(String string) {
        Stack<String> stack = new Stack<>();
        String[] array = string.split("");
        for (var symbol : array) {
            if (symbol.matches("[{\\[(]")) {
                stack.push(symbol);
            }
            else if (symbol.matches("[}\\])]")) {
                if (stack.isEmpty()) return false;
                else if (symbol.equals("}")) {
                    if (!stack.pop().equals("{")) return false;
                }
                else if (symbol.equals("]")) {
                    if (!stack.pop().equals("[")) return false;
                }
                else if (symbol.equals(")")) {
                    if (!stack.pop().equals("(")) return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static boolean isValidate2(String str) {
        Stack<Character> myStack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        for (char ch : str.toCharArray()) {
            if (bracketMap.containsValue(ch)){
                myStack.push(ch);
            } else if (bracketMap.containsKey(ch)){
                if (myStack.isEmpty() || myStack.pop() != bracketMap.get(ch)){
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }

    public static String reverse(String string){
        Stack<Character> stack = new Stack<>();

        for (char symbol : string.toCharArray()) {
            stack.push(symbol);
        }

        char[] chars = new char[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            chars[i++] = stack.pop();
        }

        return new String(chars);
    }

    public static boolean isAnagram5(String real, String anagram) {
        if (real.length() != anagram.length()) {
            return false;
        }
        char[] realCharArray = real.toCharArray();
        char[] anagramCharArray = anagram.toCharArray();
        Arrays.sort(realCharArray);
        Arrays.sort(anagramCharArray);
        for (int i = 0; i < realCharArray.length; i++) {
            if (realCharArray[i] != anagramCharArray[i]) return false;
        }
        return true;
    }

    public static String convert(int n) {
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            Map.Entry<Integer, String> entry = map.floorEntry(n);
            sb.append(entry.getValue());
            n -= entry.getKey();
        }
        return sb.toString();
    }
}
 