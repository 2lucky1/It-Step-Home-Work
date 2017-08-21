package com.muntian.ht14_Exercise_7_47;

public class AverageWeight {

    public static void main(String[] args) {
        double criticalWeight = 100;
        double[] group = {60, 100, 77, 82, 90, 120, 110};
        double[] testGroup = {108, 137, 56, 75, 88, 84};
        double expectedValueForOther = 75.75;
        double expectedValueForFat = 122.0;
        System.out.println("Average weight of fat people:");
        System.out.println(getAverageWeightOfFatPeople(group, criticalWeight));
        System.out.println();
        System.out.println("Average weight of other people:");
        System.out.println(getAverageWeightOfOtherPeople(group,criticalWeight));
        System.out.println();
        testForFatty(testGroup,expectedValueForFat,criticalWeight);
        testForOthers(testGroup,expectedValueForOther,criticalWeight);
    }

    private static double getAverageWeightOfOtherPeople(double[] group,double criticalWeight) {
        double totalWeightOfOtherPeople = 0;
        int numberOfOtherPeople = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] <= criticalWeight) {
                totalWeightOfOtherPeople = totalWeightOfOtherPeople + group[i];
                numberOfOtherPeople++;
            }
        }
        return totalWeightOfOtherPeople / numberOfOtherPeople;
    }

    private static double getAverageWeightOfFatPeople(double[] group, double criticalWeight) {
        double totalWeightOfFatPeople = 0;
        double numberOfFatPeople = 0;
        for (int i = 0; i < group.length; i++) {
            if (group[i] > criticalWeight) {
                totalWeightOfFatPeople = totalWeightOfFatPeople + group[i];
                numberOfFatPeople++;
            }
        }
        return totalWeightOfFatPeople / numberOfFatPeople;
    }

    private static boolean testForFatty(double []testGroup,double expectedValueForFat,double criticalWeight) {
        if (getAverageWeightOfFatPeople(testGroup, criticalWeight) == expectedValueForFat) {
            System.out.println("The average weight of fat people is calculated correctly");
            return true;
        } else {
            System.out.println("Error in calculating the average weight of fat people");
            return false;
        }
    }

    private static boolean testForOthers(double []testGroup,double expectedValueForOthers,double criticalWeight) {
        if (getAverageWeightOfOtherPeople(testGroup,criticalWeight) == expectedValueForOthers) {
            System.out.println("The average weight of other people is calculated correctly");
            return true;
        } else {
            System.out.println("Error in calculating the average weight of other people");
            return false;
        }
    }
}