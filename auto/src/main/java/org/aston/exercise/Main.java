package org.aston.exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(isValidate("({}[)]"));
    }

    public static boolean isValidate(String string) {
        Stack<Character> stack = new Stack<>(); //значение т.е открытые скобки уходят в стэк
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (var ch : string.toCharArray()) {
            if (map.containsValue(ch)) stack.push(ch);
            else if (map.isEmpty() || map.get(ch) != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
       