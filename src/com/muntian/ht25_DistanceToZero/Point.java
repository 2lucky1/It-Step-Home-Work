package com.muntian.ht25_DistanceToZero;

public class Point implements Comparable<Point> {
    private static int count = 1;
    private int number;
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.number = count++;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distanceToZero(){
        return Math.sqrt((Math.pow(this.getX(),2)+Math.pow(this.getY(),2)));
    }

    @Override
    public String toString() {
        return "Point{" +
                "number=" + number +
                ", x=" + x +
                ", y=" + y +
                ", distanceToZero=" + distanceToZero() +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        return Double.compare(this.distanceToZero(), o.distanceToZero());
    }
}
