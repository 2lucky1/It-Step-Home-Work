package com.muntian.ht20_Passport;

public class ForeignPassport extends Passport {
    private String passportSeries;
    private int passportNumber;
    private Visa [] visa;

    public ForeignPassport(String passportSeries, int passportNumber, String lastName, String name, String patronymic, int dayOfBirth, int monthOfBirth, int yearOfBirth, String residency, Visa[] visa) {
        super(passportSeries, passportNumber, lastName, name, patronymic, dayOfBirth, monthOfBirth, yearOfBirth, residency);
        this.visa = visa;
    }

    @Override
    public String getPassportSeries() {
        return passportSeries;
    }

    @Override
    public void setPassportSeries(String passportSeries) {
        this.passportSeries = passportSeries;
    }

    @Override
    public int getPassportNumber() {
        return passportNumber;
    }

    @Override
    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }
}
