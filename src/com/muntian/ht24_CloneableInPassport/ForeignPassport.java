package com.muntian.ht24_CloneableInPassport;

public class ForeignPassport extends Passport implements Cloneable {

    public static final int INCREASING_NUMBER_OF_VISAS_ARRAY = 10;
    private int count = 0;
    private Visa[] listOfVisas = new Visa[count];

    public ForeignPassport(String passportSeries, int passportNumber, String lastName, String name, String patronymic,
                           String dateOfBirth, String residency) {
        super(passportSeries, passportNumber, lastName, name, patronymic, dateOfBirth, residency);
    }

    public Visa[] getListOfVisas() {
        return listOfVisas.clone();
    }

    public void addVisa(String country, String typeOfVisa, String dateOfOpening, String dateOfClosure) {
        Visa[] temp = listOfVisas.clone();
        if (listOfVisas.length >= count) {
            listOfVisas = new Visa[listOfVisas.length + INCREASING_NUMBER_OF_VISAS_ARRAY];
        }
        for (int i = 0; i < temp.length; i++) {
            listOfVisas[i] = temp[i];
        }
        Visa visa = new Visa(country, typeOfVisa, dateOfOpening, dateOfClosure);
        this.listOfVisas[count++] = visa;
    }

    @Override
    public void printPassport() {
        super.printPassport();
        if (count > 0) {
            System.out.println("Visas information:");
            for (int i = 0; i < count; i++) {
                System.out.println(this.getListOfVisas()[i]);
            }
        }
    }

    @Override
    public ForeignPassport clone() throws CloneNotSupportedException {
        ForeignPassport clone = (ForeignPassport) super.clone();
        clone.listOfVisas = this.getListOfVisas();
        return clone;
    }
}
