package com.muntian.ht27_Iterable;

public class IterableMain {
    public static void main(String[] args) {
        IterableRubberArray iterableRubberArray = new IterableRubberArray();
        iterableRubberArray.addItemsToIterableRubberArray(10);
        for (Integer i : iterableRubberArray) {
            System.out.println(i);
        }
    }
}
