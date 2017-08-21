package com.muntian.ht13_recursion;

import java.util.Scanner;

public class FlipTheNumber {

    public static void main(String[] args) {
        int index = 0;
        int testNumber = 777888;
        int testReversedNumber = 888777;
        int userNumber = enterNaturalNumber();
        System.out.println(getReversedNumber(userNumber, index));
        test(testNumber, testReversedNumber, index);

    }

    private static int getReversedNumber(int userNumber, int index) {
        return Integer.parseInt(reverseOfString(userNumber, index));
    }

    private static String convertNumberToString(int userNumber) {
        return String.valueOf(userNumber);
    }

    private static int enterNaturalNumber() {
        while (true) {
            System.out.println("Enter the number");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int userNumber = input.nextInt();
                if (userNumber > 0) {
                    return userNumber;
                }
            } else {
                System.out.println("Input error: Enter a natural integer number");
            }
        }
    }

    private static String reverseOfString(int userNumber, int index) {
        String enterByUser = convertNumberToString(userNumber);
        return (index == enterByUser.length()) ? "" : reverseOfString(userNumber, index + 1) + enterByUser.charAt(index);
    }

    private static void test(int testNumber, int testReversedNumber, int index) {
        if (getReversedNumber(testNumber, index) == testReversedNumber) {
            System.out.println("Test passed!");
        } else {
            System.out.println("The test is failed!");
        }

    }
}
