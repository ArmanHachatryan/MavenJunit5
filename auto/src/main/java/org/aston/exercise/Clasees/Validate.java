package org.aston.exercise.Clasees;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Validate {
    public static boolean isValidate(String string) { //мой вариант через стэк и ифы
        Stack<String> stack = new Stack<>();
        String[] array = string.split("");
        for (var symbol : array) {
            if (symbol.matches("[{\\[(]")) {
                stack.push(symbol);
            } else if (symbol.matches("[}\\])]")) {
                if (stack.isEmpty()) return false;
                else if (symbol.equals("}")) {
                    if (!stack.pop().equals("{")) return false;
                } else if (symbol.equals("]")) {
                    if (!stack.pop().equals("[")) return false;
                } else if (symbol.equals(")")) {
                    if (!stack.pop().equals("(")) return false;
                }
            }
        }
        return stack.isEmpty();
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

    public static boolean isValidate3(String word) { //полурабочий вариант лучше не юзать
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

    public static boolean isValidate4(String word) { //полурабочий вариант лучше забыть)
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
                if (round != 0) return false;
            } else if (symbol == '[') {
                square++;
            } else if (symbol == ']') {
                square--;
                if (square != 0) return false;
            } else if (symbol == '{') {
                querly++;
            } else if (symbol == '}') {
                querly--;
                if (querly != 0) return false;
            }
        }
        return square == 0 && querly == 0 && round == 0;
    }
}
