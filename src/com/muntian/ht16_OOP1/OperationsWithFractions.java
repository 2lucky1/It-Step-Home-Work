package com.muntian.ht16_OOP1;

import java.util.Scanner;

public class OperationsWithFractions {
    private static final short RANK_OF_FRACTION_PART = 10000;

    public static void main(String[] args) {
        Fractions fraction1 = new Fractions();
        Fractions fraction2 = new Fractions();

        enterOfInputData(fraction1, fraction2);

        printInputData(fraction1, fraction2);

        printResult(fraction1, fraction2);

        System.out.println();

        printTest();
    }

    private static void printInputData(Fractions fraction1, Fractions fraction2) {
        System.out.println("Input data:");
        System.out.print("The first member of operation: ");
        printFraction(fraction1);

        System.out.print("The second member of operation: ");
        printFraction(fraction2);
    }

    private static void printResult(Fractions fraction1, Fractions fraction2) {

        System.out.println("Result of addition:");
        printFraction(addition(fraction1, fraction2));

        System.out.println("Result of subtraction:");
        printFraction(subtraction(fraction1, fraction2));

        System.out.println("Result of multiplication:");
        printFraction(multiplication(fraction1, fraction2));
        System.out.println();

        System.out.println("Result of operation \"less\"");
        System.out.println(less(fraction1, fraction2));

        System.out.println("Result of operation \"more\"");
        System.out.println(more(fraction1, fraction2));

        System.out.println("Result of operation \"equal\"");
        System.out.println(equal(fraction1, fraction2));

        System.out.println("Result of operation \"less or equal\"");
        System.out.println(lessOrEqual(fraction1, fraction2));

        System.out.println("Result of operation \"more or equal\"");
        System.out.println(moreOrEqual(fraction1, fraction2));

        System.out.println("Result of operation \"not equal\"");
        System.out.println(notEqual(fraction1, fraction2));
    }

    private static void printTest() {
        System.out.print("Test for addition: ");
        if (testAddition()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for subtraction: ");
        if (testSubtraction()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for multiplication: ");
        if (testMultiplication()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for \"less\": ");
        if (testLess()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for \"more\": ");
        if (testMore()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for \"equal\": ");
        if (testEqual()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for \"less or equal\": ");
        if (testLessOrEqual()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for \"more or equal\": ");
        if (testMoreOrEqual()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for \"not equal\": ");
        if (testNotEqual()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

        System.out.print("Test for addition: ");
        if (testAddition()) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }

    }

    private static boolean testNotEqual() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        testF1.integerPart = 99;
        testF1.fractionalPart = 400;
        testF2.integerPart = -99;
        testF2.fractionalPart = 400;
        if (notEqual(testF1, testF2)) {
            return true;
        }
        return false;
    }

    private static boolean testMoreOrEqual() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        testF1.integerPart = 72;
        testF1.fractionalPart = 895;
        testF2.integerPart = 72;
        testF2.fractionalPart = 895;
        if (moreOrEqual(testF1, testF2)) {
            return true;
        }
        return false;
    }

