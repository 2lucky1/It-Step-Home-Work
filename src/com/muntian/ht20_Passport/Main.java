package com.muntian.ht20_Passport;

public class Main {
    public static void main(String[] args) {
        //Create ukrainian passport
        Passport passportOfUkrainian = new Passport("АН",450974,"Горбунков",
                "Семен","Семенович","22.11.1978","Українець");

        //Print ukrainian passport
        passportOfUkrainian.printPassport();

        //Create foreign passport
        ForeignPassport nikolaiMuntian = new ForeignPassport("AV",850790,
                "Gorbunkov","Semen","Semenovich","22.11.1978",
                "Ukrainian");
        //Add visas
        nikolaiMuntian.addVisa("USA","Touristic","09.09.2017","08.12.2017");
        nikolaiMuntian.addVisa("Grate Britain","Work","21.07.2017","21.07.2018");
        //Print foreign passport
        nikolaiMuntian.printPassport();
    }
}
