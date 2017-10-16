package com.muntian.ht29_my_linked_list_with_try_catch.Exceptions;

public class IndexOutOfBoundsOfListException extends Exception {
    private long index;
    public IndexOutOfBoundsOfListException(long index,long firstIndex,long size) {
        this.index = index;
        System.err.println("IndexOutOfBoundsOfListException! Incorrect input of index.\nEntered index = " + index +
                            "The correct value of the index lies in the range from " + firstIndex + " to " + size);
    }
}
