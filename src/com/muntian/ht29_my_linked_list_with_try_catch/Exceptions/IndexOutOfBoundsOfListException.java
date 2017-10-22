package com.muntian.ht29_my_linked_list_with_try_catch.Exceptions;

/**
 * {@code IndexOutOfBoundsOfListException} is the subclass of
 * the RuntimeException and therefore is unchecked and can be
 * thrown during execution of operation with the list if enter
 * invalid value of the index.
 *
 * @author Nikolai Muntian
 * @since JDK8.0
 */
public class IndexOutOfBoundsOfListException extends RuntimeException {

    /**
     * Constructs a new EmptyListException with the specified detail message.
     *
     * @param index the the index of the element of the list.
     * @param firstIndex the lowest index value
     * @param size the size of the list
     */
    public IndexOutOfBoundsOfListException(long index,long firstIndex,long size) {
        super("Incorrect input of index.\nEntered index = " + index +
                " The correct value of the index lies in the range from " + firstIndex + " to " + size);
    }
}
