package org.aston.exercise.Clasees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Another {
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

    public static Map<String, Boolean> isValidate(String[] emailList) {
        Map<String, Boolean> hashMap = new HashMap<>();
        for (var email : emailList) {
            if (email.matches("(\\w+[.-]?\\w+)+@\\w+\\.[a-z]{2,4}")) {  //"[A-Za-z0-9]"
                hashMap.put(email, true);
            } else {
                hashMap.put(email, false);
            }
        }
        return hashMap;
    }

    public static void printSomeTimes(int count, String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            stringBuilder.append(string);
            if (i < count - 1) {
                stringBuilder.append("\n");
            }
        }
        System.out.println(stringBuilder);
    }

    public static List<Integer> evenAndOdd(Stream<Integer> stream) {
        return stream.map(i -> i % 2 == 0 ? i * 100 : i - 100).collect(Collectors.toList());
        //return Arrays.stream(nums).filter(x -> (x % 2 != 0)).sum();
        //Arrays.stream(nums).boxed().mapToInt(x -> x % 2 == 0 ? x + 100 : x - 100).forEach(System.out::println);
    }

    public static Integer sumEven() {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4);

        //int sum = list.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        return list.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).orElseThrow(RuntimeException::new);
    }

    public static Map<String, Integer> reverseKeyValue(Map<Integer, String> firstMap) {
        Map<String, Integer> secondMap = new HashMap<>();
        for (Map.Entry<Integer, String> set : firstMap.entrySet()){
            secondMap.put(set.getValue(), set.getKey());
        }
        return secondMap;
    }

    public static Map<String, Integer> reverseKeyValue2(Map<Integer, String> map) {
        return map.entrySet().stream().collect(Collectors.toMap(
                Map.Entry::getValue,
                Map.Entry::getKey,
                (x, y) -> y //разрешение конфликтов, заменит значение на последнее значение
                //(x, y) -> x
        ));
    }

    public static List<Integer> sort(Stream<Integer> stream) { //через StreamApi
        //return stream.sorted((a,b) -> new myComp().compare(a,b)).collect(Collectors.toList()); 1
        //return stream.sorted(Comparator.reverseOrder()).collect(Collectors.toList()); 2
        return stream.sorted(new Comparator<Integer>() { //3
            @Override
            public int compare(Integer o1, Integer o2) {
                int answer;
                if (o1 == o2) answer = 0;
                else if (o1 > o2) answer = 1;
                else answer = -1;
                return -1 * answer;
            }
        }).collect(Collectors.toList());
    }

    public static String deleteChar(String string, char del) {
        char[] chars = string.toCharArray();
        char[] org = new char[chars.length];
        int counter = 0;
        for (char temp : chars) {
            if (temp != del) {
                org[counter++] = temp;
            }
        }
        return new String(org, 0, counter);
    }

    public static String replace(String string, char oldChar, char newChar) {
        char[] chars = string.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == oldChar) chars[i] = newChar;
            //chars[i] = chars[i] == oldChar ? newChar : chars[i]
        }

        return new String(chars);
    }

    public static String replace(String string) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] != ' ') && (chars[i] != '\t')) {
                stringBuffer.append(chars[i]);
            }
        }

//        for (var key : chars) {
//            if ((key != ' ') && (key != '\t')) stringBuffer.append(key);
//        }

//        for (var key : string.toCharArray()) {
//            if (!Character.isWhitespace(key)) stringBuffer.append(key);
//        }

        return stringBuffer.toString();
    }

    public static int countCharAtWord(char symbol, String word) {
        char[] lowChars = word.toLowerCase().toCharArray();
        char lowSymbol = Character.toLowerCase(symbol);

        int counter = 0;
        for (int i = 0; i < lowChars.length; i++) {
            if (lowSymbol == lowChars[i]) counter++;
        }

        return counter;
    }
}
