package com.muntian.ht41_stop_threads;

import java.util.Scanner;

public class MainThreads {

    public static void main(String[] args) {
        //Creating threads
        Thread thread1 = new Thread(new MyRunnable(), "T1");
        Thread thread2 = new Thread(new MyRunnable(), "T2");
        Thread thread3 = new Thread(new MyRunnable(), "T3");
        Thread thread4 = new Thread(new MyRunnable(), "T4");
        Thread thread5 = new Thread(new MyRunnable(), "T5");

        //Start threads
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        //Stopping threads
        System.out.println("Which thread should be stopped?");
        System.out.println(Thread.activeCount());
        Scanner input = new Scanner(System.in);

        while (thread1.isAlive() || thread2.isAlive() || thread3.isAlive() ||
                thread4.isAlive() || thread5.isAlive()) {
            switch (input.nextLine()) {
                case "T1":
                    stopThread(thread1);
                    break;
                case "T2":
                    stopThread(thread2);
                    break;
                case "T3":
                    stopThread(thread3);
                    break;
                case "T4":
                    stopThread(thread4);
                    break;
                case "T5":
                    stopThread(thread5);
                    break;
//                default:
//                    System.out.println("Incorrect input of thread name");
            }
        }
        System.out.println("All threads are stopped");
    }

    private static void stopThread(Thread thread) {
        if (!thread.isAlive()) {
            System.out.println("This thread was not started or has been already interrupted");
        } else {
            thread.interrupt();
        }
    }
}

class MyRunnable implements Runnable {

    private static final int SLEEP_TIME = 1000000;

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " started");
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(SLEEP_TIME);
            }
        } catch (InterruptedException ignore) {

        }
        System.out.println("Thread " + Thread.currentThread().getName() + " stopped");
    }
}
