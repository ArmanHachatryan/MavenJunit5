package org.aston.exercise.Clasees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Reverse {
    public static String reverse1(String text) { //заменил char[] на list for на while
        List<String> list = new ArrayList<>();
        int N = text.length();
        int i = N - 1;
        while (i >= 0) {
            list.add(String.valueOf(text.charAt(i)));
            i--;
        }

        return list.stream().reduce((x, y) -> x + y).get();
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

    public static String reverse3(String string) { //много лишнего
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

    public static String reverse4(String string, int index) {  //рекурсия
        if (index == 0) {
            return String.valueOf(string.charAt(0));
        }
        char ch = string.charAt(index);
        return ch + reverse4(string, index - 1);
    }
}
