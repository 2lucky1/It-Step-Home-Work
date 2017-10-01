package com.muntian.ht24_CloneableInPassport;

public class Passport implements Cloneable {
    private String passportSeries;
    private int passportNumber;
    private String lastName;
    private String name;
    private String patronymic;
    private String dateOfBirth;
    private String residency;

    public Passport(String passportSeries, int passportNumber, String lastName, String name, String patronymic,
                    String dateOfBirth, String residency) {
        this.passportSeries = passportSeries;
        this.passportNumber = passportNumber;
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.dateOfBirth = dateOfBirth;
        this.residency = residency;
    }

    public Passport(){

    }

    public String getPassportSeries() {
        return passportSeries;
    }

    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    public int getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getResidency() {
        return residency;
    }

    public void setResidency(String residency) {
        this.residency = residency;
    }

    public void printPassport(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Passport{" +
                "passportSeries='" + this.passportSeries + '\'' +
                ", passportNumber=" + this.passportNumber +
                ", lastName='" + this.lastName + '\'' +
                ", name='" + this.name + '\'' +
                ", patronymic='" + this.patronymic + '\'' +
                ", dateOfBirth='" + this.dateOfBirth + '\'' +
                ", residency='" + this.residency + '\'' +
                '}';
    }

    @Override
    public Passport clone() throws CloneNotSupportedException {
        return (Passport) super.clone();
    }
}

