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

    public static void countLetters(String fileName) {
        try {
            Path path = Paths.get(fileName);
            int vowNumber = 0;
            int consNumber = 0;
            List<String> lines = Files.readAllLines(path);

            char[] chars = lines.get(0).toCharArray();

            for (char c: chars) {
                if (c > 64 && c < 91 && c != 65 && c!=69 && c!=73 && c!=79 && c!=85 || c > 96 && c < 123 && c!=97  && c!=101  && c!=105 && c!=111 && c!=117 ) {
                    consNumber++;
                }
                else if (c == 65 || c == 97 || c==69 || c ==73 || c==105 || c==79 || c==111 || c ==85 || c==117){
                    vowNumber++;
                }
            }

            System.out.println("\n------------------------------\nNumber of vowels in the file: " + vowNumber + "\n------------------------------");
            System.out.println("------------------------------\nNumber of consonants in the file: " + consNumber + "\n------------------------------\n");

            Main.vowels = vowNumber;
            Main.cons = consNumber;

        } catch (IOException e) {
            System.out.println("\n----------------------------------------\nSorry, file has not yet been downloaded!\n----------------------------------------\n");
        } catch (NullPointerException e) {
            System.out.println("\n----------------------------------------\nSorry, could not open file!\n----------------------------------------\n");
        }
    }

    public static void countWords(String fileName) {
        int wordsNumber = 0;
        Scanner scanner = null;
        try {
            Path path = Paths.get(fileName);
            scanner = new Scanner(path);
        }  catch (NoSuchFileException n) {
            System.out.println("\n----------------------------------------\nSorry, file has not yet been downloaded!\n----------------------------------------\n");
            return;
        }
        catch (IOException | NullPointerException e) {
            System.out.println("\n----------------------------------------\nSorry, could not open file!\n----------------------------------------\n");
            return;
        }
        while (scanner.hasNext()) {
            String next = scanner.next();
            if (next.length()>1){
                wordsNumber++;
            }
        }

        scanner.close();
        System.out.println("\n------------------------------\nNumber of words in file: " + wordsNumber + "\n------------------------------\n");
        Main.words = wordsNumber;
    }

    public static void countPunctuationMarks(String fileName) {
        try {
            Path path = Paths.get(fileName);
            int marksNumber = 0;
            List<String> lines = Files.readAllLines(path);

            char[] chars = lines.get(0).toCharArray();

            for (char c: chars) {
                if (c == 46 || c == 63 ) {
                    marksNumber++;
                }
            }

            System.out.println("\n------------------------------\nNumber of punctuation marks in the file: " + marksNumber + "\n------------------------------\n");
            Main.punctuationmarks = marksNumber;
        } catch (IOException e) {
            System.out.println("\n----------------------------------------\nSorry, the file has not yet been downloaded!\n----------------------------------------\n");
        } catch (NullPointerException e) {
            System.out.println("\n----------------------------------------\nSorry, could not open file!\n----------------------------------------\n");
        }
    }

    public static void countSentences(String fileName) {
        try {
            Path path = Paths.get(fileName);
            int sentencesNumber = 0;
            List<String> lines = Files.readAllLines(path);

            char[] chars = lines.get(0).toCharArray();

            for (char c: chars) {
                if (c == 46 || c == 63 ) {
                    sentencesNumber++;
                }
            }

            System.out.println("\n------------------------------\nNumber of sentences in the file: " + sentencesNumber + "\n------------------------------\n");
            Main.sentences = sentencesNumber;
        } catch (IOException e) {
            System.out.println("\n----------------------------------------\nSorry, the file has not yet been downloaded!\n----------------------------------------\n");
        } catch (NullPointerException e) {
            System.out.println("\n----------------------------------------\nSorry, could not open file!\n----------------------------------------\n");
        }
    }

    public static void generateReport(String fileName) {
        try {
            Path path = Paths.get(fileName);
            Map<String, Integer> letters = generateAlphabetMap();
            List<String> lines = Files.readAllLines(path);
            String[] split = lines.get(0).split("");

            for (String s : split) {
                if (letters.containsKey(s.toUpperCase())) {
                    int i = letters.get(s.toUpperCase());
                    letters.replace(s.toUpperCase(), ++i);
                }
            }
            System.out.println("\n----");
            letters.forEach((s, integer) -> System.out.println(s + ": " + integer));
            System.out.println("----\n");
        } catch (IOException e) {
            System.out.println("\n----------------------------------------\nSorry, file has not yet been downloaded!\n----------------------------------------\n");
        } catch (NullPointerException e) {
            System.out.println("\n----------------------------------------\nSorry, could not open file!\n----------------------------------------\n");
        }
    }

    private static Map<String, Integer> generateAlphabetMap() {
        Map<String, Integer> letters = new HashMap<>();
        String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        for (String s : alphabet) {
            letters.put(s, 0);
        }
        return letters;
    }
}
