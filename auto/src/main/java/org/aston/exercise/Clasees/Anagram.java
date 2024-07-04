package org.aston.exercise.Clasees;

import java.util.*;

public class Anagram {

    public static boolean isAnagram(String real, String anagram) { //варик Димы
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

    public static boolean isAnagram2(String real, String anagram) { //странный варик
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
}
