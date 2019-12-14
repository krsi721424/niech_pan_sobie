package com.niech_pan_sobie;
import java.io.IOException;
import java.util.Scanner;



public class Main {

    public static void main(String[] args) {
	    menu();
    }


    private static void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 8) {
            printMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    FileHandler.downloadFile();
                    break;
                case 2:
                    Counter.countLetters();
                    break;
                case 3:
                    Counter.countWords();
                    break;
                case 4:
                    Counter.countPunctuaionMarks();
                    break;
                case 5:
                    break;
                case 6:
                    Counter.generateReport();
                    break;
                case 7:
                    break;
                case 8:
                    FileHandler.endApplication();
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
