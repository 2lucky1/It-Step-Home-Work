package com.muntian.ht46_post;

import java.util.ArrayList;
import java.util.Collection;

public class MailMain {
    private static final int NUMBER_OF_POSTMEN = 3;
    private static final int POSTMAN_CARRYING = 2;
    private static final int NUMBER_OF_SENDERS = 10;
    private static final int PARCELS_LIMIT = 20;

    public static void main(String[] args) {

        Post post = new Post(PARCELS_LIMIT);
        Collection<Postman> postmen = new ArrayList<>();
        Collection<Sender> senders = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_SENDERS; i++) {
            senders.add(new Sender());
        }

        for (int i = 0; i < NUMBER_OF_POSTMEN; i++){
            postmen.add(new Postman(POSTMAN_CARRYING));
        }
            Thread sender1 = new Thread()
    }

}
