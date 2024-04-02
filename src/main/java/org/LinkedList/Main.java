package org.LinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(0);
        doubleLinkedList.add(2);
        doubleLinkedList.add(1, 1);
        doubleLinkedList.add(3);
        doubleLinkedList.remove(0);
        System.out.println(doubleLinkedList);


    }
}