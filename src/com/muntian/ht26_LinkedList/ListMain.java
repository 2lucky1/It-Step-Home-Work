package com.muntian.ht26_LinkedList;

public class ListMain {

    public static void main(String[] args) {
//        testAddToTail();
//        testAddIncorrectIndex();
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

    private static void testGetSize() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        System.out.println("Source list:");
        System.out.println(myLinkedList);
        System.out.println("Size: " + myLinkedList.size());
        myLinkedList.deleteFromTail();
        System.out.println("Changed list:");
        System.out.println(myLinkedList);
        System.out.println("Size: " + myLinkedList.size());
        System.out.println("Done testGetSize");
    }

    private static void testDeleteFromInside() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        System.out.println("Source list:");
        System.out.println(myLinkedList);
        myLinkedList.delete(10);
        System.out.println("Changed list:");
        System.out.println(myLinkedList);
        System.out.println("Done testDeleteFromInside");
    }

    private static void testDeleteFromTail() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        System.out.println("Source list:");
        System.out.println(myLinkedList);
        myLinkedList.deleteFromTail();
        System.out.println("Changed list:");
        System.out.println(myLinkedList);
        System.out.println("Done testDeleteFromTail");
    }

    private static void testDeleteFromHead() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        System.out.println("Source list:");
        System.out.println(myLinkedList);
        myLinkedList.deleteFromHead();
        System.out.println("Changed list:");
        System.out.println(myLinkedList);
        System.out.println("Done testDeleteFromHead");
    }

    private static void testReplace() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        System.out.println("Source list:");
        System.out.println(myLinkedList);
        myLinkedList.replace(20, 3);
        System.out.println("Changed list:");
        System.out.println(myLinkedList);
        System.out.println("Done testReplace");
    }

    private static void testGetContent() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        System.out.println(myLinkedList.get(5));
        System.out.println("Done testGetContent");
    }
    
    private static void testAddToHead() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToHead(1);
        myLinkedList.addToHead(2);
        myLinkedList.addToHead(3);
        myLinkedList.addToHead(4);
        System.out.println(myLinkedList);
        System.out.println("Done testAddToHead");
    }

    private static void testAddInside() {
        MyLinkedList myLinkedList = new MyLinkedList();
        System.out.println(myLinkedList);
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        myLinkedList.addToTail(5);
        myLinkedList.addToTail(6);
        myLinkedList.addToTail(7);
        myLinkedList.add(10, 1);
        myLinkedList.add(20, 6);
        System.out.println(myLinkedList);
        System.out.println("Done testAddInside");
    }

    /**
     * Test "add" with boundary values of indexes
     */
    private static void testAddIndexBounds() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, 0);
        myLinkedList.add(2, 1);
        System.out.println("Done testAddIndexBounds");
    }

    private static void testAddIncorrectIndex() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(0, -1);
        myLinkedList.add(0, 1);
        System.out.println("Done testAddIncorrectIndex");
    }

    private static void testAddToTail() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addToTail(1);
        myLinkedList.addToTail(2);
        myLinkedList.addToTail(3);
        myLinkedList.addToTail(4);
        System.out.println(myLinkedList);
        System.out.println("Done testAddToTail");
    }
}

