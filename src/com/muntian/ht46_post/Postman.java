package com.muntian.ht46_post;

public class Postman implements Runnable {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";



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

    public static void set_postmenNumber(int postmenNumber) {
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
