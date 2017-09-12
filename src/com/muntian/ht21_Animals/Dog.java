package com.muntian.ht21_Animals;

public class Dog extends Animals {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void doSound() {
        System.out.println("Woof-woof");
    }
}
