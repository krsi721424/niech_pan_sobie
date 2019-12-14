package com.niech_pan_sobie;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileHandler {
    private static final String urlToFile = "https://s3.zylowski.net/public/input/6.txt";
    private static final String name = "text.txt";

    public static void downloadFile() {
        URL url;
        {
            try {
                url = new URL(urlToFile);
                try (InputStream in = url.openStream();
                     BufferedInputStream bis = new BufferedInputStream(in);
                     FileOutputStream fos = new FileOutputStream(name)) {

                    byte[] data = new byte[1024];
                    int count;
                    while ((count = bis.read(data, 0, 1024)) != -1) {
                        fos.write(data, 0, count);
                    }
                    System.out.println("\n------------------------------------------------------\nThe file has been downloaded!\n------------------------------------------------------\n");
                }
            } catch (MalformedURLException e) {
                System.out.println("\n------------------------------------------------------\nSorry, something went wrong when tried to create link!\n------------------------------------------------------\n");
            }
            catch (IOException e) {
                System.out.println("\n--------------------------------------------------------\nSorry, something went wrong when tried to create the file!\n--------------------------------------------------------\n");
            }
        }
    }


    public static void saveStats() {
        try {
            PrintStream printStream = new PrintStream("statystyki.txt");
            System.out.println("Data have been saved.");

            printStream.println("===============Statistics of the operations on the file " + FileHandler.name + "===============\n\n");

            if(Main.letters==-1){
                printStream.println("\nCounting letters has not been executed");
            }
            else{
                printStream.println("\nLetters count: " + Main.letters);
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


    public static void endApplication () {
        Path exercise = Paths.get("text.txt");
        Path statistics = Paths.get("statystyki.txt");
        try {
            Files.deleteIfExists(exercise);
            Files.deleteIfExists(statistics);
        } catch (IOException e) {
            System.out.println("Something went wrong - " + e.getMessage());
        }
    }
}


