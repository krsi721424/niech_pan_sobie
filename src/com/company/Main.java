package com.company;

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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
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