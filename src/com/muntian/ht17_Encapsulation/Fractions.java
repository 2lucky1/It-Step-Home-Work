package com.muntian.ht17_Encapsulation;

public class Fractions {

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





}

