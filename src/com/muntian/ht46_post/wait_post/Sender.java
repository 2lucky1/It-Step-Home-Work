package com.muntian.ht46_post.wait_post;

public class Sender implements Runnable {

    private static final String ANSI_BLUE = "\u001B[34m";

    private static final int MIN_SLEEP_TIME = 5000;
    private static final int MAX_SLEEP_TIME = 25000;

    private static int _sendersNumber = 0;
    private int _senderSerialNumber;
    private int _parcelsNumberInOneTime = 1;
    private int _numberOfSentParcels = 0;
    private Post _post;

    public Sender(Post post) {
        _post = post;
        setSendersNumber(getSendersNumber() + 1);
        setSenderSerialNumber(getSendersNumber());
    }

    @Override
    public void run() {
        while (true) {
            if (_post.getParcelsNumber() < _post.getParcelsLimit()) {
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
                } catch (InterruptedException ignored) {
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
        return _numberOfSentParcels;
    }

    private void setNumberOfSentParcels(int numberOfSentParcels) {
        _numberOfSentParcels = numberOfSentParcels;
    }

    public static int getSendersNumber() {
        return _sendersNumber;
    }

    public static void setSendersNumber(int sendersNumber) {
        _sendersNumber = sendersNumber;
    }

    public int getSenderSerialNumber() {
        return _senderSerialNumber;
    }

    private void setSenderSerialNumber(int senderSerialNumber) {
        _senderSerialNumber = senderSerialNumber;
    }

    @Override
    public String toString() {
        return "" + getSenderSerialNumber();
    }
}
