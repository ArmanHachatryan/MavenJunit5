package org.aston.exercise;

public class Main {
    public static void main(String[] args) {
        String myString = "I love Java";
        //System.out.println(method1(myString));

        //System.out.println(method2(myString, myString.length()-1));

//        int length = myString.length();
//
//        char[] chars = new char[length];
//
//        for (int i = length - 1, count = 0; i >= 0; i--) {
//            chars[count++] = myString.charAt(i);
//        }
//
//        System.out.println(chars);

//        String BASE_PATH
    }

    public static String method1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String method2(String string, int index) {
        if (index == 0) {
            return string.charAt(0) + "";
        }
        char random = string.charAt(index);
        return random + method2(string, index-1);
    }

    //buffer for manythread
    //anagramms
    //решить через стэк
}