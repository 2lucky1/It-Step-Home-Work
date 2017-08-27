package com.muntian.ht16_OOP1;

public class OperationsWithFractions {
    public static void main(String[] args) {
        Fractions fraction1 = new Fractions();
        Fractions fraction2 = new Fractions();
        fraction1.integerPart = +12L;
        fraction1.fractionalPart = 2300;
        fraction2.integerPart = -7L;
        fraction2.fractionalPart = 8700;
        addition(fraction1,fraction2);
        subtraction(fraction1,fraction2);
        multiplication(fraction1,fraction2);
        comperison(fraction1,fraction2);
    }

    private static Fractions addition(Fractions fraction1, Fractions fraction2) {
        Fractions result = new Fractions();
result.integerPart = fraction1.integerPart+fraction2.integerPart;
    if (fraction1.integerPart>0&&fraction2.integerPart>0){
        result.fractionalPart = (short) (fraction1.fractionalPart+fraction2.fractionalPart);
    }
}
        return null;
    }
}
