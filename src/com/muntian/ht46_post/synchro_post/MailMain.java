package com.muntian.ht46_post.synchro_post;

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

    private static Post _post = new Post(PARCELS_LIMIT);
    private static List<Postman> _postmen = new ArrayList<>();
    private static List<Sender> _senders = new ArrayList<>();
    private static List<Thread> _postmenThreads = new ArrayList<>();
    private static List<Thread> _sendersThreads = new ArrayList<>();

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

    /**
     * Print results of post work
     */
    private static void printResults() {
        System.out.println(ANSI_CYAN + "--------------------------------");
        System.out.println(ANSI_PURPLE + "Number of accepted parcels " + _post.getAcceptedParcelsNumber());
        System.out.println("Number of sent parcels " + _post.getSentParcelsNumber());
        System.out.println("Balance at the _post office " + _post.getParcelsNumber());
    }

    //Interrupting of all threads at the and of program
    private static void interruptPostmenThreads() {
        for (Thread thread : _postmenThreads) {
            thread.interrupt();
        }
    }

    private static void interruptSendersThreads() {
        for (Thread thread : _sendersThreads) {
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

    //Starting of all threads
    private static void startPostmenThreads() {
        for (Thread thread : _postmenThreads) {
            thread.start();
        }
    }

    private static void startSendersThreads() {
        for (Thread thread : _sendersThreads) {
            thread.start();
        }
    }

    //Creating of Postmen and Senders threads lists
    private static void createListOfPostmenThreads() {
        for (Postman postman : _postmen) {
            _postmenThreads.add(new Thread(postman));
        }
    }

    private static void createListOfSendersThreads() {
        for (Sender sender : _senders) {
            _sendersThreads.add(new Thread(sender));
        }
    }

    //Creating of Postmen and Senders lists
    private static void createPostmen() {
        for (int i = 0; i < NUMBER_OF_POSTMEN; i++) {
            _postmen.add(new Postman(_post, POSTMAN_CARRYING));
        }
    }

    private static void createSenders() {
        for (int i = 0; i < NUMBER_OF_SENDERS; i++) {
            _senders.add(new Sender(_post));
        }
    }
}
