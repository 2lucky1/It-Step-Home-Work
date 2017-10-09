package com.muntian.ht29_my_linked_list_with_try_catch.Exceptions;

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
