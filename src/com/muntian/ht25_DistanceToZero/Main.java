package com.muntian.ht25_DistanceToZero;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        //Create array of points
        Point[] listOfPoints = new Point[]{new Point(10, 20), new Point(6, 2), new Point(-5, -5),
                new Point(-3, 7), new Point(2, 0), new Point(1, 1), new Point(-4, 0),
                new Point(6, -4)};
        //Print sourced array
        System.out.println("Original list of points:");
        printListOfPoints(listOfPoints);
        System.out.println();

        //First sorting
        Arrays.sort(listOfPoints);
        //Print sorted array
        System.out.println("Sorted list in increasing order of distance from the zero");
        printListOfPoints(listOfPoints);
        System.out.println();

        //Second sorting
        PointsByDecreasingDistanceFromZeroComparator pointsByDecreasingDistanceFromZeroComparator =
                new PointsByDecreasingDistanceFromZeroComparator();
        Arrays.sort(listOfPoints, pointsByDecreasingDistanceFromZeroComparator);

        //Print sorted array
        System.out.println("Sorted list in decreasing order of distance from the zero");
        printListOfPoints(listOfPoints);
    }

    private static void printListOfPoints(Point[] listOfPoints) {
        for (Point listOfPoint : listOfPoints) {
            System.out.println(listOfPoint);
        }
    }
}

class PointsByDecreasingDistanceFromZeroComparator implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return -Double.compare(o1.distanceToZero(), o2.distanceToZero());
    }
}
