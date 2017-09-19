package com.muntian.ht22_WorkersSort;

public class Main {

    private static final int NUMBER_OF_NAMES = 5;
    private static final int NUMBER_OF_ID = 3;

    public static void main(String[] args) {

        HourlyWorker jamshut = new HourlyWorker("Jamshut", 2);
        HourlyWorker ravshan = new HourlyWorker("Ravshan", 10);
        HourlyWorker rajesh = new HourlyWorker("Rajesh", 5);
        HourlyWorker albert = new HourlyWorker("Albert", 7);

        MonthWorker tim = new MonthWorker("Timothy", 332.8);
        MonthWorker bob = new MonthWorker("Bobby", 332.8);
        MonthWorker alex = new MonthWorker("Alex", 1300);
        MonthWorker artur = new MonthWorker("Artur", 400);

        Worker[] workers = new Worker[]{jamshut, ravshan, rajesh, albert, tim, bob, alex, artur};
        workers = sortWorkersBySalary(workers);
        printListOfWorkers(workers);
        System.out.println();

        System.out.println("The first five workers names from the sorted list of workers:");
        printFirstNnamesFromList(NUMBER_OF_NAMES, workers);
        System.out.println();

        System.out.println("The last three workers ID from the sorted list of workers:");
        printLastNindexFromList(NUMBER_OF_ID, workers);

    }

    private static boolean compareWorkersBySalary(Worker worker1, Worker worker2) {
        if (worker1.countSalary() == worker2.countSalary()) {
            return worker1.getName().compareTo(worker2.getName()) > 0;
        }
        return worker1.countSalary() < worker2.countSalary();
    }

    private static Worker[] sortWorkersBySalary(Worker[] workers) {
        Worker[] sortList = workers.clone();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 1; j < (workers.length - i); j++) {
                if (compareWorkersBySalary(sortList[j - 1], sortList[j])) {
                    Worker temp = sortList[j - 1];
                    sortList[j - 1] = sortList[j];
                    sortList[j] = temp;
                }
            }
        }
        return sortList;
    }

    private static void printListOfWorkers(Worker[] workers) {
        System.out.println("ID\t\tName\t\t\tSalary");
        System.out.println("------------------------------------");
        for (int i = 0; i < workers.length; i++) {
            Worker worker = workers[i];
            System.out.printf("%d\t\t%s\t\t\t%f%n",
                    worker.getiD(),
                    worker.getName(),
                    worker.countSalary());
        }
    }

    private static void printFirstNnamesFromList(int numberOfNames, Worker[] workers) {
        for (int i = 0; i < numberOfNames; i++) {
            System.out.println(workers[i].getName());
        }
    }

    private static void printLastNindexFromList(int numberOfIndex, Worker[] workers) {
        for (int i = (workers.length - numberOfIndex); i < workers.length; i++) {
            System.out.println(workers[i].getiD());
        }
    }
}
