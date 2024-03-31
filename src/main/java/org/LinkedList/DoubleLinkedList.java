package org.LinkedList;

import java.util.Objects;

public class DoubleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public void add(T data){
        if (head == null){
            head = new Node<>(data);
            head.next = null;
            head.previous = null;
            tail = head;
        } else {
            Node<T> node = new Node<>(data);
            tail.next = node;
            node.previous = tail;
            node.next = null;
            tail = node;
        }
        size++;
    }
    public void add(int index, T data){
        Node<T> node = head;
        for (int i = 0; i < index; i++){
            node = node.next;
        }
        Node<T> New = new Node<>(data);
        Node<T> next = node.next;
        New.next = next;
        New.previous = node;
        next.previous = New;
        node.next = New;
        size++;
    }
    /*public void add(int index, T data)
    public boolean remove(T data)
    private void remove(Node<T> node, Node<T> prev)
    public T removeByIndex(int index)
    public SingleLinkedList<T> inversion()
    public T get(int index)
    public T set(int index, T data)
    private Node<T> getNode(int index)
    public int size()
    @Override
    public String toString()
    public boolean contains(T data)
    public void clear()
    public int indexOf(T data)
    public int lastIndexOf(T data)
    */

    @Override
    public String toString() {
        if (head == null) {
            return "List is empty";
        }
        StringBuilder SingleLinkedList = new StringBuilder();
        Node<T> node = head;
        for(int i = 0; i < size; i++){
            SingleLinkedList.append(i).append(" = ").append(node.data);
            if (i != size-1)
                SingleLinkedList.append("\n");
            node = node.next;
        }
        return SingleLinkedList.toString();
    }

    public boolean isEmpty(){
        return head == null;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        DoubleLinkedList<?> that = (DoubleLinkedList<?>) object;
        return size == that.size && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }
}
