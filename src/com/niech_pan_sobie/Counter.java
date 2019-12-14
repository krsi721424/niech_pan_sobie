package com.niech_pan_sobie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Counter {

    public static void countLetters() {
        Path path = Paths.get("exercise.txt");
        try {
            int lettersNumber = 0;
            List<String> lines = Files.readAllLines(path);

            char[] chars = lines.get(0).toCharArray();

            for (char c: chars) {
                if (c > 64 && c < 91 || c > 96 && c < 123) {
                    lettersNumber++;
                }
            }

            System.out.println("\n------------------------------\nNumber of letters in file: " + lettersNumber + "\n------------------------------\n");
        } catch (IOException e) {
            System.out.println("\n----------------------------------------\nSorry, file has not yet been downloaded!\n----------------------------------------\n");
        }
    }
}
