package com.muntian.ht17_Encapsulation;


public class ActionsWithFractions {
    private static final short RANK_OF_FRACTION_PART = 10000;
    private static final String INCORRECT_INPUT_DATA = "Incorrect input data for this program! Enter different values of integers parts of fractions.";

    public static void main(String[] args) {
        Fractions fraction1 = new Fractions(10L, (short) 4000);
        Fractions fraction2 = new Fractions(21L, (short) 8567);

        printInputData(fraction1, fraction2);

        printResult(fraction1, fraction2);
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

    private static Fractions addition(Fractions firstMember, Fractions secondMember) {
        Fractions result = new Fractions();
        //Create local members of operation to save input data from changes
        Fractions firstSummand = new Fractions();
        Fractions secondSummand = new Fractions();
        firstSummand.setIntegerPart(firstMember.getIntegerPart());
        firstSummand.setFractionalPart(firstMember.getFractionalPart());
        secondSummand.setIntegerPart(secondMember.getIntegerPart());
        secondSummand.setFractionalPart(secondMember.getFractionalPart());

        //Preliminary calculation of the integer part
        result.setIntegerPart(firstSummand.getIntegerPart() + secondSummand.getIntegerPart());

        //Calculation of the fractional part and correction of integer part (if it necessary)
        if (firstSummand.getIntegerPart() >= 0 && secondSummand.getIntegerPart() >= 0) {
            additionOfFractionalParts(firstSummand, secondSummand, result);
        } else if ((firstSummand.getIntegerPart() < 0 && secondSummand.getIntegerPart() < 0) ||
                (firstSummand.getIntegerPart() >= 0 && secondSummand.getIntegerPart() < 0)) {
            secondSummand.setIntegerPart(makePositiveNumber(secondSummand.getIntegerPart()));
            return subtraction(firstSummand, secondSummand);
        }else if (firstSummand.getIntegerPart() < 0 && secondSummand.getIntegerPart() >= 0) {
            firstSummand.setIntegerPart(makePositiveNumber(firstSummand.getIntegerPart()));
            return subtraction(secondSummand, firstSummand);
        }
        return result;
    }

    private static void additionOfFractionalParts(Fractions firstSummand, Fractions secondSummand, Fractions result) {
        if ((firstSummand.getFractionalPart() + secondSummand.getFractionalPart()) < RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) (firstSummand.getFractionalPart() + secondSummand.getFractionalPart()));
        } else if ((firstSummand.getFractionalPart() + secondSummand.getFractionalPart()) > RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) ((firstSummand.getFractionalPart() + secondSummand.getFractionalPart()) %
                    RANK_OF_FRACTION_PART));
            result.setIntegerPart(result.getIntegerPart() + 1);
        }
    }

    private static Fractions subtraction(Fractions minuend, Fractions subtracted) {
        Fractions result = new Fractions();

        //Preliminary calculation of the integer part
        result.setIntegerPart(minuend.getIntegerPart() - subtracted.getIntegerPart());

        //Calculation of the fractional part and correction of integer part (if it necessary)
        if ((minuend.getIntegerPart() >= 0 && subtracted.getIntegerPart() >= 0) ||
                (minuend.getIntegerPart() < 0 && subtracted.getIntegerPart() < 0)) {
            if (minuend.getFractionalPart() == subtracted.getFractionalPart()) {
                System.out.println(INCORRECT_INPUT_DATA);
                return result;
            } else {
                subtractionOfFractionalParts(minuend, subtracted, result);
            }
        } else if (minuend.getIntegerPart() >= 0 && subtracted.getIntegerPart() < 0) {
            additionOfFractionalParts(minuend, subtracted, result);
        } else if (minuend.getIntegerPart() < 0 && subtracted.getIntegerPart() >= 0) {
            subtractionOfFractionalPartsOfNegativeFractions(minuend, subtracted, result);
        }
        return result;
    }

    private static void subtractionOfFractionalParts(Fractions minuend, Fractions subtracted, Fractions result) {
        if (minuend.getIntegerPart() >= 0 && subtracted.getIntegerPart() >= 0) {
            if (minuend.getIntegerPart() == subtracted.getIntegerPart()) {
                System.out.println(INCORRECT_INPUT_DATA);
            } else {
                correctSubtractionOfFractionalParts(minuend, subtracted, result);
            }
        } else if (minuend.getIntegerPart() < 0 && subtracted.getIntegerPart() < 0) {
            if (minuend.getIntegerPart() == subtracted.getIntegerPart()) {
                if (minuend.getFractionalPart() > subtracted.getFractionalPart()) {
                    System.out.println(INCORRECT_INPUT_DATA);
                } else {
                    result.setFractionalPart((short) (subtracted.getFractionalPart() - minuend.getFractionalPart()));
                }
            } else if (minuend.getIntegerPart() > subtracted.getIntegerPart()) {
                if (minuend.getFractionalPart() > subtracted.getFractionalPart()) {
                    result.setFractionalPart((short) (subtracted.getFractionalPart() + RANK_OF_FRACTION_PART - minuend.getFractionalPart()));
                    result.setIntegerPart(result.getIntegerPart() - 1);
                } else {
                    result.setFractionalPart((short) (subtracted.getFractionalPart() - minuend.getFractionalPart()));
                }
            } else if (minuend.getIntegerPart() < subtracted.getIntegerPart()) {
                if (minuend.getFractionalPart() >= subtracted.getFractionalPart()) {
                    result.setFractionalPart((short) (minuend.getFractionalPart() - subtracted.getFractionalPart()));
                } else {
                    result.setFractionalPart((short) (minuend.getFractionalPart() + RANK_OF_FRACTION_PART - subtracted.getFractionalPart()));
                    result.setIntegerPart(result.getIntegerPart() + 1);
                }
            }
        } else if (minuend.getIntegerPart() >= 0 && subtracted.getIntegerPart() < 0) {
            additionOfFractionalParts(minuend, subtracted, result);
        } else if (minuend.getIntegerPart() < 0 && subtracted.getIntegerPart() >= 0) {
            subtractionOfFractionalPartsOfNegativeFractions(minuend, subtracted, result);
        }
    }

    private static void subtractionOfFractionalPartsOfNegativeFractions(Fractions minuend, Fractions subtracted, Fractions result) {
        if ((minuend.getFractionalPart() + subtracted.getFractionalPart()) < RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) (minuend.getFractionalPart() + subtracted.getFractionalPart()));
        } else if ((minuend.getFractionalPart() + subtracted.getFractionalPart()) > RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) ((minuend.getFractionalPart() + subtracted.getFractionalPart()) % RANK_OF_FRACTION_PART));
            result.setIntegerPart(result.getIntegerPart() - 1);
        }
    }

    private static void correctSubtractionOfFractionalParts(Fractions minuend, Fractions subtracted, Fractions result) {
        if (minuend.getIntegerPart() > subtracted.getIntegerPart()) {
            if (minuend.getFractionalPart() < subtracted.getFractionalPart()) {
                result.setFractionalPart((short) (minuend.getFractionalPart() + RANK_OF_FRACTION_PART - subtracted.getFractionalPart()));
                result.setIntegerPart(result.getIntegerPart() + 1);
            } else {
                result.setFractionalPart((short) (minuend.getFractionalPart() - subtracted.getFractionalPart()));
            }
        } else if (minuend.getIntegerPart() < subtracted.getIntegerPart()) {
            if (minuend.getFractionalPart() >= subtracted.getFractionalPart()) {
                result.setFractionalPart((short) (subtracted.getFractionalPart() + RANK_OF_FRACTION_PART - minuend.getFractionalPart()));
                result.setIntegerPart(result.getIntegerPart() + 1);
            } else {
                result.setFractionalPart((short) (subtracted.getFractionalPart() - minuend.getFractionalPart()));
            }
        }
    }

    private static Fractions multiplication(Fractions firstMultiplier, Fractions secondMultiplier) {
        Fractions result = new Fractions();
        //Create local members of operation to save input data from changes
        long firstIntPart = firstMultiplier.getIntegerPart();
        long secondIntPart = secondMultiplier.getIntegerPart();
        int firstFrcPart = firstMultiplier.getFractionalPart();
        int secondFrcPart = secondMultiplier.getFractionalPart();

        //Multiplication of integer parts
        result.setIntegerPart(firstIntPart * secondIntPart);

        //Make operation members positive to be able to multiply correctly
        firstIntPart = makePositiveNumber(firstIntPart);
        secondIntPart = makePositiveNumber(secondIntPart);

        //Multiplication with fractional parts
        long temp = ((firstIntPart * secondFrcPart) + (secondIntPart * firstFrcPart) +
                (firstFrcPart * secondFrcPart) / RANK_OF_FRACTION_PART);

        //Extraction of integer part
        if (result.getIntegerPart() < 0) {
            result.setIntegerPart(result.getIntegerPart() - temp / RANK_OF_FRACTION_PART);
        } else {
            result.setIntegerPart(result.getIntegerPart() + temp / RANK_OF_FRACTION_PART);
        }

        //Extraction of fractional part
        result.setFractionalPart((short) (temp % RANK_OF_FRACTION_PART));
        return result;
    }

    private static boolean less(Fractions fraction1, Fractions fraction2) {
        return fraction1.getIntegerPart() < fraction2.getIntegerPart() ||
                (fraction1.getIntegerPart() == fraction2.getIntegerPart() && fraction1.getFractionalPart() < fraction2.getFractionalPart());
    }

    private static boolean more(Fractions fraction1, Fractions fraction2) {
        return fraction1.getIntegerPart() > fraction2.getIntegerPart() ||
                (fraction1.getIntegerPart() == fraction2.getIntegerPart() && fraction1.getFractionalPart() > fraction2.getFractionalPart());
    }

    private static boolean equal(Fractions fraction1, Fractions fraction2) {
        return fraction1.getIntegerPart() == fraction2.getIntegerPart() && fraction1.getFractionalPart() == fraction2.getFractionalPart();
    }

    private static boolean lessOrEqual(Fractions fraction1, Fractions fraction2) {
        return fraction1.getIntegerPart() <= fraction2.getIntegerPart() ||
                (fraction1.getIntegerPart() == fraction2.getIntegerPart() && fraction1.getFractionalPart() <= fraction2.getFractionalPart());
    }

    private static boolean moreOrEqual(Fractions fraction1, Fractions fraction2) {
        return fraction1.getIntegerPart() >= fraction2.getIntegerPart() ||
                (fraction1.getIntegerPart() == fraction2.getIntegerPart() && fraction1.getFractionalPart() >= fraction2.getFractionalPart());
    }

    private static boolean notEqual(Fractions fraction1, Fractions fraction2) {
        return fraction1.getIntegerPart() != fraction2.getIntegerPart() ||
                (fraction1.getIntegerPart() == fraction2.getIntegerPart() && fraction1.getFractionalPart() != fraction2.getFractionalPart());
    }

    private static long makePositiveNumber(long memberOfOperation) {
        if (memberOfOperation < 0) {
            return memberOfOperation * (-1);
        }
        return memberOfOperation;
    }

    private static void printFraction(Fractions result) {
        if (result.getFractionalPart() >= 1000) {
            System.out.println(result.getIntegerPart() + "." + result.getFractionalPart());
        } else if (result.getFractionalPart() >= 100) {
            System.out.println(result.getIntegerPart() + ".0" + result.getFractionalPart());
        } else if (result.getFractionalPart() >= 10) {
            System.out.println(result.getIntegerPart() + ".00" + result.getFractionalPart());
        } else if (result.getFractionalPart() < 10) {
            System.out.println(result.getIntegerPart() + ".000" + result.getFractionalPart());
        }
    }
}

