package com.muntian.ht46_post.executor_post;

public class Post {
    private int _parcelsLimit;
    private int _parcelsNumber;
    private int _acceptedParcelsNumber;
    private int _sentParcelsNumber;
    private final Object _mutex = new Object();

    public Post(int parcelsLimit) {
        _parcelsLimit = parcelsLimit;
    }

    public int get_parcelsLimit() {
        return _parcelsLimit;
    }

    public void set_parcelsLimit(int parcelsLimit) {
        _parcelsLimit = parcelsLimit;
    }

    public int get_parcelsNumber() {
        return _parcelsNumber;
    }

    public void set_parcelsNumber(int parcelsNumber) {
        _parcelsNumber = parcelsNumber;
    }

    public int get_acceptedParcelsNumber() {
        return _acceptedParcelsNumber;
    }

    public void set_acceptedParcelsNumber(int receivedParcelsNumber) {
        _acceptedParcelsNumber = receivedParcelsNumber;
    }

    public int get_sentParcelsNumber() {
        return _sentParcelsNumber;
    }

    public void set_sentParcelsNumber(int sentParcelsNumber) {
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
            set_parcelsNumber(_parcelsNumber + numberOfParcels);
            set_acceptedParcelsNumber(_acceptedParcelsNumber + numberOfParcels);
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

            set_parcelsNumber(_parcelsNumber - numberOfParcels);
            set_sentParcelsNumber(_sentParcelsNumber + numberOfParcels);
            _mutex.notifyAll();
        }
    }
}
