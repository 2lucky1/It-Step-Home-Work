package com.muntian.ht29_my_linked_list_with_try_catch.Exceptions;

/**
 * {@code EmptyListException} is the subclass of the RuntimeException
 * and therefore is unchecked and can be thrown  if executing invalid
 * operation with empty list.
 *
 * @author Nikolai Muntian
 * @since JDK8.0
 */
public class EmptyListException extends RuntimeException {

    /**
     * Constructs a new EmptyListException with the specified detail message.
     */
    public EmptyListException() {
        super("There are no items in the list");
    }
}
