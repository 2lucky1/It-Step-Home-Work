package com.muntian.ht17_Encapsulation;

public class ActionsWithFractions {

    public static void main(String[] args) {
        Fractions fraction1 = new Fractions(10L, (short) 4000);
        Fractions fraction2 = new Fractions(21L, (short) 8567);

        printInputData(fraction1, fraction2);

        printResult(fraction1, fraction2);
    }

    private static void printInputData(Fractions fraction1, Fractions fraction2) {
        System.out.println("Input data:");
        System.out.print("The first member of operation: ");
        fraction1.printFraction();

        System.out.print("The second member of operation: ");
        fraction2.printFraction();
    }

    private static void printResult(Fractions fraction1, Fractions fraction2) {

        System.out.println("Result of addition:");
        fraction1.addition(fraction2).printFraction();

        System.out.println("Result of subtraction:");
        fraction1.subtraction(fraction2).printFraction();

        System.out.println("Result of multiplication:");
        fraction1.multiplication(fraction2).printFraction();
        System.out.println();

        System.out.println("Result of operation \"less\"");
        System.out.println(fraction1.less(fraction2));

        System.out.println("Result of operation \"more\"");
        System.out.println(fraction1.more(fraction2));

        System.out.println("Result of operation \"equal\"");
        System.out.println(fraction1.equal(fraction2));

        System.out.println("Result of operation \"less or equal\"");
        System.out.println(fraction1.lessOrEqual(fraction2));

        System.out.println("Result of operation \"more or equal\"");
        System.out.println(fraction1.moreOrEqual(fraction2));

        System.out.println("Result of operation \"not equal\"");
        System.out.println(fraction1.notEqual(fraction2));
    }
}

