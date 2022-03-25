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

    @Override
    public void insertHead(T value) {
        insert(value, 0);
    }


    @Override
    public void append(T value) {
        if (value != null) {
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
    }

    @Override
    public void insert(T value, int index) {
        if (value != null) {
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
    }

    @Override
    public boolean remove(T value) {
        if (value == null) return false;
        else {
            if (length != 0) {
                var current = tail.next;
                var previous = tail;
                if (current.equals(previous)) tail = null;
                else {
                    while (!current.value.equals(value))
                    {
                        // if loop went through whole list
                        if (current.equals(tail)) return false;
                        else {
                            previous = current;
                            current = current.next;
                        }
                    }
                    previous.next = current.next;
                    if (current.equals(tail)) tail = previous;
                }
                length--;
            } else throw new IndexOutOfBoundsException("There are no elements in list yet");
        }
        return true;
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

    @Override
    public Object[] toArray() {
        Object[] array = null;
        if (length != 0) {
            array = new Object[length];
            Node<T> current = tail.next;
            for (int i = 0; i < length; i++) {
                array[i] = current.value;
                current = current.next;
            }
        }
        return array;
    }

    private void insertAtEmptyList(Node<T> node) {
        tail = node;
        tail.next = tail;
    }
}
