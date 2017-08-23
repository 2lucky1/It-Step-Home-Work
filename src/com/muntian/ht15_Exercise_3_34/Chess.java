package com.muntian.ht15_Exercise_3_34;

import java.util.Scanner;

public class Chess {

    public static void main(String[] args) {
        System.out.println("Input of the vertical coordinate of figure:");
        int a = oneCoordinate();
        System.out.println("Input of the horizontal coordinate of figure:");
        int b = oneCoordinate();
        System.out.println("Input of the vertical coordinate of the target:");
        int c = oneCoordinate();
        System.out.println("Input of the horizontal coordinate of the target:");
        int d = oneCoordinate();
//        checkOfInputData();
        targetCanBeAttacked(targetInTheAreaOfVisibility(selectChessFigure(a, b), a, b, c, d));


    }

    private static int selectChessFigure(int a, int b) {
        System.out.println("Please, choose the figure:");
        System.out.println("Rook              1");
        System.out.println("Elephant          2");
        System.out.println("King              3");
        System.out.println("Queen             4");
        System.out.println("White pawn        5");
        System.out.println("Black pawn        6");
        System.out.println("Horse             7");
        while (true) {
            System.out.println("Enter the number of figure from 1 to 7");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int userNumber = input.nextInt();
                if (userNumber > 0 && userNumber < 8) {
                    return userNumber;
                }
            } else {
                System.out.println("Input error: Enter integer number from 1 to 8");
            }
        }
    }

    private static boolean targetInTheAreaOfVisibility(int numberOfFigure, int a, int b, int c, int d) {
        switch (numberOfFigure) {
            case 1:
                if (a == c || b == d) {
                    return true;
                } else {
                    return false;
                }
            case 2:
                System.out.println(getElephantVisibility(a,b));
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
        System.out.println("dont work");
        return false;
    }

    private static boolean[][]getElephantVisibility(int a, int b){
        boolean[][] elephantVisibility = new boolean[8][8];
        int a1 = 8 - a;
        int b1 = b - 1;
        //left and up
        for (int i = a1; i >= 0; i--) {
            if (b1 < 0) {
                break;
            }
            elephantVisibility[i][b1] = true;
            b1--;
        }
        //left and down
        b1 = b - 1;
        for (int i = a1; i <= 7; i++) {
            if (b1 > 7) {
                break;
            }
            elephantVisibility[i][b1] = true;
            b1--;
        }
        //right and up
        b1 = b - 1;
        for (int i = a1; i >= 0; i--) {
            if (b1 > 7) {
                break;
            }
            elephantVisibility[i][b1] = true;
            b1++;
        }
        //right and down
        b1 = b - 1;
        for (int i = a1; i<=7; i++){
            if (b1<0){
                break;
            }
            elephantVisibility[i][b1] = true;
        }
        return elephantVisibility;
    }

    private static void targetCanBeAttacked(boolean posibilityOfTheAttack) {
        if (posibilityOfTheAttack) {
            System.out.println("Target can be attacked");
        } else {
            System.out.println("The target can not be attacked");
        }
    }

//    private static boolean[][] areaOfVisibility(int a, int b) {
//        boolean[][] areaOfRook = new boolean[8][8];
//        for (int i = 0; i < 8; i++) {
//            areaOfRook[a][i] = true;
//        }
//        for (int i = 0; i < 8; i++) {
//            areaOfRook[i][b] = true;
//        }
//        return areaOfRook;
//    }

    private static int oneCoordinate() {
        while (true) {
            System.out.println("Enter the number from 1 to 8");
            Scanner input = new Scanner(System.in);
            if (input.hasNextInt()) {
                int userNumber = input.nextInt();
                if (userNumber > 0 && userNumber < 9) {
                    return userNumber;
                } else {
                    System.out.println("Input error: Enter integer number from 1 to 8");
                }
            }
        }
    }
}