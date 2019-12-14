package com.niech_pan_sobie;

import java.io.*;
import java.net.*;

public class FileHandler {
    private static final String urlToFile = "https://s3.zylowski.net/public/input/6.txt";
    private static final String name = "text.txt";
    public static void downloadFile() throws IOException {
        URL url;
        {
            try {
                url = new URL(urlToFile);
                try (InputStream in = url.openStream();
                     BufferedInputStream bis = new BufferedInputStream(in);
                     FileOutputStream fos = new FileOutputStream(name)) {

                    byte data[] = new byte[1024];
                    int count;
                    while ((count = bis.read(data, 0, 1024)) != -1) {
                        fos.write(data, 0, count);
                    }
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


