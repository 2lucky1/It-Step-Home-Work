package com.muntian.ht46_post;

import java.util.LinkedList;
import java.util.List;

public class Post {
    private int _parcelsLimit;
    private int _parcelsNumber;
    private int _receivedParcelsNumber;
    private int _sentParcelsNumber;
    private List  = new LinkedList;

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

    public int get_receivedParcelsNumber() {
        return _receivedParcelsNumber;
    }

    public void set_receivedParcelsNumber(int receivedParcelsNumber) {
        _receivedParcelsNumber = receivedParcelsNumber;
    }

    public int get_sentParcelsNumber() {
        return _sentParcelsNumber;
    }

    public void set_sentParcelsNumber(int sentParcelsNumber) {
        _sentParcelsNumber = sentParcelsNumber;
    }
}
