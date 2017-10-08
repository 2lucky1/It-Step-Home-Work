package com.muntian.ht26_LinkedList.Exceptions;

public class IndexOutOfBoundsOfListException extends Exception {
    private long index;

    public IndexOutOfBoundsOfListException(long index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "IndexOutOfBoundsOfListException! Incorrect input of index.\nindex = " + index;
    }
}
