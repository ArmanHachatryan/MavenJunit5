package org.aston.exercise;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValidate("(())"));
    }

    public static boolean isValidate(String string) {
        if (string.isEmpty() || string.equals(" ")) return false;

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (var ch : string.toCharArray()) {
            if (map.containsValue(ch)) stack.push(ch);
            else if (map.containsKey(ch)) {
                if (stack.isEmpty() || stack.pop() != map.get(ch)) return false;
            }
        }

        return true;
    }
}