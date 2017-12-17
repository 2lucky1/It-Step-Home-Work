package com.muntian.ht46_post.wait_post;

public class Post {
    private int _parcelsLimit;
    private int _parcelsNumber;
    private int _acceptedParcelsNumber;
    private int _sentParcelsNumber;
    private final Object _mutex = new Object();

    public Post(int parcelsLimit) {
        _parcelsLimit = parcelsLimit;
    }

    public int getParcelsLimit() {
        return _parcelsLimit;
    }

    public void setParcelsLimit(int parcelsLimit) {
        _parcelsLimit = parcelsLimit;
    }

    public int getParcelsNumber() {
        return _parcelsNumber;
    }

    public void setParcelsNumber(int parcelsNumber) {
        _parcelsNumber = parcelsNumber;
    }

    public int getAcceptedParcelsNumber() {
        return _acceptedParcelsNumber;
    }

    public void setAcceptedParcelsNumber(int receivedParcelsNumber) {
        _acceptedParcelsNumber = receivedParcelsNumber;
    }

    public int getSentParcelsNumber() {
        return _sentParcelsNumber;
    }

    public void setSentParcelsNumber(int sentParcelsNumber) {
        _sentParcelsNumber = sentParcelsNumber;
    }

    public void acceptParcel(int numberOfParcels) {
        synchronized (_mutex) {
            while (_parcelsNumber >= _parcelsLimit) {
                try {
                    _mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            setParcelsNumber(_parcelsNumber + numberOfParcels);
            setAcceptedParcelsNumber(_acceptedParcelsNumber + numberOfParcels);
            _mutex.notifyAll();
        }
    }

    public void giveParcel(int numberOfParcels) {
        synchronized (_mutex) {
            while (_parcelsNumber <= 0) {
                try {
                    _mutex.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            setParcelsNumber(_parcelsNumber - numberOfParcels);
            setSentParcelsNumber(_sentParcelsNumber + numberOfParcels);
            _mutex.notifyAll();
        }
    }
}
