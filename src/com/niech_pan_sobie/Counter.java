package com.niech_pan_sobie;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Counter {

    public static void countLetters() {
        final Path path = Paths.get("text.txt");
        try {
            int lettersNumber = 0;
            final List<String> lines = Files.readAllLines(path);

            final char[] chars = lines.get(0).toCharArray();

            for (final char c: chars) {
                if (c > 64 && c < 91 || c > 96 && c < 123) {
                    lettersNumber++;
                }
            }

            System.out.println("\n------------------------------\nNumber of letters in file: " + lettersNumber + "\n------------------------------\n");
        } catch (final IOException e) {
            System.out.println("\n----------------------------------------\nSorry, file has not yet been downloaded!\n----------------------------------------\n");
        }
    }

    public static void countWords() {
        final Path path = Paths.get("text.txt");
        int wordsNumber = 0;
        Scanner scanner = null;
        try {
            scanner = new Scanner(path);
        }  catch (final NoSuchFileException n) {
            System.out.println("\n----------------------------------------\nSorry, file has not yet been downloaded!\n----------------------------------------\n");

            return;
        }
        catch (final IOException e) {
            return;
        }
        catch (final NullPointerException u) {
            return;
        }
        while (scanner.hasNext()) {
            scanner.next();
            wordsNumber++;
        }
        scanner.close();
        System.out.println("\n------------------------------\nNumber of words in file: " + wordsNumber + "\n------------------------------\n");
    }

    public static void generateReport() {
        final Path path = Paths.get("text.txt");
        try {
            final Map<String, Integer> letters = generateAlphabetMap();
            final List<String> lines = Files.readAllLines(path);
            final String[] split = lines.get(0).split("");

            for (final String s : split) {
                if (letters.containsKey(s)) {
                    int i = letters.get(s);
                    letters.replace(s, ++i);
                }
            }
            System.out.println("\n----");
            letters.forEach((s, integer) -> System.out.println(s + ": " + integer));
            System.out.println("----\n");
        } catch (final IOException e) {
            System.out.println("\n----------------------------------------\nSorry, file has not yet been downloaded!\n----------------------------------------\n");
        }
    }

    private static Map<String, Integer> generateAlphabetMap() {
        final Map<String, Integer> letters = new HashMap<>();
        final String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (final String s : alphabet) {
            letters.put(s, 0);
        }
        return letters;
    }
}
