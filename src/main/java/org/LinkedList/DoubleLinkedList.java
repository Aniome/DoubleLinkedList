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
    public boolean add(int index, T data){
        if (index >= size)
            return false;
        if (head == null){
            add(data);
        } else {
            Node<T> New = new Node<>(data);
            Node<T> next = head;
            for (int i = 0; i < index; i++){
                next = next.next;
            }
            if (next.previous == null){
                New.previous = null;
                New.next = next;
                next.previous = New;
                head = New;
            } else {
                Node<T> previous = next.previous;
                previous.next = New;
                New.next = next;
                New.previous = previous;
                next.previous = New;
            }
            size++;
        }
        return true;
    }

    public boolean remove(T data){
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data)){
                remove(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public T removeByIndex(int index){
        //index == 0, index == size
        if (index >= size || index < 0){
            return null;
        }
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        remove(node);
        return node.data;
    }

    private void remove(Node<T> node) {
        if (node.previous != null){
            Node<T> previous = node.previous;
            previous.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null){
            Node<T> next = node.next;
            next.previous = node.previous;
        } else {
            tail = node.previous;
        }

        size--;
    }

    public void inversion(){
        Node<T> previous, next = null, current = null;
        for (int i = 0; i < size; i++) {
            if (i == 0){
                current = head;
                next = current.next;
                tail = current;
                tail.previous = next;
                tail.next = null;
            } else if (i == size - 1){
                previous = current;
                current = next;
                current.next = previous;
                current.previous = null;
                head = current;
            } else {
                previous = current;
                current = next;
                next = next.next;
                current.next = previous;
            }
        }
    }

    private Node<T> getNode(int index){
        Node<T> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public T get(int index){
        return getNode(index).data;
    }

    public T set(int index, T data){
        Node<T> node = getNode(index);
        node.data = data;
        return node.data;
    }

    public int size(){
        return size;
    }

    public boolean contains(T data){
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data)){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void clear(){
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            Node<T> previous = node;
            node = node.next;
            previous.next = null;
            previous.previous = null;
            previous.data = null;
        }
        tail = null;
        head = null;
        size = 0;
    }

    public int indexOf(T data){
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data)){
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    public int lastIndexOf(T data){
        int index = -1;
        Node<T> node = head;
        for (int i = 0; i < size; i++) {
            if (node.data.equals(data)){
                index = i;
            }
            node = node.next;
        }
        return index;
    }

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
