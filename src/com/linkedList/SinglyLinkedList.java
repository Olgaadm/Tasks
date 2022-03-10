package com.linkedList;

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

    public void addFirst(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            tail = node;
            tail.next = tail;
        } else {
            node.next = tail.next;
            tail.next = node;
        }
        length++;
    }

    public void addLast(T value) {
        Node<T> node = new Node<>(value);
        if (length == 0) {
            tail = node;
            tail.next = tail;
        } else {
            node.next = tail.next;
            tail.next = node;
            tail = node;
        }
        length++;
    }

    public void add(T value, int index) {
        if (index < length) {
            if (index == 0) addFirst(value);
            else if (index == length - 1) addLast(value);
            else {
                Node<T> node = new Node<>(value);
                Node<T> currentNode = tail.next;
                Node<T> previousNode = null;
                for (int i = 0; i < index; i++) {
                    previousNode = currentNode;
                    currentNode = currentNode.next;
                }
                node.next = currentNode;
                previousNode.next = node;
                length++;
            }
        } else throw new IndexOutOfBoundsException("Index not available.");
    }

    @Override
    public void remove(T value) {
        int indexOfElement = indexOf(value);
        Node<T> current = tail.next;
        Node<T> previousNode = null;
        if (indexOfElement != -1) {
            if (indexOfElement == 0) {
                tail.next = current.next;
            } else {
                for (int i = 0; i < indexOfElement; i++) {
                    previousNode = current;
                    current = current.next;
                }
                previousNode.next = current.next;
            }
            length--;
        } else System.out.println("There is no such element in list");
    }

    @Override
    public int indexOf(T value) {
        int index = 0;
        Node<T> current = tail.next;
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
        Node<T> current = tail.next;
        String output = "";
        for (int i = 0; i < length; i++) {
            output = output.concat(current.value + " ");
            current = current.next;
        }
        System.out.println(output);
    }
}
