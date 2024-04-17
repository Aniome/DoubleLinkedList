package org.LinkedList;

public class Main {
    public static void main(String[] args) {
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<>();
        doubleLinkedList.add(0);
        doubleLinkedList.add(2);
        System.out.println("data was added : " + doubleLinkedList.add(1, 1));
        doubleLinkedList.add(3);
        doubleLinkedList.add(0);
        System.out.println("was remove by index: " + doubleLinkedList.removeByIndex(3));
        doubleLinkedList.inversion();
        System.out.println(doubleLinkedList);
        System.out.println("index = " + doubleLinkedList.indexOf(2));
        System.out.println("last index of 0: " + doubleLinkedList.lastIndexOf(0));
        System.out.println(doubleLinkedList);
        System.out.println("list size: " + doubleLinkedList.size());
        System.out.println("0 contains: " + doubleLinkedList.contains(0));
        doubleLinkedList.add(4);
        System.out.println("4 was remove: " + doubleLinkedList.remove(4));
        System.out.println("0 index: " + doubleLinkedList.get(0));
        System.out.println("0 index was set: " + doubleLinkedList.set(0, 5));
        doubleLinkedList.clear();
        System.out.println("list is empty : " + doubleLinkedList.isEmpty());
    }
}