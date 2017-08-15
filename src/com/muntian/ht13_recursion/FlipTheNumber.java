package com.muntian.ht13_recursion;

import java.util.Scanner;

public class FlipTheNumber {
    private static String userNumber;
    private static String reversedNumber = "";
    private static int lastIndex;

    public static void main(String[] args) {
        enterTheNumber();
        lastIndex = userNumber.length()-1;
        reverse(userNumber,lastIndex);
        System.out.println(reversedNumber);
    }

    private static void enterTheNumber() {
        System.out.println("Enter the number");
        Scanner input = new Scanner(System.in);
        userNumber = input.nextLine();
    }

    private static void reverse(String userNumber,int lastIndex) {
        if (lastIndex<0){
            return;
        }
        reversedNumber+=userNumber.charAt(lastIndex);
        lastIndex--;
        reverse(userNumber,lastIndex);
    }
}
