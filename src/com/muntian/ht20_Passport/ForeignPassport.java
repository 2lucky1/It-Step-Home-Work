package com.muntian.ht20_Passport;

public class ForeignPassport extends Passport {
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
        listOfVisas = new Visa[count + 1];
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
            for (int i = 0; i < this.getListOfVisas().length; i++) {
                System.out.println(this.getListOfVisas()[i]);
            }
        }
    }
}
