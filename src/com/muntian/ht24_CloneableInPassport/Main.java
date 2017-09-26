package com.muntian.ht24_CloneableInPassport;

public class Main {
    public static void main(String[] args) {

        //Create ukrainian passport
        Passport passportOfUkrainian = new Passport("АН", 450974, "Горбунков",
                "Семен", "Семенович", "22.11.1978", "Українець");

        //Print ukrainian passport
        System.out.println("Ukrainian passport:");
        passportOfUkrainian.printPassport();
        System.out.println();

        //Create foreign passport
        ForeignPassport semenGorbunkov = new ForeignPassport("AV", 850790,
                "Gorbunkov", "Semen", "Semenovich", "22.11.1978",
                "Ukrainian");

        //Add visas
        semenGorbunkov.addVisa("USA", "Touristic", "09.09.2017", "08.12.2017");
        semenGorbunkov.addVisa("Grate Britain", "Work", "21.07.2017", "21.07.2018");

        //Print foreign passport
        System.out.println("Foreign passport:");
        semenGorbunkov.printPassport();

        //Clone of foreign passport
        try {
            ForeignPassport clone = semenGorbunkov.clone();
            System.out.println("Clone:");
            clone.printPassport();

            //Change clone
            clone.setPassportSeries("GB");
            clone.setPassportNumber(345777);
            clone.setName("John");
            clone.setPatronymic("Raigarovich");
            clone.setLastName("Snow");
            clone.setDateOfBirth("22.02.1540");
            clone.setResidency("North");
            clone.addVisa("South", "Touristic", "27.01.1562", "30.01.1562");
            System.out.println();

            //Print clone after change
            System.out.println("Clone after change:");
            clone.printPassport();
        } catch (CloneNotSupportedException e) {
            System.out.println("Object can`t be cloned");
        }

        //Print of original information
        System.out.println();
        System.out.println("Original:");
        semenGorbunkov.printPassport();
    }
}
