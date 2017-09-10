package com.muntian.ht17_Encapsulation;

public class Fractions {
    private static final short RANK_OF_FRACTION_PART = 10000;
    private static final String INCORRECT_INPUT_DATA = "Incorrect input data for this program! Enter different values of integers parts of fractions.";
    private long integerPart;
    private short fractionalPart;

    public Fractions(long integerPart, short fractionalPart) {
        this.integerPart = integerPart;
        this.fractionalPart = fractionalPart;
    }

    Fractions() {

    }

    public long getIntegerPart() {
        return integerPart;
    }

    public void setIntegerPart(long integerPart) {
        this.integerPart = integerPart;
    }

    public short getFractionalPart() {
        return fractionalPart;
    }

    public void setFractionalPart(short fractionalPart) {
        this.fractionalPart = fractionalPart;
    }


    public Fractions addition(Fractions secondFraction) {
        Fractions result = new Fractions();
        //Create local members of operation to save input data from changes
        Fractions firstSummand = new Fractions();
        Fractions secondSummand = new Fractions();
        firstSummand.setIntegerPart(this.getIntegerPart());
        firstSummand.setFractionalPart(this.getFractionalPart());
        secondSummand.setIntegerPart(secondFraction.getIntegerPart());
        secondSummand.setFractionalPart(secondFraction.getFractionalPart());

        //Preliminary calculation of the integer part
        result.setIntegerPart(firstSummand.getIntegerPart() + secondSummand.getIntegerPart());

        //Calculation of the fractional part and correction of integer part (if it necessary)
        if (firstSummand.getIntegerPart() >= 0 && secondSummand.getIntegerPart() >= 0) {
            additionOfFractionalParts(firstSummand, secondSummand, result);
        } else if ((firstSummand.getIntegerPart() < 0 && secondSummand.getIntegerPart() < 0) ||
                (firstSummand.getIntegerPart() >= 0 && secondSummand.getIntegerPart() < 0)) {
            secondSummand.setIntegerPart(makePositiveNumber(secondSummand.getIntegerPart()));
            return firstSummand.subtraction(secondSummand);
        }else if (firstSummand.getIntegerPart() < 0 && secondSummand.getIntegerPart() >= 0) {
            firstSummand.setIntegerPart(makePositiveNumber(firstSummand.getIntegerPart()));
            return secondSummand.subtraction(firstSummand);
        }
        return result;
    }

    private void additionOfFractionalParts(Fractions firstSummand, Fractions secondSummand, Fractions result) {
        if ((firstSummand.getFractionalPart() + secondSummand.getFractionalPart()) < RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) (firstSummand.getFractionalPart() + secondSummand.getFractionalPart()));
        } else if ((firstSummand.getFractionalPart() + secondSummand.getFractionalPart()) > RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) ((firstSummand.getFractionalPart() + secondSummand.getFractionalPart()) %
                    RANK_OF_FRACTION_PART));
            result.setIntegerPart(result.getIntegerPart() + 1);
        }
    }

    public Fractions subtraction(Fractions subtracted) {
        Fractions result = new Fractions();

        //Preliminary calculation of the integer part
        result.setIntegerPart(this.getIntegerPart() - subtracted.getIntegerPart());

        //Calculation of the fractional part and correction of integer part (if it necessary)
        if ((this.getIntegerPart() >= 0 && subtracted.getIntegerPart() >= 0) ||
                (this.getIntegerPart() < 0 && subtracted.getIntegerPart() < 0)) {
            if (this.getFractionalPart() == subtracted.getFractionalPart()) {
                System.out.println(INCORRECT_INPUT_DATA);
                return result;
            } else {
                subtractionOfFractionalParts(this, subtracted, result);
            }
        } else if (this.getIntegerPart() >= 0 && subtracted.getIntegerPart() < 0) {
            additionOfFractionalParts(this, subtracted, result);
        } else if (this.getIntegerPart() < 0 && subtracted.getIntegerPart() >= 0) {
            subtractionOfFractionalPartsOfNegativeFractions(this, subtracted, result);
        }
        return result;
    }

    private void subtractionOfFractionalParts(Fractions minuend, Fractions subtracted, Fractions result) {
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

    private void subtractionOfFractionalPartsOfNegativeFractions(Fractions minuend, Fractions subtracted, Fractions result) {
        if ((minuend.getFractionalPart() + subtracted.getFractionalPart()) < RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) (minuend.getFractionalPart() + subtracted.getFractionalPart()));
        } else if ((minuend.getFractionalPart() + subtracted.getFractionalPart()) > RANK_OF_FRACTION_PART) {
            result.setFractionalPart((short) ((minuend.getFractionalPart() + subtracted.getFractionalPart()) % RANK_OF_FRACTION_PART));
            result.setIntegerPart(result.getIntegerPart() - 1);
        }
    }

    private void correctSubtractionOfFractionalParts(Fractions minuend, Fractions subtracted, Fractions result) {
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

    public Fractions multiplication(Fractions secondMultiplier) {
        Fractions result = new Fractions();
        //Create local members of operation to save input data from changes
        long firstIntPart = this.getIntegerPart();
        int firstFrcPart = this.getFractionalPart();
        long secondIntPart = secondMultiplier.getIntegerPart();
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

    private long makePositiveNumber(long memberOfOperation) {
        if (memberOfOperation < 0) {
            return memberOfOperation * (-1);
        }
        return memberOfOperation;
    }

    public boolean less(Fractions fraction2) {
        return this.getIntegerPart() < fraction2.getIntegerPart() ||
                (this.getIntegerPart() == fraction2.getIntegerPart() && this.getFractionalPart() < fraction2.getFractionalPart());
    }

    public boolean more(Fractions fraction2) {
        return this.getIntegerPart() > fraction2.getIntegerPart() ||
                (this.getIntegerPart() == fraction2.getIntegerPart() && this.getFractionalPart() > fraction2.getFractionalPart());
    }

    public boolean equal(Fractions fraction2) {
        return this.getIntegerPart() == fraction2.getIntegerPart() && this.getFractionalPart() == fraction2.getFractionalPart();
    }

    public boolean lessOrEqual(Fractions fraction2) {
        return this.getIntegerPart() <= fraction2.getIntegerPart() ||
                (this.getIntegerPart() == fraction2.getIntegerPart() && this.getFractionalPart() <= fraction2.getFractionalPart());
    }

    public boolean moreOrEqual(Fractions fraction2) {
        return this.getIntegerPart() >= fraction2.getIntegerPart() ||
                (this.getIntegerPart() == fraction2.getIntegerPart() && this.getFractionalPart() >= fraction2.getFractionalPart());
    }

    public boolean notEqual(Fractions fraction2) {
        return this.getIntegerPart() != fraction2.getIntegerPart() ||
                (this.getIntegerPart() == fraction2.getIntegerPart() && this.getFractionalPart() != fraction2.getFractionalPart());
    }

    public void printFraction() {
        if (this.getFractionalPart() >= 1000) {
            System.out.println(this.getIntegerPart() + "." + this.getFractionalPart());
        } else if (this.getFractionalPart() >= 100) {
            System.out.println(this.getIntegerPart() + ".0" + this.getFractionalPart());
        } else if (this.getFractionalPart() >= 10) {
            System.out.println(this.getIntegerPart() + ".00" + this.getFractionalPart());
        } else if (this.getFractionalPart() < 10) {
            System.out.println(this.getIntegerPart() + ".000" + this.getFractionalPart());
        }
    }

}

