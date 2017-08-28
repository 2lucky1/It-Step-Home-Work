package com.muntian.ht13_recursion;

import java.util.Scanner;

public class FlipTheNumber {

    public static void main(String[] args) {
        int testNumber = 777888;
        int expectedReversedNumber = 888777;
        int userNumber = enterNaturalNumber();
        int lengths = getNumberLengths(userNumber);
        System.out.println(userNumber + " userNumber; " + lengths + " numberLengths.");
        System.out.println(getReversedNumber(userNumber, lengths));
        test(testNumber, expectedReversedNumber);
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
            }
            System.out.println("Input error: Enter a natural integer number from 1 to plus infinity");
        }
    }

    private static int getNumberLengths(int userNumber) {
        if (userNumber < 10) {
            return 1;
        }
        userNumber = userNumber / 10;
        return getNumberLengths(userNumber) + 1;
    }

    private static int getReversedNumber(int userNumber, int lengthsOfUserNumber) {
        int result = 0;
        if (lengthsOfUserNumber == 1) {
            return userNumber;
        }
        for (int i = lengthsOfUserNumber; i > 0; i--) {
            result = (int) (result + userNumber % 10 * Math.pow(10, i - 1));
            userNumber = userNumber / 10;
        }
        return result;
    }

    private static void test(int testNumber, int testReversedNumber) {
        if (getReversedNumber(testNumber, getNumberLengths(testNumber)) == testReversedNumber) {
            System.out.println("Test passed!");
        } else {
            System.out.println("The test is failed!");
        }
    }
}
