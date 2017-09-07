package com.muntian.ht19_rubber_array;

import java.util.Arrays;

public class RubberArray {
    private static final int START_LENGTH = 10;
    private static final int COEFFICIENT_OF_ARRAY_LENGTH_VARIATION = 2;
    private int size;
    private int[] rubArray = {};

    public RubberArray() {
        this.size = 0;
        this.rubArray = new int[START_LENGTH];
    }

    public void add(int number) {
        if (size == this.rubArray.length) {
            increaseArray();
        }
        rubArray[size++] = number;
    }

    private void increaseArray() {
        int newSize = rubArray.length * COEFFICIENT_OF_ARRAY_LENGTH_VARIATION;
        this.rubArray = Arrays.copyOf(rubArray, newSize);
    }

    public int getValueByIndex(int index) {
        if (index >= 0 && index < size) {
            return this.rubArray.clone()[index];
        }
        System.out.println("Error of index enter. Enter the number from 0 to " + (size - 1));
        return -1;
    }

    public void overwriteByIndex(int index, int newValue) {
        if (index >= 0 && index < size) {
            rubArray[index] = newValue;
            return;
        }
        System.out.println("Error of index enter. Enter the number from 0 to " + (size - 1));
    }

    public void removeByIndex(int index) {
        if (index >= 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                rubArray[index] = rubArray[i + 1];
            }
            size--;
            if (rubArray.length / size == 4) {
                decreaseOfRubArray();
            }
            return;
        }
        System.out.println("Error of index enter. Enter the number from 0 to " + (size - 1));

    }

    private void decreaseOfRubArray() {
        int newSize = rubArray.length / COEFFICIENT_OF_ARRAY_LENGTH_VARIATION;
        this.rubArray = Arrays.copyOf(rubArray, newSize);
    }

    public int getSize() {
        return size;
    }

    public void printRubberArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(rubArray[i] + " ");
        }
        System.out.println();
    }
}
