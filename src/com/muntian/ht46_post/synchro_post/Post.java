package com.muntian.ht46_post.synchro_post;

public class Post {
    private int _parcelsLimit;
    private int _parcelsNumber;
    private int _acceptedParcelsNumber;
    private int _sentParcelsNumber;

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

    public synchronized void acceptParcel(int numberOfParcels) {
        setParcelsNumber(getParcelsNumber() + numberOfParcels);
        setAcceptedParcelsNumber(getAcceptedParcelsNumber() + numberOfParcels);
    }

    public synchronized void giveParcel(int numberOfParcels) {
        setParcelsNumber(getParcelsNumber() - numberOfParcels);
        setSentParcelsNumber(getSentParcelsNumber() + numberOfParcels);
    }
}
