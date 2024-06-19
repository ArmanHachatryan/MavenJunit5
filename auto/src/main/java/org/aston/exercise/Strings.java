package org.aston.exercise;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    public static String flip(String text) {
        StringBuilder stringBuilder = new StringBuilder(text);
        stringBuilder.reverse();
        return stringBuilder.toString();

        //return new StringBuilder(text).reverse().toString();
    }

    public static String flip2(String text) {
        final int N = text.length();

        char[] chars = new char[N];

        for (int i = N-1, j = 0; i >= 0; i--, j++) {

            chars[j] = text.charAt(i);
        }

        return new String(chars,0, N);
    }

    public static String flip3(String text){
        List<String> list = new ArrayList<>();
        int N = text.length();
        int i = N - 1;
        while (i >= 0)
        {
            list.add(String.valueOf(text.charAt(i)));
            i--;
        }

        return list.stream().reduce( (x, y) -> x + y).get();
    }
}
