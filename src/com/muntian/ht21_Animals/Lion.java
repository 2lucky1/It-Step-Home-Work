package com.muntian.ht21_Animals;

public class Lion extends Animals{

    public Lion(String name) {
        super(name);
    }

    @Override
    public void doSound() {
        System.out.println("Roar-roar");
    }
}
