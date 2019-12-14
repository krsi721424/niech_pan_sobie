package com.niech_pan_sobie;

import java.io.*;
import java.net.*;

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

    public static void endApplication () {
        Path text = Paths.get("text.txt");
        Path statistics = Paths.get("statystyki.txt");
        try {
            Files.deleteIfExists(text);
            Files.deleteIfExists(statistics);
        } catch (IOException e) {
            System.out.println("Something went wrong - " + e.getMessage());
        }
    }
}


