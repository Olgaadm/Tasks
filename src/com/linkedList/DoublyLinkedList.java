package com.linkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;

    private int length;

    private static class Node<T> {
        private Node<T> next;
        private Node<T> previous;
        private final T value;

        private Node(T value) {
            this.value = value;
        }
    }

    @Override
    public void insertHead(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            insertAtEmptyList(node);
        } else {
            node.next = head;
            node.previous = head.previous;
            head.previous = node;
            head = node;
        }
        length++;
    }

    @Override
    public void append(T value) {
        //insert after last element in list(after head.previous)
        insert(value, length);
    }

    @Override
    public void insert(T value, int index) {
        Node<T> node = new Node<>(value);
        if (index == 0) {
            insertHead(value);
        } else if (index > 0 && index <= length) {
            var currentNode = head;
            if (index != length) {
                for (int i = 0; i < index; i++) {
                    currentNode = currentNode.next;
                }
            }
            node.next = currentNode;
            node.previous = currentNode.previous;
            currentNode.previous.next = node;
            currentNode.previous = node;
            length++;
        } else throw new IndexOutOfBoundsException("Index is not available");
    }

    @Override
    public void remove(T value) {
        if (length != 0) {
            int i = 0;
            Node<T> current = head;
            while (!current.value.equals(value)) {
                current = current.next;
                // if loop went through whole list
                if (i == length) throw new NoSuchElementException("There is no such element in list");
                i++;
            }
            if (i == 0) {
                head.previous.next = head.next;
                head = head.next;

            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            length--;
        } else throw new IndexOutOfBoundsException("There are no elements in list yet");
    }

    @Override
    public int indexOf(T value) {
        if (length != 0) {
            Node<T> current = head;
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
        Node<T> current = head;
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
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.value;
        } else throw new IndexOutOfBoundsException("Index is not correct or list is empty");
    }

    @Override
    public T[] toArray() {
        if (length != 0) {
            T[] array = (T[]) new Object[length];
            Node<T> current = head;
            for (int i = 0; i < length; i++) {
                array[i] = current.value;
                current = current.next;
            }
            return array;
        } else return null;
    }

    private void insertAtEmptyList(Node<T> node) {
        head = node;
        head.previous = head;
        head.next = head;
    }
}
