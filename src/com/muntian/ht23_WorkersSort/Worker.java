package com.muntian.ht23_WorkersSort;

public abstract class Worker {
    private static int count = 1;
    private String name;
    private int iD;
    private double rate;

    Worker(String name, double rate) {
        this.name = name;
        this.iD = count++;
        this.rate = rate;
    }

    public Worker() {
    }

    public abstract double countSalary();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
}
