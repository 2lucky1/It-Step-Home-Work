package com.muntian.ht29_my_linked_list_with_try_catch;

import com.muntian.ht29_my_linked_list_with_try_catch.Exceptions.EmptyListException;
import com.muntian.ht29_my_linked_list_with_try_catch.Exceptions.IndexOutOfBoundsOfListException;

public class ListMain {

    private static final String DONE_TEST = "Done test";
    private static final String SOURCE_LIST = "Source list:";
    private static final String CHANGED_LIST = "Changed list:";
    private static final String SIZE = "Size:";

    public static void main(String[] args) {
//        testAddToTail();
        testAddIncorrectIndex();
//        testAddIndexBounds();
//        testAddInside();
//        testAddToHead();
//        testGetContent();
//        testReplace();
//        testDeleteFromHead();
//        testDeleteFromTail();
//        testDeleteFromInside();
//        testGetSize();
    }

    private static void additionOfElements(MyLinkedList myLinkedList) {
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
    }

    private static void testGetSize() {
        MyLinkedList myLinkedList = new MyLinkedList();
        additionOfElements(myLinkedList);
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        System.out.println(SIZE + " " + myLinkedList.size());
        try {
            myLinkedList.deleteFromTail();
        } catch (EmptyListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(SIZE + " " + myLinkedList.size());
        System.out.println(DONE_TEST + "GetSize");
    }

    private static void testDeleteFromInside() {
        MyLinkedList myLinkedList = new MyLinkedList();
        additionOfElements(myLinkedList);
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        try {
            myLinkedList.delete(10);
        } catch (IndexOutOfBoundsOfListException | EmptyListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(DONE_TEST + "DeleteFromInside");
    }

    private static void testDeleteFromTail() {
        MyLinkedList myLinkedList = new MyLinkedList();
        additionOfElements(myLinkedList);
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        try {
            myLinkedList.deleteFromTail();
        } catch (EmptyListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(DONE_TEST + "DeleteFromTail");
    }

    private static void testDeleteFromHead() {
        MyLinkedList myLinkedList = new MyLinkedList();
        additionOfElements(myLinkedList);
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        try {
            myLinkedList.deleteFromHead();
        } catch (EmptyListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(DONE_TEST + "DeleteFromHead");
    }


    private static void testReplace() {
        MyLinkedList myLinkedList = new MyLinkedList();
        additionOfElements(myLinkedList);
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        try {
            myLinkedList.replace(20, 3);
        } catch (IndexOutOfBoundsOfListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(DONE_TEST + "Replace");
    }

    private static void testGetContent() {
        MyLinkedList myLinkedList = new MyLinkedList();
        additionOfElements(myLinkedList);
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        try {
            System.out.println(myLinkedList.getContent(5));
        } catch (IndexOutOfBoundsOfListException | EmptyListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(DONE_TEST + "GetContent");
    }

    private static void testAddToHead() {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        myLinkedList.addToHead(1);
        myLinkedList.addToHead(2);
        myLinkedList.addToHead(3);
        myLinkedList.addToHead(4);
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(DONE_TEST + "AddToHead");
    }

    private static void testAddInside() {
        MyLinkedList myLinkedList = new MyLinkedList();
        additionOfElements(myLinkedList);
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        try {
            myLinkedList.add(10, 2);
            myLinkedList.add(20, 6);
        } catch (IndexOutOfBoundsOfListException e) {
            e.printStackTrace();
        }
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(DONE_TEST + "AddInside");
    }

    /**
     * Test "add" with boundary values of indexes
     */
    private static void testAddIndexBounds() {
        MyLinkedList myLinkedList = new MyLinkedList();
        try {
            myLinkedList.add(0, 0);
            myLinkedList.add(2, 1);
        } catch (IndexOutOfBoundsOfListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(DONE_TEST + "AddIndexBounds");
    }

    private static void testAddIncorrectIndex() {
        MyLinkedList myLinkedList = new MyLinkedList();
        try {
            myLinkedList.add(0, -1);
            myLinkedList.add(0, 1);
        } catch (IndexOutOfBoundsOfListException e) {
            e.printStackTrace();
            return;
        }
        System.out.println(DONE_TEST + "AddIncorrectIndex");
    }

    private static void testAddToTail() {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(SOURCE_LIST + "\n" + myLinkedList);
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        System.out.println(CHANGED_LIST + "\n" + myLinkedList);
        System.out.println(DONE_TEST + "AddToTail");
    }
}
