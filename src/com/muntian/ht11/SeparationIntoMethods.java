package com.muntian.ht11;

import java.util.Scanner;

/**
 *
 * Created by Note on 17.07.2017.
 */
public class SeparationIntoMethods {
    public static void main(String[] args) {
        int[] arr = new int[4];
        //Selection sort:
        selectSort(arr);
        System.out.println();

        //Bubble sort:
        bubbleSort(arr);
        System.out.println();

        //Insert sort:
        insertSort(arr);
    }

    private static void arrayFilling(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Enter the number");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                arr[i] = input.nextInt();
            } else {
                System.out.println("Error: enter the number!");
                i--;
            }
        }
    }

    private static void selectSort(int[] arr) {
        System.out.println("Selection sort");
        arrayFilling(arr);
        System.out.print("Source array: ");
        displayArray(arr);
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            int max = 0;
            //To get the result according to the condition of the task, we perform the following check:
            if (arr.length - i == 1) {
                break;
            }
            //To prevent unnecessary iterations , we can perform a test, which is below:
//            if (arr.length - i-1 == 1) {
//                break;
//            }
            System.out.println(" " + (i + 1) + " passage through an array: ");
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            if (arr[max] != arr.length - i - 1) {
                tmp = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = arr[max];
                arr[max] = tmp;
                displayArray(arr);
            }
        }
    }

    private static void bubbleSort(int[] arr) {
        System.out.println("Sort by bubble:");
        arrayFilling(arr);
        System.out.print("Source array: ");
        displayArray(arr);
        for (int i = 0; i < arr.length; i++) {
            //Check to not go to the next iteration:
            if (i == arr.length - 1) {
                break;
            }
            System.out.println(" " + (i + 1) + " passage through an array: ");

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
                displayArray(arr);
            }
        }
    }

    private static void insertSort(int[] arr) {
        System.out.println("Insert sort:");
        arrayFilling(arr);
        System.out.print("Source array: ");
        displayArray(arr);
        for (int i = 1; i < arr.length; i++) {
            int j;
            int tmp = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > tmp; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = tmp;
            if (i == arr.length) {
                break;
            }
            System.out.println(" " + (i) + " passage through an array: ");
            displayArray(arr);
        }
    }


    private static void displayArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
