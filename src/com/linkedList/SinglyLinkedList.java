package com.linkedList;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> tail;

    private int length;

    private static class Node<T> {
        private Node<T> next;
        private final T value;

        private Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void insertHead(T value) {
        insert(value, 0);
    }


    @Override
    public void append(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            insertAtEmptyList(node);
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        length++;
    }

    @Override
    public void insert(T value, int index) {
        Node<T> node = new Node<>(value);
        if (length == 0 && index == 0) {
            insertAtEmptyList(node);
        } else if (index >= 0 && index < length) {
            var currentNode = tail;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            node.next = currentNode.next;
            currentNode.next = node;
        } else throw new IndexOutOfBoundsException("Index is not available");
        length++;
    }

    @Override
    public void remove(T value) {
        if (length != 0) {
            int i = 0;
            var current = tail.next;
            var previous = tail;
            while (!current.value.equals(value)) {
                // if loop went through whole list
                if (i == length) throw new NoSuchElementException("There is no such element in list");
                else {
                    previous = current;
                    current = current.next;
                    i++;
                }
            }
            if (i == 0) tail.next = current.next;
            else previous.next = current.next;
            length--;
        } else throw new IndexOutOfBoundsException("There are no elements in list yet");

    }

    @Override
    public int indexOf(T value) {
        if (length != 0) {
            Node<T> current = tail.next;
            for (int i = 0; i < length; i++) {
                if (current.value.equals(value)) {
                    return i;
                }
                current = current.next;
            }
        } else {
            throw new IndexOutOfBoundsException("There are no elements in list yet");
        }
        return -1;
    }

    @Override
    public void print() {
        Node<T> current = tail.next;
        String output = "";
        for (int i = 0; i < length; i++) {
            output = output.concat(current.value + " ");
            current = current.next;
        }
        System.out.println(output);
    }

    @Override
    public T get(int index) {
        if (length != 0 && index >= 0 && index < length) {
            Node<T> current = tail.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        } else throw new IndexOutOfBoundsException("Index is not correct or list is empty");
    }

    //? there is a question about return
    @Override
    public T[] toArray() {
        if (length != 0) {
            T[] array = (T[]) new Object[length];
            Node<T> current = tail.next;
            for (int i = 0; i < length; i++) {
                array[i] = current.value;
                current = current.next;
            }
            return array;
        } else return null;
    }

    private void insertAtEmptyList(Node<T> node) {
        tail = node;
        tail.next = tail;
    }
}
