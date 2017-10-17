package com.muntian.ht29_my_linked_list_with_try_catch;

import com.muntian.ht29_my_linked_list_with_try_catch.Exceptions.EmptyListException;
import com.muntian.ht29_my_linked_list_with_try_catch.Exceptions.IndexOutOfBoundsOfListException;

/**
 * Linked list
 */
public class MyLinkedList {
    private static final int FIRST_INDEX = 0;
    private Element _head;
    private Element _tail;
    private long _size;

    /**
     * Creates a list with default values of its fields
     */
    public MyLinkedList() {
        _head = null;
        _tail = null;
        _size = 0;
    }


    /**
     * Adds new element to empty list
     *
     * @param newElement the new element to add
     */
    private void addToEmptyList(Element newElement) {
        newElement.next = null;
        newElement.prev = null;
        _tail = newElement;
        _head = newElement;
        _size++;
    }

    /**
     * Checks belongs of the entered index to the range of indexes of the list
     *
     * @param index the entered index
     * @return true if the index is outside the bounds of the list
     */
    private boolean checkOfIndexBelongsToListBoundaries(long index) {
        return (index < 0 || index > _size);
    }

    /**
     * Adds new element to the list by index
     *
     * @param data  the value of the new element
     * @param index the index by which the new element will be inserted
     * @throws IndexOutOfBoundsOfListException
     */
    public void add(int data, long index) throws IndexOutOfBoundsOfListException {
        Element newElement = new Element(data);
        if (checkOfIndexBelongsToListBoundaries(index)) {
            throw new IndexOutOfBoundsOfListException(index, FIRST_INDEX, size());
        }
        if (emptyListCheck()) {
            addToEmptyList(newElement);
            return;
        }
        if (index == 0) {
            addToHead(data);
            return;
        }
        if (index == _size) {
            addToTail(data);
            return;
        }

        Element prevElement = getElement(index - 1);
        Element nextElement = prevElement.next;
        prevElement.next = newElement;
        newElement.prev = prevElement;
        nextElement.prev = newElement;
        newElement.next = nextElement;
        _size++;
    }

    /**
     * Adds data to the begin of the list
     *
     * @param data the value for adding
     */
    public void addToHead(int data) {
        Element newElement = new Element(data);
        if (emptyListCheck()) {
            addToEmptyList(newElement);
        } else {
            _head.prev = newElement;
            newElement.next = _head;
            _head = newElement;
            _size++;
        }
    }

    /**
     * Adds data to the end of the list
     *
     * @param data the value for adding
     */
    public void addToTail(int data) {
        Element newElement = new Element(data);
        if (emptyListCheck()) {
            addToEmptyList(newElement);
        } else {
            _tail.next = newElement;
            newElement.prev = _tail;
            _tail = newElement;
            _size++;
        }
    }

    /**
     * Allows to get the content of the element by index
     *
     * @param index the index of the element, whose content we need to obtain
     * @return integer value of content of the element
     * @throws IndexOutOfBoundsOfListException
     * @throws EmptyListException
     */
    public int getContent(long index) throws IndexOutOfBoundsOfListException, EmptyListException {
        if (checkOfIndexBelongsToListBoundaries(index)) {
            throw new IndexOutOfBoundsOfListException(index, FIRST_INDEX, size());
        }
        if (emptyListCheck()) {
            throw new EmptyListException();
        }
        return getElement(index).content;
    }

    /**
     * Replaced content of the element by needed value
     *
     * @param newData - new value of the content
     * @param index   - the index of the element over which replacement operation will be performed
     * @throws IndexOutOfBoundsOfListException
     */
    public void replace(int newData, long index) throws IndexOutOfBoundsOfListException {
        if (checkOfIndexBelongsToListBoundaries(index)) {
            throw new IndexOutOfBoundsOfListException(index, FIRST_INDEX, size());
        }
        getElement(index).content = newData;
    }

    /**
     * Delete data from the head of the list
     *
     * @throws EmptyListException
     */
    public void deleteFromHead() throws EmptyListException {
        if (emptyListCheck()) {
            throw new EmptyListException();
        } else {
            _head = getElement(1);
            _size--;
        }
    }

    /**
     * Delete data from the tail of the list
     *
     * @throws EmptyListException
     */
    public void deleteFromTail() throws EmptyListException {
        if (emptyListCheck()) {
            throw new EmptyListException();
        } else {
            _tail = getElement(size() - 2);
            _size--;
        }
    }

    /**
     * Delete data from the list by index
     *
     * @param index index of the element to be deleted
     * @throws IndexOutOfBoundsOfListException
     * @throws EmptyListException
     */
    public void delete(long index) throws IndexOutOfBoundsOfListException, EmptyListException {
        if (checkOfIndexBelongsToListBoundaries(index)) {
            throw new IndexOutOfBoundsOfListException(index, FIRST_INDEX, size());
        }
        if (emptyListCheck()) {
            throw new EmptyListException();
        } else if (index == 0) {
            deleteFromHead();
            return;
        }
        if (index == _size) {
            deleteFromTail();
            return;
        }

        Element prevElement = getElement(index - 1);
        Element nextElement = prevElement.next.next;
        prevElement.next = nextElement;
        nextElement.prev = prevElement;
        _size--;
    }

    /**
     * Checks if the list is empty
     *
     * @return true if the list is empty
     */
    private boolean emptyListCheck() {
        return _size == 0;
    }

    /**
     * Allows to get size of the list
     *
     * @return value of the size of the list
     */
    public long size() {
        return _size;
    }

    /**
     * Allows to get the element from the list, using search from
     * the "head" or from the "tail" depend on value of the index.
     *
     * @param index the index of the element
     * @return element
     */
    private Element getElement(long index) {
        long middle = _size / 2;
        if (index <= middle) {
            return searchFromHead(index);
        }
        return searchFromTail(index);
    }

    private Element searchFromTail(long index) {
        Element result = _tail;
        long steps = _size - 1 - index;
        for (long i = 0; i < steps; ++i) {
            result = result.prev;
        }
        return result;
    }

    private Element searchFromHead(long index) {
        Element result = _head;
        for (long i = 0; i < index; ++i) {
            result = result.next;
        }
        return result;
    }

    /**
     * Describes element of the list
     */
    private static class Element {
        Element prev;
        int content;
        Element next;

        Element(int content) {
            this.content = content;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        Element currentElement = _head;
        for (int i = 0; i < _size - 1; ++i) {
            stringBuilder.append(currentElement.content).append(", ");
            currentElement = currentElement.next;
        }
        if (currentElement != null) {
            stringBuilder.append(currentElement.content);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
