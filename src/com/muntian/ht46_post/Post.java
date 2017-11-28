package com.muntian.ht46_post;

public class Post {
    private static int _parcelsLimit;
    private static int _parcelsNumber;
    private static int _receivedParcelsNumber;
    private static int _sentParcelsNumber;

    public Post(int parcelsLimit) {
        _parcelsLimit = parcelsLimit;
    }

    public static int get_parcelsLimit() {
        return _parcelsLimit;
    }

    public static void set_parcelsLimit(int parcelsLimit) {
        _parcelsLimit = parcelsLimit;
    }

    public static int get_parcelsNumber() {
        return _parcelsNumber;
    }

    public static void set_parcelsNumber(int parcelsNumber) {
        _parcelsNumber = parcelsNumber;
    }

    public static int get_receivedParcelsNumber() {
        return _receivedParcelsNumber;
    }

    public static void set_receivedParcelsNumber(int receivedParcelsNumber) {
        _receivedParcelsNumber = receivedParcelsNumber;
    }

    public static int get_sentParcelsNumber() {
        return _sentParcelsNumber;
    }

    public static void set_sentParcelsNumber(int sentParcelsNumber) {
        _sentParcelsNumber = sentParcelsNumber;
    }
}
