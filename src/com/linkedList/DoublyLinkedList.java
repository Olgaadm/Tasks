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

    @Override
    public void insertHead(T value) {
        if (value != null) {
            Node<T> node = new Node<>(value);
            if (length == 0) {
                insertAtEmptyList(node);
            } else {
                node.next = head;
                node.previous = head.previous;
                head.previous = node;
                if (head.next.equals(head)) head.next = node;
                head = node;
            }
            length++;
        }
    }

    @Override
    public void append(T value) {
        //insert after last element in list(after head.previous)
        insert(value, length);
    }

    @Override
    public void insert(T value, int index) {
        if (value != null) {
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
    }

    @Override
    public boolean remove(T value) {
        if (value == null) return false;
        else {
            if (length != 0) {
                var current = head;
                if (current.equals(current.previous)) head = null;
                else {
                    while (!current.value.equals(value)) {
                        if (current.next.equals(head)) return false;
                        else
                            current = current.next;
                    }
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                    if (current.equals(head)) {
                        head = head.next;
                    }
                }
                length--;
            } else throw new IndexOutOfBoundsException("There are no elements in list yet");
        }
        return true;
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
    public Object[] toArray() {
        Object[] array = null;
        if (length != 0) {
            array = new Object[length];
            Node<T> current = head;
            for (int i = 0; i < length; i++) {
                array[i] = current.value;
                current = current.next;
            }
        }
        return array;
    }

    private void insertAtEmptyList(Node<T> node) {
        head = node;
        head.previous = head;
        head.next = head;
    }
}
