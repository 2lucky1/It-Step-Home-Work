package com.muntian.ht46_post.wait_post;

import java.util.ArrayList;
import java.util.List;

public class MailMain {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    private static final int NUMBER_OF_POSTMEN = 3;
    private static final int POSTMAN_CARRYING = 2;
    private static final int NUMBER_OF_SENDERS = 10;
    private static final int PARCELS_LIMIT = 20;
    private static final int MAIN_SLEEP_TIME = 30000;

    private static Post post = new Post(PARCELS_LIMIT);
    private static List<Postman> postmen = new ArrayList<>();
    private static List<Sender> senders = new ArrayList<>();
    private static List<Thread> postmenThreads = new ArrayList<>();
    private static List<Thread> sendersThreads = new ArrayList<>();

    public static void main(String[] args) {
        createSenders();
        createPostmen();
        createListOfSendersThreads();
        createListOfPostmenThreads();
        startSendersThreads();
        startPostmenThreads();
        sleepMain();
        interruptSendersThreads();
        interruptPostmenThreads();
        printResults();
    }

    private static void printResults() {
        System.out.println(ANSI_CYAN + "--------------------------------");
        System.out.println(ANSI_PURPLE + "Number of accepted parcels " + post.get_acceptedParcelsNumber());
        System.out.println("Number of sent parcels " + post.get_sentParcelsNumber());
        System.out.println("Balance at the post office " + post.get_parcelsNumber());
    }

    private static void interruptPostmenThreads() {
        for (Thread thread : postmenThreads) {
            thread.interrupt();
        }
    }

    private static void interruptSendersThreads() {
        for (Thread thread : sendersThreads) {
            thread.interrupt();
        }
    }

    //Make Main sleeping to avoid of its premature termination
    private static void sleepMain() {
        try {
            Thread.sleep(MAIN_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void startPostmenThreads() {
        for (Thread thread : postmenThreads) {
            thread.start();
        }
    }

    private static void startSendersThreads() {
        for (Thread thread : sendersThreads) {
            thread.start();
        }
    }

    private static void createListOfPostmenThreads() {
        for (Postman postman : postmen) {
            postmenThreads.add(new Thread(postman));
        }
    }

    private static void createListOfSendersThreads() {
        for (Sender sender : senders) {
            sendersThreads.add(new Thread(sender));
        }
    }

    private static void createPostmen() {
        for (int i = 0; i < NUMBER_OF_POSTMEN; i++) {
            postmen.add(new Postman(post, POSTMAN_CARRYING));
        }
    }

    private static void createSenders() {
        for (int i = 0; i < NUMBER_OF_SENDERS; i++) {
            senders.add(new Sender(post));
        }
    }
}
