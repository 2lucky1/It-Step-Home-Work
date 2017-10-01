package com.muntian.ht26_LinkedList;

/**
 * Linked list
 */
public class MyLinkedList {
    private Element _head;
    private Element _tail;
    private long _size;

    public MyLinkedList() {
        _head = null;
        _tail = null;
        _size = 0;
    }

    /**
     * Adds data to the end of the list
     *
     * @param data value for adding
     */
    public void addToTail(int data) {
        Element newElement = new Element(data);
        if (_size == 0) {
            addToEmptyList(newElement);
        } else {
            _tail.next = newElement;
            newElement.prev = _tail;
            _tail = newElement;
            _size++;
        }
    }

    private void addToEmptyList(Element newElement) {
        newElement.next = null;
        newElement.prev = null;
        _tail = newElement;
        _head = newElement;
        _size++;
    }

    public void add(int data, long index) {
        Element newElement = new Element(data);
        if (index < 0 || index > _size) {
            System.err.println("Out of the list boards");
            return;
        }
        if (_size == 0) {
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

    public void addToHead(int data) {
        Element newElement = new Element(data);
        if (_size == 0) {
            addToEmptyList(newElement);
        } else {
            _head.prev = newElement;
            newElement.next = _head;
            _head = newElement;
            _size++;
        }
    }

    public int get(long index) {
        if (_size == 0) {
            System.err.println("List is empty");
            return -1;
        }
        return getElement(index).content;
    }

    public void replace(int newData, long index) {
        getElement(index).content = newData;
    }

    public void deleteFromHead() {
        if (_size == 0) {
            System.err.println("List is empty");
        } else {
             _head = getElement(1);
            _size--;
        }
    }

    public void deleteFromTail() {
        if (_size == 0) {
            System.err.println("List is empty");
        } else {
            _tail = getElement(size()-2);
            _size--;
        }
    }

    public void delete(long index) {
        if (_size == 0) {
            System.err.println("List is empty");
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

    public long size() {
        return _size;
    }

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
