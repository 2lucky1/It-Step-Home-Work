package com.muntian.ht29_my_linked_list_with_try_catch.Exceptions;

public class EmptyListException extends Exception {

    @Override
    public String toString() {
        return "EmptyListException! There are no items in the list";
    }
}
