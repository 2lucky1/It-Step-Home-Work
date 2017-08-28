package com.muntian.ht13_recursion;

import java.util.Scanner;

public class FlipTheNumber {

    public static void main(String[] args) {
        int testNumber = 777888;
        int expectedReversedNumber = 888777;
        int userNumber = enterNaturalNumber();
        System.out.println(getReversedNumber(userNumber,getNumberLengths(userNumber)));
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

    private static int getReversedNumber(int userNumber,int lengthsOfNumber) {
        int pow = lengthsOfNumber-1;
        if (pow == 0) {
            return (int) (userNumber * Math.pow(10, pow));
        }
        int reversedNumber = (int) (userNumber % 10 * Math.pow(10, pow));
        userNumber = userNumber / 10;
        lengthsOfNumber--;
        return reversedNumber + getReversedNumber(userNumber,lengthsOfNumber);
    }

    private static void test(int testNumber, int testReversedNumber) {
        if (getReversedNumber(testNumber,getNumberLengths(testNumber)) == testReversedNumber) {
            System.out.println("Test passed!");
        } else {
            System.out.println("The test is failed!");
        }
    }
}
