package com.muntian.ht20_Passport;

public class Visa {
    private String typeOfVisa;
    private int dateOfOpening;
    private int dateOfClosure;

    public Visa(String typeOfVisa, int dateOfOpening, int dateOfClosure) {
        this.typeOfVisa = typeOfVisa;
        this.dateOfOpening = dateOfOpening;
        this.dateOfClosure = dateOfClosure;
    }

    public Visa() {

    }

    public String getTypeOfVisa() {
        return typeOfVisa;
    }

    public void setTypeOfVisa(String typeOfVisa) {
        this.typeOfVisa = typeOfVisa;
    }

    public int getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(int dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public int getDateOfClosure() {
        return dateOfClosure;
    }

    public void setDateOfClosure(int dateOfClosure) {
        this.dateOfClosure = dateOfClosure;
    }
}
