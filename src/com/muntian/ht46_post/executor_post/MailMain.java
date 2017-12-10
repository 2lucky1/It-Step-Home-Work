package com.muntian.ht46_post.executor_post;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MailMain {
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_PURPLE = "\u001B[35m";

    private static final int NUMBER_OF_POSTMEN = 3;
    private static final int POSTMAN_CARRYING = 2;
    private static final int NUMBER_OF_SENDERS = 10;
    private static final int PARCELS_LIMIT = 20;
    private static final int MAIN_SLEEP_TIME = 30000;
    private static final int THREADS_NUMBER = 13;

    private static Post _post = new Post(PARCELS_LIMIT);
    private static List<Postman> _postmen = new ArrayList<>();
    private static List<Sender> _senders = new ArrayList<>();
    private static ExecutorService _threadPool = Executors.newFixedThreadPool(THREADS_NUMBER);

    public static void main(String[] args) {
        createSenders();
        createPostmen();
        submitSendersToExecutor();
        submitPostmenToExecutor();
        sleepMain();
        _threadPool.shutdownNow();
        printResults();
    }

    /**
     * Print results of post work
     */
    private static void printResults() {
        System.out.println(ANSI_CYAN + "--------------------------------");
        System.out.println(ANSI_PURPLE + "Number of accepted parcels " + _post.get_acceptedParcelsNumber());
        System.out.println("Number of sent parcels " + _post.get_sentParcelsNumber());
        System.out.println("Balance at the _post office " + _post.get_parcelsNumber());
    }

    //Make Main sleeping to avoid of its premature termination
    private static void sleepMain() {
        try {
            Thread.sleep(MAIN_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Submit tasks to executor
    private static void submitPostmenToExecutor() {
        for (Postman postman : _postmen) {
            _threadPool.execute(postman);
        }
    }

    private static void submitSendersToExecutor() {
        for (Sender sender : _senders) {
            _threadPool.execute(sender);
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
