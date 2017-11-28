package com.muntian.ht46_post;

public class Post {
    private static int _parcelsLimit;
    private static int _parcelsNumber;

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
}
