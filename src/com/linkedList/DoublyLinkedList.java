package com.linkedList;

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

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            head = node;
            head.previous = head;
            head.next = head;
        } else {
            node.next = head;
            node.previous = head.previous;
            head = node;
        }
        length++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            head = node;
            head.previous = head;
            head.next = head;
        } else {
            node.next = head;
            node.previous = head.previous;
            head.previous.next = node;
            head.previous = node;
        }
        length++;
    }

    public void add(T value, int index) {
        if (index < length) {
            if (index == 0) addFirst(value);
            else if (index == length - 1) addLast(value);
            else {
                Node<T> node = new Node<>(value);
                Node<T> current = head;
                for (int i = 1; i < index; i++) {
                    current = current.next;
                }
                node.next = current.next;
                node.next.previous = node;
                current.next = node;
                node.previous = current;
                length++;
            }
        } else throw new IndexOutOfBoundsException("Index not available.");
    }

    @Override
    public void remove(T value) {
        int indexOfElement = indexOf(value);
        Node<T> current = head;
        if (indexOfElement != -1) {
            if (indexOfElement == 0) {
                head = head.next;
            } else {
                for (int i = 0; i < indexOfElement; i++) {
                    current = current.next;
                }
                current.previous.next = current.next;
                current.next.previous = current.previous;
            }
            length--;
        } else System.out.println("There is no such element in list");
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        Node<T> current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public void print() {
        Node<T> current = head;
        String output = "";
        for (int i = 0; i < length; i++) {
            output = output.concat(current.value + " ");
            current = current.next;
        }
        System.out.println(output);
    }
}