    private static boolean testLessOrEqual() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        testF1.integerPart = 43;
        testF1.fractionalPart = 1;
        testF2.integerPart = 43;
        testF2.fractionalPart = 1;
        if (lessOrEqual(testF1, testF2)) {
            return true;
        }
        return false;
    }

    private static boolean testEqual() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        testF1.integerPart = 0;
        testF1.fractionalPart = 3947;
        testF2.integerPart = 0;
        testF2.fractionalPart = 3947;
        if (equal(testF1, testF2)) {
            return true;
        }
        return false;
    }

    private static boolean testMore() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        testF1.integerPart = -6;
        testF1.fractionalPart = 15;
        testF2.integerPart = -25;
        testF2.fractionalPart = 50;
        if (more(testF1, testF2)) {
            return true;
        }
        return false;
    }

    private static boolean testLess() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        testF1.integerPart = 56;
        testF1.fractionalPart = 251;
        testF2.integerPart = 78;
        testF2.fractionalPart = 101;
        if (less(testF1, testF2)) {
            return true;
        }
        return false;
    }

    private static boolean testMultiplication() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        Fractions expectedResult = new Fractions();
        testF1.integerPart = 24;
        testF1.fractionalPart = 97;
        testF2.integerPart = 732;
        testF2.fractionalPart = 9999;
        expectedResult.integerPart = 17599;
        expectedResult.fractionalPart = 1076;
        Fractions realResult = multiplication(testF1, testF2);
        if (realResult.integerPart == expectedResult.integerPart && realResult.fractionalPart == expectedResult.fractionalPart) {
            return true;
        }
        return false;
    }

    private static boolean testSubtraction() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        Fractions expectedResult = new Fractions();
        testF1.integerPart = 254;
        testF1.fractionalPart = 7;
        testF2.integerPart = 392;
        testF2.fractionalPart = 657;
        expectedResult.integerPart = -138;
        expectedResult.fractionalPart = 650;
        Fractions realResult = subtraction(testF1, testF2);
        if (realResult.integerPart == expectedResult.integerPart && realResult.fractionalPart == expectedResult.fractionalPart) {
            return true;
        }
        return false;
    }

    private static boolean testAddition() {
        Fractions testF1 = new Fractions();
        Fractions testF2 = new Fractions();
        Fractions expectedResult = new Fractions();
        testF1.integerPart = 21857;
        testF1.fractionalPart = 87;
        testF2.integerPart = 153;
        testF2.fractionalPart = 587;
        expectedResult.integerPart = 22010;
        expectedResult.fractionalPart = 674;
        Fractions realResult = addition(testF1, testF2);
        if (realResult.integerPart == expectedResult.integerPart && realResult.fractionalPart == expectedResult.fractionalPart) {
            return true;
        }
        return false;
    }

    private static void enterOfInputData(Fractions fraction1, Fractions fraction2) {
        fraction1.integerPart = getIntegerPart();
        fraction1.fractionalPart = getFractionalPart();
        fraction2.integerPart = getIntegerPart();
        fraction2.fractionalPart = getFractionalPart();
    }

    private static short getFractionalPart() {
        while (true) {
            System.out.println("Enter fractional part from 0 to 9999");
            Scanner input = new Scanner(System.in);
            if (input.hasNextShort()) {
                short f = input.nextShort();
                if (f >= 0 && f < 10000) {
                    return f;
                }
            }
            System.out.println("Input error: enter a number from the above range");
        }
    }

    private static long getIntegerPart() {
        while (true) {
            System.out.println("Enter the number of integer part from -9223372036854775808 to 9223372036854775807");
            Scanner input = new Scanner(System.in);
            if (input.hasNextLong()) {
                return input.nextLong();
            }
            System.out.println("Input error: enter a number from the above range");
        }
    }

    private static Fractions addition(Fractions firstSummand, Fractions secondSummand) {
        Fractions result = new Fractions();
        result.integerPart = firstSummand.integerPart + secondSummand.integerPart;
        if (firstSummand.integerPart >= 0 && secondSummand.integerPart >= 0) {
            additionOfFractionParts(firstSummand, secondSummand, result);
        } else if (firstSummand.integerPart < 0 && secondSummand.integerPart < 0) {
            if ((firstSummand.fractionalPart + secondSummand.fractionalPart) < RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) (firstSummand.fractionalPart + secondSummand.fractionalPart);
            } else if ((firstSummand.fractionalPart + secondSummand.fractionalPart) > RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) ((firstSummand.fractionalPart + secondSummand.fractionalPart) % RANK_OF_FRACTION_PART);
                result.integerPart--;
            }
        } else if (firstSummand.integerPart < 0 && secondSummand.integerPart >= 0) {
            subtractionOfFractionsParts(secondSummand, firstSummand, result);
        } else if (firstSummand.integerPart >= 0 && secondSummand.integerPart < 0) {
            subtractionOfFractionsParts(firstSummand, secondSummand, result);
        }
        return result;
    }

    private static void additionOfFractionParts(Fractions firstSummand, Fractions secondSummand, Fractions result) {
        if (firstSummand.integerPart < 0 && secondSummand.integerPart < 0) {
            if ((firstSummand.fractionalPart + secondSummand.fractionalPart) < RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) (firstSummand.fractionalPart + secondSummand.fractionalPart);
            } else if ((firstSummand.fractionalPart + secondSummand.fractionalPart) > RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) ((firstSummand.fractionalPart + secondSummand.fractionalPart) % RANK_OF_FRACTION_PART);
                result.integerPart--;
            }
        } else if ((firstSummand.fractionalPart + secondSummand.fractionalPart) < RANK_OF_FRACTION_PART) {
            result.fractionalPart = (short) (firstSummand.fractionalPart + secondSummand.fractionalPart);
        } else if ((firstSummand.fractionalPart + secondSummand.fractionalPart) > RANK_OF_FRACTION_PART) {
            result.fractionalPart = (short) ((firstSummand.fractionalPart + secondSummand.fractionalPart) % RANK_OF_FRACTION_PART);
            result.integerPart++;
        }
    }

    private static Fractions subtraction(Fractions minuend, Fractions subtracted) {
        Fractions result = new Fractions();
        result.integerPart = minuend.integerPart - subtracted.integerPart;
        if ((minuend.integerPart >= 0 && subtracted.integerPart >= 0)) {
            subtractionOfFractionsParts(minuend, subtracted, result);
        } else if ((minuend.integerPart < 0 && subtracted.integerPart < 0)) {
            subtractionOfFractionsParts(subtracted, minuend, result);
        } else if (minuend.integerPart >= 0 && subtracted.integerPart < 0) {
            additionOfFractionParts(minuend, subtracted, result);
        } else if (minuend.integerPart < 0 && subtracted.integerPart >= 0) {
            if ((minuend.fractionalPart + subtracted.fractionalPart) < RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) (minuend.fractionalPart + subtracted.fractionalPart);
            } else if ((minuend.fractionalPart + subtracted.fractionalPart) > RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) ((minuend.fractionalPart + subtracted.fractionalPart) % RANK_OF_FRACTION_PART);
                result.integerPart--;
            }
        }
        return result;
    }

    private static void subtractionOfFractionsParts(Fractions minuend, Fractions subtracted, Fractions result) {
        if (minuend.fractionalPart > subtracted.fractionalPart) {
            result.fractionalPart = (short) (minuend.fractionalPart - subtracted.fractionalPart);
        } else if (minuend.fractionalPart < subtracted.fractionalPart && minuend.integerPart > subtracted.integerPart) {
            result.fractionalPart = (short) (minuend.fractionalPart + RANK_OF_FRACTION_PART - subtracted.fractionalPart);
            result.integerPart--;
        } else if (minuend.fractionalPart < subtracted.fractionalPart && minuend.integerPart < subtracted.integerPart) {
            result.fractionalPart = (short) (subtracted.fractionalPart - minuend.fractionalPart);
        }
    }

    private static Fractions multiplication(Fractions firstMultiplier, Fractions secondMultiplier) {
        Fractions result = new Fractions();
        long firstIntPart = firstMultiplier.integerPart;
        long secondIntPart = secondMultiplier.integerPart;
        int firstFrcPart = firstMultiplier.fractionalPart;
        int secondFrcPart = secondMultiplier.fractionalPart;

        //Multiplication of integer parts
        result.integerPart = firstIntPart * secondIntPart;

        //Make operation members positive to be able to multiply correctly
        firstIntPart = makePositiveNumber(firstIntPart);
        secondIntPart = makePositiveNumber(secondIntPart);

        //Multiplication with fractional parts
        long temp = ((firstIntPart * secondFrcPart) + (secondIntPart * firstFrcPart) +
                (firstFrcPart * secondFrcPart) / RANK_OF_FRACTION_PART);

        //Extraction of integer part
        if (result.integerPart < 0) {
            result.integerPart = result.integerPart - temp / RANK_OF_FRACTION_PART;
        } else {
            result.integerPart = result.integerPart + temp / RANK_OF_FRACTION_PART;
        }

        //Extraction of fractional part
        result.fractionalPart = (short) (temp % RANK_OF_FRACTION_PART);
        return result;
    }

    private static boolean less(Fractions fraction1, Fractions fraction2) {
        if (fraction1.integerPart < fraction2.integerPart ||
                (fraction1.integerPart == fraction2.integerPart && fraction1.fractionalPart < fraction2.fractionalPart)) {
            return true;
        }
        return false;
    }

    private static boolean more(Fractions fraction1, Fractions fraction2) {
        if (fraction1.integerPart > fraction2.integerPart ||
                (fraction1.integerPart == fraction2.integerPart && fraction1.fractionalPart > fraction2.fractionalPart)) {
            return true;
        }
        return false;
    }

    private static boolean equal(Fractions fraction1, Fractions fraction2) {
        if (fraction1.integerPart == fraction2.integerPart && fraction1.fractionalPart == fraction2.fractionalPart) {
            return true;
        }
        return false;
    }

    private static boolean lessOrEqual(Fractions fraction1, Fractions fraction2) {
        if (fraction1.integerPart <= fraction2.integerPart ||
                (fraction1.integerPart == fraction2.integerPart && fraction1.fractionalPart <= fraction2.fractionalPart)) {
            return true;
        }
        return false;
    }

    private static boolean moreOrEqual(Fractions fraction1, Fractions fraction2) {
        if (fraction1.integerPart >= fraction2.integerPart ||
                (fraction1.integerPart == fraction2.integerPart && fraction1.fractionalPart >= fraction2.fractionalPart)) {
            return true;
        }
        return false;
    }

    private static boolean notEqual(Fractions fraction1, Fractions fraction2) {
        if (fraction1.integerPart != fraction2.integerPart ||
                (fraction1.integerPart == fraction2.integerPart && fraction1.fractionalPart != fraction2.fractionalPart)) {
            return true;
        }
        return false;
    }

    private static long makePositiveNumber(long memberOfOperation) {
        if (memberOfOperation < 0) {
            return memberOfOperation * (-1);
        }
        return memberOfOperation;
    }

    private static void printFraction(Fractions result) {
        if (result.fractionalPart >= 1000) {
            System.out.println(result.integerPart + "." + result.fractionalPart);
        } else if (result.fractionalPart >= 100) {
            System.out.println(result.integerPart + ".0" + result.fractionalPart);
        } else if (result.fractionalPart >= 10) {
            System.out.println(result.integerPart + ".00" + result.fractionalPart);
        } else if (result.fractionalPart < 10) {
            System.out.println(result.integerPart + ".000" + result.fractionalPart);
        }
    }
}
