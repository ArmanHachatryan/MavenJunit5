package org.aston.exercise.Clasees;

import java.util.stream.IntStream;

public class Palindrome {
    public static boolean isPalindrome1(String string) {
        int N = string.length();
        return IntStream.range(0, N / 2).allMatch(i -> string.charAt(i) == string.charAt(N - i - 1));
    }

    public static boolean isPalindrome2(String string) {
        char[] chars = string.toLowerCase().replace(" ", "").toCharArray();
        int N = chars.length;
        int i = 0;
        int j = N - 1;
        while (i <= j) {
            if (chars[i++] != chars[j--]) return false;
        }
        return true;
    }

    public static boolean isPalindrome3(String string) {
        char[] chars = string.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            if (chars[i] != chars[j]) return false;
        }
        return true;
    }
}
