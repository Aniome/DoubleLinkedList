package org.LinkedList;

public class Node<T> {
    public Node(T data) {
        this.data = data;
    }
    T data;
    Node<T> next;
    Node<T> previous;
}
