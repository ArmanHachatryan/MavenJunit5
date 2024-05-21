package org.aston.exercise.Parser;

import com.google.gson.Gson;
import org.aston.exercise.Parser.models.Root;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {

    public Root parse() {

        Gson gson = new Gson();

        try (FileReader reader = new FileReader("E:\\AQA\\MavenJunit5\\auto\\test.json")) {

            Root root = gson.fromJson(reader, Root.class);

            return root;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
