package com.niech_pan_sobie;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class FileHandler {
    private static final String NAME = "text.txt";

    public static String getFile(String choice) {
        Scanner scanner = new Scanner(System.in);
        if (choice.equalsIgnoreCase("Y")) {
            System.out.print("Enter url to download: ");
            String urlToFile = scanner.nextLine().trim();
            return downloadFile(urlToFile);
        } else if (choice.equalsIgnoreCase("N")) {
            System.out.print("Enter file name: ");
            String fileName = scanner.nextLine();
            return openFile(fileName);
        }
        return null;
    }

    private static String openFile(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            return fileName;
        } catch (IOException e) {
            System.out.println("\n------------------------------------------------------\nThe file has not been found!\n------------------------------------------------------\n");
        }
        return null;
    }

    private static String downloadFile(String path) {
        URL url;
        try {
            url = new URL(path);
            try (InputStream in = url.openStream();
                 BufferedInputStream bis = new BufferedInputStream(in);
                 FileOutputStream fos = new FileOutputStream(NAME)) {

                byte[] data = new byte[1024];
                int count;
                while ((count = bis.read(data, 0, 1024)) != -1) {
                    fos.write(data, 0, count);
                }
                System.out.println("\n------------------------------------------------------\nThe file has been downloaded!\n------------------------------------------------------\n");
                return NAME;
            }
        } catch (MalformedURLException e) {
            System.out.println("\n------------------------------------------------------\nSorry, something went wrong when tried to create link!\n------------------------------------------------------\n");
        }
        catch (IOException e) {
            System.out.println("\n--------------------------------------------------------\nSorry, something went wrong when tried to create the file!\n--------------------------------------------------------\n");
        }
        return null;
    }


    public static void saveStats() {
        try {
            PrintStream printStream = new PrintStream("statystyki.txt");
            System.out.println("Data have been saved.");

            printStream.println("===============Statistics of the operations on the file " + FileHandler.NAME + "===============\n\n");

            if(Main.vowels==-1&&Main.cons==-1){
                printStream.println("\nCounting letters has not been executed");
            }
            else{
                printStream.println("\nConsonant count: " + Main.cons);
                printStream.println("\nVowel count: " + Main.vowels);
            }
            if(Main.words==-1){
                printStream.println("\nCounting words has not been executed.");
            }
            else{
                printStream.println("\nWords count: " +Main.words);
            }
            if(Main.punctuationmarks==-1){
                printStream.println("\nCounting punctuation marks has not been executed.");
            }
            else{
                printStream.println("\nPunctuation marks count: " +Main.punctuationmarks);
            }
            if(Main.sentences==-1){
                printStream.println("\nCounting sentences has not been executed.");
            }
            else{
                printStream.println("\nSentences count:" + Main.sentences);
            }
            printStream.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void endApplication (String fileName) {
        Path text = Paths.get(fileName);
        Path statistics = Paths.get("statystyki.txt");
        try {
            Files.deleteIfExists(text);
            Files.deleteIfExists(statistics);
        } catch (IOException e) {
            System.out.println("Something went wrong - " + e.getMessage());
        }
    }
}
