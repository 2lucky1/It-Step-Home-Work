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
        less(fraction1, fraction2);
        lessOrEqual(fraction1, fraction2);
        more(fraction1, fraction2);
        moreOrEqual(fraction1, fraction2);
        equal(fraction1, fraction2);
        notEqual(fraction1, fraction2);
    }

    private static Fractions addition(Fractions firstSummand, Fractions secondSummand) {
        Fractions result = new Fractions();
        result.integerPart = firstSummand.integerPart + secondSummand.integerPart;
        if (firstSummand.integerPart >= 0 && secondSummand.integerPart >= 0) {
            if ((firstSummand.fractionalPart + secondSummand.fractionalPart) < RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) (firstSummand.fractionalPart + secondSummand.fractionalPart);
            } else if ((firstSummand.fractionalPart + secondSummand.fractionalPart) > RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) ((firstSummand.fractionalPart + secondSummand.fractionalPart) % RANK_OF_FRACTION_PART);
                result.integerPart++;
            }
        } else if (firstSummand.integerPart < 0 && secondSummand.integerPart < 0) {
            if ((firstSummand.fractionalPart + secondSummand.fractionalPart) < RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) (firstSummand.fractionalPart + secondSummand.fractionalPart);
            } else if ((firstSummand.fractionalPart + secondSummand.fractionalPart) > RANK_OF_FRACTION_PART) {
                result.fractionalPart = (short) ((firstSummand.fractionalPart + secondSummand.fractionalPart) % RANK_OF_FRACTION_PART);
                result.integerPart--;
            }
        } else if (firstSummand.integerPart < 0 && secondSummand.integerPart >= 0) {
            if (secondSummand.fractionalPart > firstSummand.fractionalPart) {
                result.fractionalPart = (short) (secondSummand.fractionalPart - firstSummand.fractionalPart);
            } else if (secondSummand.fractionalPart < firstSummand.fractionalPart) {
                result.fractionalPart = (short) (secondSummand.fractionalPart + RANK_OF_FRACTION_PART - firstSummand.fractionalPart);
                result.integerPart--;
            }
        } else if (firstSummand.integerPart >= 0 && secondSummand.integerPart < 0) {
            if (firstSummand.fractionalPart > secondSummand.fractionalPart) {
                result.fractionalPart = (short) (firstSummand.fractionalPart - secondSummand.fractionalPart);
            } else if (firstSummand.fractionalPart < secondSummand.fractionalPart) {
                result.fractionalPart = (short) (firstSummand.fractionalPart + RANK_OF_FRACTION_PART - secondSummand.fractionalPart);
                result.integerPart--;
            }
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

        } else if (minuend.integerPart >= 0 && subtracted.integerPart < 0) {
            additionOfFractionParts(minuend, subtracted, result);
        } else if (minuend.integerPart < 0 && subtracted.integerPart >= 0) {
            result.fractionalPart = (short) (subtracted.fractionalPart + minuend.fractionalPart);
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

    //    || (minuend.integerPart < 0 && subtracted.integerPart < 0))
    private static Fractions multiplication(Fractions firstMultiplier, Fractions secondMultiplier) {
        Fractions result = new Fractions();
        //Multiplication of integer parts
        result.integerPart = firstMultiplier.integerPart * secondMultiplier.integerPart;
        //Multiplication with fractional parts
        int tempFractionPart = (int) (secondMultiplier.fractionalPart * firstMultiplier.integerPart +
                secondMultiplier.integerPart * firstMultiplier.fractionalPart +
                firstMultiplier.fractionalPart * secondMultiplier.fractionalPart);
        //For convenience, we make tempFractionPart always positive
        if (tempFractionPart < 0) {
            tempFractionPart = tempFractionPart * (-1);
        }
        //Extraction of the integer part
        int additionalIntegerPart = tempFractionPart / RANK_OF_FRACTION_PART;
        //Adding the extracted to the main integer part
        if (result.integerPart >= 0) {
            result.integerPart = result.integerPart + additionalIntegerPart;
        } else {
            result.integerPart = result.integerPart - additionalIntegerPart;
        }
        //Determination of fractional part
        result.fractionalPart = (short) (tempFractionPart % RANK_OF_FRACTION_PART);
        return result;
    }
}
