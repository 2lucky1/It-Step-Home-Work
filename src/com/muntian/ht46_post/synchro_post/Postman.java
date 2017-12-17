package com.muntian.ht46_post.synchro_post;

public class Postman implements Runnable {

    private static final String ANSI_YELLOW = "\u001B[33m";

    private static final long MIN_SLEEP_TIME = 5000;
    private static final long MAX_SLEEP_TIME = 6000;
    private static final long WAITING_TIME = 3000;

    private static int _postmenNumber = 0;
    private int _postmanSerialNumber;
    private int _postmanCarrying = 1;
    private Post _post;


    public Postman(Post post, int postmanCarrying) {
        _post = post;
        _postmanCarrying = postmanCarrying;
        setPostmenNumber(getPostmenNumber() + 1);
        _postmanSerialNumber = getPostmenNumber();
    }

    @Override
    public void run() {
        while (true) {
            if (_post.getParcelsNumber() > 0) {
                if (_post.getParcelsNumber() >= getPostmanCarrying()) {
                    System.out.println(ANSI_YELLOW + "Postman " + this + " have taken " +
                            getPostmanCarrying() + " parcels");
                    _post.giveParcel(getPostmanCarrying());
                } else {
                    System.out.println(ANSI_YELLOW + "Postman " + this + " have taken " +
                            _post.getParcelsNumber() + " parcels");
                    _post.giveParcel(_post.getParcelsNumber());
                }
                try {
                    Thread.sleep(randomSleepTime());
                } catch (InterruptedException e) {
                    break;
                }
            } else {
                try {
                    Thread.sleep(WAITING_TIME);
                } catch (InterruptedException ignored) {
                    //ignore
                }
            }
        }
    }

    private long randomSleepTime() {
        return MIN_SLEEP_TIME + (long) (Math.random() * MAX_SLEEP_TIME);
    }

    public int getPostmanCarrying() {
        return _postmanCarrying;
    }

    public void setPostmanCarrying(int postmanCarrying) {
        _postmanCarrying = postmanCarrying;
    }

    public static int getPostmenNumber() {
        return _postmenNumber;
    }

    private static void setPostmenNumber(int postmenNumber) {
        _postmenNumber = postmenNumber;
    }

    public int getPostmanSerialNumber() {
        return _postmanSerialNumber;
    }

    @Override
    public String toString() {
        return "" + getPostmanSerialNumber();
    }
}
