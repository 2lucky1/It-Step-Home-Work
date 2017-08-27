package com.muntian.ht15_Exercise_3_34;

import java.util.Scanner;

import static java.lang.String.valueOf;

public class Chess {
    private static final int VERTICAL_OF_FIGURE = 0;
    private static final int HORIZONTAL_OF_FIGURE = 1;
    private static final int VERTICAL_OF_TARGET = 2;
    private static final int HORIZONTAL_OF_TARGET = 3;
    private static final int FIGURE_NUMBER = 4;

    public static void main(String[] args) {
        //Create the input data array
        int[] coordinates = new int[5];

        // Enter of input data
        enterOfInputData(coordinates);

        // Determine whether the selected figure threatens the specified field
        printOfResult(targetInTheAreaOfVisibility(coordinates));

        //Visualization of chess
        visualization(coordinates);
        System.out.println();

        //Tests
        System.out.println("Test with rook, when target is achievable");
        printTest(testWithRookTargetIsAchievable(coordinates));
        visualization(coordinates);
        System.out.println();

        System.out.println("Test with rook, when target is unattainable");
        printTest(testWithRookTargetIsUnattainable(coordinates));
        visualization(coordinates);
        System.out.println();

        System.out.println("Test with horse, when target is achievable");
        printTest(testWithHorseTargetIsAchievable(coordinates));
        visualization(coordinates);
        System.out.println();

        System.out.println("Test with white pawn, when target is achievable");
        printTest(testWithWhitePawnTargetIsAchievable(coordinates));
        visualization(coordinates);
        System.out.println();

    }

