package com.muntian.ht16_OOP1;

public class OperationsWithFractions {
    private static final short RANK_OF_FRACTION_PART = 10000;

    public static void main(String[] args) {
        Fractions fraction1 = new Fractions();
        Fractions fraction2 = new Fractions();
        fraction1.integerPart = +12L;
        fraction1.fractionalPart = 2300;
        fraction2.integerPart = -7L;
        fraction2.fractionalPart = 8700;

        System.out.println("Input data:");
        System.out.print("The first member of operation: ");
        printFraction(fraction1);

        System.out.print("The second member of operation: ");
        printFraction(fraction2);

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

//        less(fraction1, fraction2);
//        lessOrEqual(fraction1, fraction2);
//        more(fraction1, fraction2);
//        moreOrEqual(fraction1, fraction2);
//        equal(fraction1, fraction2);
//        notEqual(fraction1, fraction2);
    }

    private static Fractions addition(Fractions firstSummand, Fractions secondSummand) {
        Fractions result = new Fractions();
        result.integerPart = firstSummand.integerPart + secondSummand.integerPart;
        if (firstSummand.integerPart >= 0 && secondSummand.integerPart >= 0) {
            additionOfFractionParts(firstSummand, secondSummand, result);
        } else if (firstSummand.integerPart < 0 && secondSummand.integerPart < 0) {
            subtractionOfFractionsParts(firstSummand, secondSummand, result);
        } else if (firstSummand.integerPart < 0 && secondSummand.integerPart >= 0) {
            subtractionOfFractionsParts(secondSummand, firstSummand, result);
        } else if (firstSummand.integerPart >= 0 && secondSummand.integerPart < 0) {
            subtractionOfFractionsParts(firstSummand, secondSummand, result);
        }
        return result;
    }

    private static void additionOfFractionParts(Fractions firstSummand, Fractions secondSummand, Fractions result) {
        if ((firstSummand.fractionalPart + secondSummand.fractionalPart) < RANK_OF_FRACTION_PART) {
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
        } else if (minuend.fractionalPart < subtracted.fractionalPart) {
            result.fractionalPart = (short) (minuend.fractionalPart + RANK_OF_FRACTION_PART - subtracted.fractionalPart);
            result.integerPart--;
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
