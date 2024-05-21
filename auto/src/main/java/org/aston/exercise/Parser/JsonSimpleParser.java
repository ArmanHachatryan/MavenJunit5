package org.aston.exercise.Parser;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonSimpleParser {
    public Root parse() {

        Root root = new Root();

        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader("/test.json")){

            JSONObject rootJsonObject = (JSONObject) parser.parse(reader);

            int total = (int) rootJsonObject.get("total");

            root.setTotal(total);

        } catch (Exception e) {
            System.out.println("Parsing error " + e.toString());
        }

        return null;
    }
}