    private static int enterOfOneCoordinate() {
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

    private static void enterOfInputData(int[] coordinates) {
        while (true) {
            System.out.println("Input of the vertical coordinate of figure:");
            coordinates[VERTICAL_OF_FIGURE] = enterOfOneCoordinate();
            System.out.println("Input of the horizontal coordinate of figure:");
            coordinates[HORIZONTAL_OF_FIGURE] = enterOfOneCoordinate();
            System.out.println("Input of the vertical coordinate of the target:");
            coordinates[VERTICAL_OF_TARGET] = enterOfOneCoordinate();
            System.out.println("Input of the horizontal coordinate of the target:");
            coordinates[HORIZONTAL_OF_TARGET] = enterOfOneCoordinate();
            if (checkOfCorrectInpuDataEnter(coordinates)) {
                break;
            }
        }
        selectChessFigure(coordinates);
    }

    private static boolean checkOfCorrectInpuDataEnter(int[] coordinates) {
        if (coordinates[VERTICAL_OF_FIGURE] == coordinates[VERTICAL_OF_TARGET] &&
                coordinates[HORIZONTAL_OF_FIGURE] == coordinates[HORIZONTAL_OF_TARGET]) {
            System.out.println("Input error: Identical figure and target coordinates! Try again");
            return false;
        } else {
            return true;
        }
    }

    private static void selectChessFigure(int[] coordinates) {
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
                coordinates[FIGURE_NUMBER] = input.nextInt();
                if (coordinates[FIGURE_NUMBER] > 0 && coordinates[FIGURE_NUMBER] < 8) {
                    switch (coordinates[FIGURE_NUMBER]) {
                        case 1:
                            System.out.println("You have chosen a rook");
                            return;
                        case 2:
                            System.out.println("You have chosen an elephant");
                            return;
                        case 3:
                            System.out.println("You have chosen a king");
                            return;
                        case 4:
                            System.out.println("You have chosen a queen");
                            return;
                        case 5:
                            System.out.println("You have chosen a white paw");
                            return;
                        case 6:
                            System.out.println("You have chosen a black paw");
                            return;
                        case 7:
                            System.out.println("You have chosen a black paw");
                            return;
                        default:
                            System.out.println("Input error: Enter integer number from 1 to 8");
                    }
                }
            }
        }
    }

    private static boolean targetInTheAreaOfVisibility(int[] coordinates) {
        //Assign short names for variables for code compactness
        int a = coordinates[VERTICAL_OF_FIGURE];
        int b = coordinates[HORIZONTAL_OF_FIGURE];
        int c = coordinates[VERTICAL_OF_TARGET];
        int d = coordinates[HORIZONTAL_OF_TARGET];
        switch (coordinates[FIGURE_NUMBER]) {
            case 1:
                return (a == c || b == d);
            case 2:
                return (a - c == b - d);
            case 3:
                return (a - c <= 1 && a - c >= -1 && b - d <= 1 && b - d >= -1);
            case 4:
                return ((a == c || b == d) || (a - c == b - d));
            case 5:
                return (c - a == 1 && (b - d == -1 || b - d == 1));
            case 6:
                return (a - c == 1 && (b - d == -1 || b - d == 1));
            case 7:
                return ((c == a + 2 && ((d == b + 1) || (d == b - 1))) || (c == a + 1 && ((d == b + 2) || (d == b - 2))) || (c == a - 2 && ((d == b + 1) || (d == b - 1))) || (c == a - 1 && ((d == b + 2) || (d == b - 2))));
        }
        System.out.println("don`t work2" + coordinates[FIGURE_NUMBER]);
        return false;
    }

    private static void printOfResult(boolean result) {
        if (result) {
            System.out.println("Target can be attacked");
        } else {
            System.out.println("The target can`t be attacked");
        }
    }

    private static void visualization(int[] coordinates) {
        String[][] chessBoard = new String[8][8];
        //Filling of chess board by white and black squares
        for (int i = 0; i < chessBoard.length; i += 2) {
            for (int j = 0; j < chessBoard[i].length; j += 2) {
                chessBoard[i][j] = "W";
                chessBoard[i][j + 1] = "B";
            }
        }

        for (int i = 1; i < chessBoard.length; i += 2) {
            for (int j = 0; j < chessBoard[i].length; j += 2) {
                chessBoard[i][j] = "B";
                chessBoard[i][j + 1] = "W";
            }
        }

        //Specifying the figure and the target on the board
        chessBoard[8 - coordinates[VERTICAL_OF_FIGURE]][coordinates[HORIZONTAL_OF_FIGURE] - 1] = "f";
        chessBoard[8 - coordinates[VERTICAL_OF_TARGET]][coordinates[HORIZONTAL_OF_TARGET] - 1] = "t";

        //Displaying chess board
        for (int i = 0; i < chessBoard.length; i++) {
            if (i < 8) {
                System.out.print((chessBoard.length - i) + " | ");
            } else {
                System.out.print("   ");
            }
            for (int j = 0; j < chessBoard[i].length; j++) {
                System.out.print(chessBoard[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < chessBoard[i].length; j++) {
                if (j == 0) {
                    System.out.print("    ");
                }
                if (i > 0) {
                    System.out.print((j + 1) + " ");
                } else System.out.print("- ");
            }
            System.out.println();
        }
    }

    private static void printTest(boolean test) {
        if (test) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
    }

    private static boolean testWithRookTargetIsAchievable(int[] coordinates) {
        coordinates[VERTICAL_OF_FIGURE] = 2;
        coordinates[HORIZONTAL_OF_FIGURE] = 2;
        coordinates[VERTICAL_OF_TARGET] = 4;
        coordinates[HORIZONTAL_OF_TARGET] = 2;
        coordinates[FIGURE_NUMBER] = 1;
        boolean expectedResult = true;
        if (expectedResult == targetInTheAreaOfVisibility(coordinates)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean testWithRookTargetIsUnattainable(int[] coordinates) {
        coordinates[VERTICAL_OF_FIGURE] = 2;
        coordinates[HORIZONTAL_OF_FIGURE] = 3;
        coordinates[VERTICAL_OF_TARGET] = 4;
        coordinates[HORIZONTAL_OF_TARGET] = 2;
        coordinates[FIGURE_NUMBER] = 1;
        boolean expectedResult = false;
        if (expectedResult == targetInTheAreaOfVisibility(coordinates)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean testWithHorseTargetIsAchievable(int[] coordinates) {
        coordinates[VERTICAL_OF_FIGURE] = 2;
        coordinates[HORIZONTAL_OF_FIGURE] = 3;
        coordinates[VERTICAL_OF_TARGET] = 3;
        coordinates[HORIZONTAL_OF_TARGET] = 1;
        coordinates[FIGURE_NUMBER] = 7;
        boolean expectedResult = true;
        if (expectedResult == targetInTheAreaOfVisibility(coordinates)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean testWithWhitePawnTargetIsAchievable(int[] coordinates) {
        coordinates[VERTICAL_OF_FIGURE] = 2;
        coordinates[HORIZONTAL_OF_FIGURE] = 3;
        coordinates[VERTICAL_OF_TARGET] = 3;
        coordinates[HORIZONTAL_OF_TARGET] = 4;
        coordinates[FIGURE_NUMBER] = 5;
        boolean expectedResult = true;
        if (expectedResult == targetInTheAreaOfVisibility(coordinates)) {
            return true;
        } else {
            return false;
        }
    }
}