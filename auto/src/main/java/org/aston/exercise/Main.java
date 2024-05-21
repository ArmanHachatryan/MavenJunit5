package org.aston.exercise;

import org.aston.exercise.Parser.JsonSimpleParser;
import org.aston.exercise.Parser.Root;

public class Main {
    public static void main(String[] args) {

        JsonSimpleParser parser = new JsonSimpleParser();
        Root root = parser.parse();

        System.out.println("Root " + root.toString());

    }
}