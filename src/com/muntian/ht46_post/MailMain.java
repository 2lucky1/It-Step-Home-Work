package com.muntian.ht46_post;

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

    public static void main(String[] args) {

        Post post = new Post(PARCELS_LIMIT);
        List<Postman> postmen = new ArrayList<>();
        List<Sender> senders = new ArrayList<>();
        List<Thread> postmenThreads = new ArrayList<>();
        List<Thread> sendersThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_SENDERS; i++) {
            senders.add(new Sender(post));
        }

        for (int i = 0; i < NUMBER_OF_POSTMEN; i++) {
            postmen.add(new Postman(post, POSTMAN_CARRYING));
        }

        for (Sender sender : senders) {
            sendersThreads.add(new Thread(sender));
        }

        for (Thread thread : sendersThreads) {
            thread.start();
        }

        for (Postman postman : postmen) {
            postmenThreads.add(new Thread(postman));
        }

        for (Thread thread : postmenThreads) {
            thread.start();
        }

        try {
            Thread.currentThread().sleep(MAIN_SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Thread thread : sendersThreads) {
            thread.interrupt();
        }

        for (Thread thread : postmenThreads) {
            thread.interrupt();
        }

//        try {
//            Thread.currentThread().sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(ANSI_CYAN + "--------------------------------");
        System.out.println(ANSI_PURPLE + "Number of accepted parcels " + post.get_acceptedParcelsNumber());
        System.out.println("Number of sent parcels " + post.get_sentParcelsNumber());
        System.out.println("Balance at the post office " + post.get_parcelsNumber());
    }
}
