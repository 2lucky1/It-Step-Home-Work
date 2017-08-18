package com.muntian.ht14_Exercise_7_47;

public class AverageWeight {
    private static double criticalWeight = 100;
    private static double averageWeightOfFatty = 0;
    private static double averageWeightOfOthers = 0;
    private static double[] group = {60, 100, 77, 82, 90, 120, 110};

    public static void main(String[] args) {
        System.out.println("Average weight of fat people:");
        System.out.println(getAverageWeightOfFatPeople(group));
        System.out.println();
        System.out.println("Average weight of other people:");
        System.out.println(getAverageWeightOfOtherPeople(group));
        System.out.println();
        testForFatty();
        testForOthers();
    }

    private static double getAverageWeightOfOtherPeople(double[] group) {
        double totalWeightOfOtherPeople = 0;
        int numberOfOtherPeople = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] <= criticalWeight) {
                totalWeightOfOtherPeople = totalWeightOfOtherPeople + group[i];
                numberOfOtherPeople++;
            }
        }
        return averageWeightOfOthers = totalWeightOfOtherPeople / numberOfOtherPeople;
    }

    private static double getAverageWeightOfFatPeople(double[] group) {
        double totalWeightOfFatPeople = 0;
        double numberOfFatPeople = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] > criticalWeight) {
                totalWeightOfFatPeople = totalWeightOfFatPeople + group[i];
                numberOfFatPeople++;
            }
        }
        return averageWeightOfFatty = totalWeightOfFatPeople / numberOfFatPeople;
    }

    private static boolean testForFatty() {
        double[] testGroup = {108, 137, 56, 75, 88, 84};
        double expectedValue = 122.5;
        if (getAverageWeightOfFatPeople(testGroup) == expectedValue) {
            System.out.println("The average weight of fat people is calculated correctly");
            return true;
        } else {
            System.out.println("Error in calculating the average weight of fat people");
            return false;
        }
    }

    private static boolean testForOthers() {
        double[] testGroup = {108, 137, 56, 75, 88, 84};
        double expectedValue = 75.75;
        if (getAverageWeightOfOtherPeople(testGroup) == expectedValue) {
            System.out.println("The average weight of other people is calculated correctly");
            return true;
        } else {
            System.out.println("Error in calculating the average weight of other people");
            return false;
        }
    }
}