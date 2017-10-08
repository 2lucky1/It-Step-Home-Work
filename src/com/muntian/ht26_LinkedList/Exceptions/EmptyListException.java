package com.muntian.ht26_LinkedList.Exceptions;

public class EmptyListException extends Exception {

    @Override
    public String toString() {
        return "EmptyListException! There are no items in the list";
    }
}
