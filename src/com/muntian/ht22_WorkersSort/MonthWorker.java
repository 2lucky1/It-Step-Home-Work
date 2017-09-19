package com.muntian.ht22_WorkersSort;

public class MonthWorker extends Worker {

    public MonthWorker(String name, double rate) {
        super(name, rate);
    }

    @Override
    public double countSalary() {
        return getRate();
    }
}
