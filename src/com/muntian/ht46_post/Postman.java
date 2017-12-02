package com.muntian.ht46_post;

public class Postman implements Runnable {
    private int _postmanCarrying;

    public Postman(int postmanCarrying) {
        _postmanCarrying = postmanCarrying;
    }

    public int get_postmanCarrying() {
        return _postmanCarrying;
    }

    public void set_postmanCarrying(int postmanCarrying) {
        _postmanCarrying = postmanCarrying;
    }

    @Override
    public void run() {

    }
}
