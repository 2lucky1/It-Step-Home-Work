package com.muntian.ht46_post.synchro_post;

public class Postman implements Runnable {

    private static final String ANSI_YELLOW = "\u001B[33m";

    private static final long MIN_SLEEP_TIME = 5000;
    private static final long MAX_SLEEP_TIME = 6000;
    private static final long WAITING_TIME = 3000;

    private static int _postmenNumber = 0;
    private int _postmanSerialNumber;
    private int _postmanCarrying = 4;
    private Post _post;


    public Postman(Post post, int postmanCarrying) {
        _post = post;
        _postmanCarrying = postmanCarrying;
        set_postmenNumber(get_postmenNumber() + 1);
        _postmanSerialNumber = get_postmenNumber();
    }

    @Override
    public void run() {
        while (true) {
            if (_post.get_parcelsNumber() > 0) {
                if (_post.get_parcelsNumber() > get_postmanCarrying()) {
                    System.out.println(ANSI_YELLOW + "Postman " + this + " have taken " +
                            get_postmanCarrying() + " parcels");
                    _post.giveParcel(get_postmanCarrying());
                } else {
                    System.out.println(ANSI_YELLOW + "Postman " + this + " have taken " +
                            _post.get_parcelsNumber() + " parcels");
                    _post.giveParcel(_post.get_parcelsNumber());
                }
                try {
                    Thread.sleep(randomSleepTime());
                } catch (InterruptedException e) {
                    break;
                }
            } else {
                try {
                    Thread.sleep(WAITING_TIME);
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        }
    }

    private long randomSleepTime() {
        return MIN_SLEEP_TIME + (long) (Math.random() * MAX_SLEEP_TIME);
    }

    public int get_postmanCarrying() {
        return _postmanCarrying;
    }

    public void set_postmanCarrying(int postmanCarrying) {
        _postmanCarrying = postmanCarrying;
    }

    public static int get_postmenNumber() {
        return _postmenNumber;
    }

    private static void set_postmenNumber(int postmenNumber) {
        _postmenNumber = postmenNumber;
    }

    public int get_postmanSerialNumber() {
        return _postmanSerialNumber;
    }

    @Override
    public String toString() {
        return "" + get_postmanSerialNumber();
    }
}
