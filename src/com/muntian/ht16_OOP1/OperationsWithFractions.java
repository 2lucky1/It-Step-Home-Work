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
        addition(fraction1, fraction2);
        subtraction(fraction1, fraction2);
        multiplication(fraction1, fraction2);
        printResult(multiplication(fraction1, fraction2));
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
        //Multiplication of integer parts
        result.integerPart = firstMultiplier.integerPart * secondMultiplier.integerPart;
        //Multiplication with fractional parts
        int tempIntegerPart = (int) ((firstMultiplier.integerPart * secondMultiplier.fractionalPart) / RANK_OF_FRACTION_PART +
                (secondMultiplier.integerPart * firstMultiplier.fractionalPart) / RANK_OF_FRACTION_PART +
                (firstMultiplier.fractionalPart * secondMultiplier.fractionalPart) / 1000000);
        //For convenience, we make tempIntegerPart always positive
        if (tempIntegerPart < 0) {
            tempIntegerPart = tempIntegerPart * (-1);
        }
        int tempIntegerPart2 = 0;
        int tempFractionPart = (int) ((secondMultiplier.fractionalPart * firstMultiplier.integerPart) % RANK_OF_FRACTION_PART +
                (secondMultiplier.integerPart * firstMultiplier.fractionalPart) % RANK_OF_FRACTION_PART +
                (firstMultiplier.fractionalPart * secondMultiplier.fractionalPart) % 1000000);
        if (tempFractionPart < 0) {
            tempFractionPart = tempIntegerPart * (-1);
        }
        if (tempFractionPart < RANK_OF_FRACTION_PART) {
            result.fractionalPart = (short) tempFractionPart;
        } else if (tempFractionPart > RANK_OF_FRACTION_PART) {
            tempIntegerPart2 = tempFractionPart / RANK_OF_FRACTION_PART;
            result.fractionalPart = (short) (tempFractionPart % RANK_OF_FRACTION_PART);
        }

//        //Extraction of the integer part
//        int additionalIntegerPart = tempFractionPart / RANK_OF_FRACTION_PART;
        //Adding the extracted to the main integer part
        if (result.integerPart >= 0) {
            result.integerPart = result.integerPart + tempIntegerPart + tempIntegerPart2;
        } else {
            result.integerPart = result.integerPart - tempIntegerPart - tempIntegerPart2;
        }
//        //Determination of fractional part
//        result.fractionalPart = (short) (tempFractionPart % RANK_OF_FRACTION_PART);
        return result;
    }

    private static void printResult(Fractions result) {
        double res = result.integerPart + (result.fractionalPart / RANK_OF_FRACTION_PART);
        System.out.println(res);
    }
}
