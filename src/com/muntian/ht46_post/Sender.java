package com.muntian.ht46_post;

public class Sender implements Runnable {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";


    private static final int MIN_SLEEP_TIME = 5000;
    private static final int MAX_SLEEP_TIME = 25000;

    private static int _sendersNumber = 0;
    private int _senderSerialNumber;
    private int _parcelsNumberInOneTime = 1;
    private int numberOfSentParcels = 0;
    private Post _post;

    public Sender(Post post) {
        _post = post;
        set_sendersNumber(get_sendersNumber() + 1);
        set_senderSerialNumber(get_sendersNumber());
    }

    @Override
    public void run() {
        while (true) {
            if (_post.get_parcelsNumber() < _post.get_parcelsLimit()) {
                _post.acceptParcel(getParcelsNumberInOneTime());
                setNumberOfSentParcels(getNumberOfSentParcels() + 1);
                System.out.println(ANSI_BLUE + "Sender " + this + " have brought a parcel");
                try {
                    Thread.sleep(randomSleepTime());
                } catch (InterruptedException e) {
                    break;
                }
            } else {
                try {
                    Thread.sleep(MIN_SLEEP_TIME);
                } catch (InterruptedException e) {
                    //ignore
                }
            }
        }
    }

    public long randomSleepTime() {
        return MIN_SLEEP_TIME + (long) (Math.random() * MAX_SLEEP_TIME);
    }

    public int getParcelsNumberInOneTime() {
        return _parcelsNumberInOneTime;
    }

    public void setParcelsNumberInOneTime(int parcelsNumberInOneTime) {
        _parcelsNumberInOneTime = parcelsNumberInOneTime;
    }

    public int getNumberOfSentParcels() {
        return numberOfSentParcels;
    }

    private void setNumberOfSentParcels(int numberOfSentParcels) {
        this.numberOfSentParcels = numberOfSentParcels;
    }

    public static int get_sendersNumber() {
        return _sendersNumber;
    }

    public static void set_sendersNumber(int _sendersNumber) {
        Sender._sendersNumber = _sendersNumber;
    }

    public int get_senderSerialNumber() {
        return _senderSerialNumber;
    }

    private void set_senderSerialNumber(int senderSerialNumber) {
        _senderSerialNumber = senderSerialNumber;
    }

    @Override
    public String toString() {
        return "" + get_senderSerialNumber();
    }
}
