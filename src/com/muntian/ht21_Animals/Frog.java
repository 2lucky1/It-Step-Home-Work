package com.muntian.ht21_Animals;

public class Frog extends Animals{

    public Frog(String name) {
        super(name);
    }

    @Override
    public void doSound() {
        System.out.println("Croak-croak");
    }
}
