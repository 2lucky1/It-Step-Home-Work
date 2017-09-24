package com.muntian.ht24_CloneableInPassport;

public class Visa implements Cloneable {
    private String country;
    private String typeOfVisa;
    private String dateOfOpening;
    private String dateOfClosure;

    public Visa(String country, String typeOfVisa, String dateOfOpening, String dateOfClosure) {
        this.country = country;
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

    public String getDateOfOpening() {
        return dateOfOpening;
    }

    public void setDateOfOpening(String dateOfOpening) {
        this.dateOfOpening = dateOfOpening;
    }

    public String getDateOfClosure() {
        return dateOfClosure;
    }

    public void setDateOfClosure(String dateOfClosure) {
        this.dateOfClosure = dateOfClosure;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Visa{" +
                "country='" + this.country + '\'' +
                ", typeOfVisa='" + this.typeOfVisa + '\'' +
                ", dateOfOpening='" + this.dateOfOpening + '\'' +
                ", dateOfClosure='" + this.dateOfClosure + '\'' +
                '}';
    }

    @Override
    public Visa clone() throws CloneNotSupportedException {
        return (Visa) super.clone();
    }
}
