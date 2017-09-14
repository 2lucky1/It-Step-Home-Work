package com.muntian.ht19_rubber_array;

public class Main {

    private static final int QUANTITY_OF_START_NUMBERS = 10;

    public static void main(String[] args) {
        RubberArray rubberArray = new RubberArray();

        System.out.println("Filling of rubber array by start numbers:");
        addItemsToRubberArray(rubberArray, QUANTITY_OF_START_NUMBERS);
        rubberArray.printRubberArray();
        System.out.println();

        System.out.println("Adding of one more item:");
        rubberArray.add(8);
        rubberArray.printRubberArray();
        System.out.println();

        System.out.println("Overwriting item by index:");
        rubberArray.overwriteByIndex(4, 20);
        rubberArray.printRubberArray();
        System.out.println();

        System.out.println("Getting the value of an item by its index");
        System.out.println(rubberArray.getValueByIndex(0));
        System.out.println();

        System.out.println("Deleting an item by its index");
        rubberArray.removeByIndex(6);
        rubberArray.printRubberArray();
        System.out.println();

        System.out.println("Non-existent cell request");
        rubberArray.removeByIndex(25);
        System.out.println();

        System.out.println("Adding a large number of items");
        addItemsToRubberArray(rubberArray, 10);
        rubberArray.printRubberArray();
        System.out.println();

        System.out.println("Getting size of array");
        System.out.println(rubberArray.getSize());
        System.out.println();
    }

    private static void addItemsToRubberArray(RubberArray rubberArray, int quantityOfItems) {
        for (int i = 1; i <= quantityOfItems; i++) {
            rubberArray.add(i);
        }
    }
}
