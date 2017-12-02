package com.muntian.ht46_post;

import java.util.LinkedList;
import java.util.List;

public class Post {
    private int _parcelsLimit;
    private int _parcelsNumber;
    private int _acceptedParcelsNumber;
    private int _sentParcelsNumber;
    private List<Parcel> parcels = new LinkedList<>();

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

    public synchronized void acceptParcel(int numberOfParcels) {
        set_parcelsNumber(this.get_parcelsNumber() + numberOfParcels);
        set_acceptedParcelsNumber(get_acceptedParcelsNumber() + numberOfParcels);
    }

    public synchronized void giveParcel(int numberOfParcels) {
        set_parcelsNumber(get_parcelsNumber() - numberOfParcels);
        set_sentParcelsNumber(get_sentParcelsNumber() + numberOfParcels);
    }
}
