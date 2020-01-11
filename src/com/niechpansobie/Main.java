package com.niech_pan_sobie;
import java.io.File;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
	    menu();
    }

    static int words = -1;
    static int vowels= -1;
    static int cons = -1;
    static int sentences = -1;
    static int punctuationmarks = -1;

    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        String fileNameWhichExists = null;
        int choice = 0;

        while (choice != 8) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Do you want to download file from network?[Y/N]: ");
                    scanner.nextLine();
                    String downloadChoice = scanner.nextLine().trim();
                    fileNameWhichExists = FileHandler.getFile(downloadChoice);
                    break;
                case 2:
                    Counter.countLetters(fileNameWhichExists);
                    break;
                case 3:
                    Counter.countWords(fileNameWhichExists);
                    break;
                case 4:
                    Counter.countPunctuationMarks(fileNameWhichExists);
                    break;
                case 5:
                    Counter.countSentences(fileNameWhichExists);
                    break;
                case 6:
                    Counter.generateReport(fileNameWhichExists);
                    break;
                case 7:
                    FileHandler.saveStats();
                    break;
                case 8:
                    FileHandler.endApplication(fileNameWhichExists);
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.print("---===> MENU <===---\n" +
                "1. Download file\n" +
                "2. Count letters\n" +
                "3. Count words\n" +
                "4. Count punctuation marks\n" +
                "5. Count sentences\n" +
                "6. Generate report about letters(A-Z)\n" +
                "7. Save statistics to file statystyki.txt\n" +
                "8. Exit\n" +
                "Choice: ");
    }
}
