package org.aston.exercise.Important;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class NeedToRemember {
    public static Map<String, Boolean> isValidate(String[] emailList) {
        Map<String, Boolean> hashMap = new HashMap<>();
        for (var email : emailList) {
            if (email.matches("(\\w+[.-]?\\w+)+@\\w+\\.[a-z]{2,4}")) {
                //("([A-Za-z0-9]{1,}[\\.-]{0,1}[A-Za-z0-9]{1,})+@([A-Za-z0-9]{1,}[\\.-]{0,1}[A-Za-z0-9]{1,})+[\\.]{1}[a-z]{2,4}")
                hashMap.put(email, true);
            } else {
                hashMap.put(email, false);
            }
        }
        return hashMap;
    }

    public static Map<String, Integer> reverseKeyValue(Map<Integer, String> firstMap) {
        Map<String, Integer> secondMap = new HashMap<>();
        for (Map.Entry<Integer, String> set : firstMap.entrySet()){
            secondMap.put(set.getValue(), set.getKey());
        }
        return secondMap;
    }

    public static String replace(String string, char oldChar, char newChar) {
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == oldChar) chars[i] = newChar;
            //chars[i] = chars[i] == oldChar ? newChar : chars[i]
        }

        return new String(chars);
    }

    public static boolean isAnagram1(String real, String anagram) { //хороший варик
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

    public static boolean isPalindrome3(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }

    public static String reverse2() { //через сканер
        System.out.println("Input");
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

//        StringBuilder stringBuilder = new StringBuilder(string); 1
//        stringBuilder.reverse();
//        return stringBuilder.toString();
//        return new StringBuilder(string).reverse().toString(); 1.2

//        StringBuilder stringBuilder = new StringBuilder(); 2
//        int stringLength = string.length();
//        for (int i = stringLength - 1; i >= 0; i--) {
//            stringBuilder.append(string.charAt(i));
//        }
//        return stringBuilder.toString();

        char[] chars = new char[string.length()]; //3
        for (int i = string.length() - 1, j = 0; i >= 0; i--, j++) {
            chars[j] = string.charAt(i);
        }
        return new String(chars);
    }

    public static boolean isValidate2(String str) { //через стэк и мапу
        Stack<Character> myStack = new Stack<>();
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put(']', '[');
        bracketMap.put('}', '{');

        for (char ch : str.toCharArray()) {
            if (bracketMap.containsValue(ch)) {
                myStack.push(ch);
            } else if (bracketMap.containsKey(ch)) {
                if (myStack.isEmpty() || myStack.pop() != bracketMap.get(ch)) {
                    return false;
                }
            }
        }
        return myStack.isEmpty();
    }
}
