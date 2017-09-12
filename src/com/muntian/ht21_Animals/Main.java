package com.muntian.ht21_Animals;

public class Main {
    public static void main(String[] args) {
        //Create Animals
        Lion bonifacy = new Lion("Lion");
        Frog donatello = new Frog("Frog");
        Dog snoopy = new Dog("Dog");
        //Create array of animals
        Animals[] animals = {bonifacy, donatello, snoopy};
        //Display doSound() of each animal
        for (int i = 0; i < animals.length; i++) {
            System.out.print(animals[i].name + " say: ");
            animals[i].doSound();
        }
    }
}
