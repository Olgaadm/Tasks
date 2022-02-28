package com.linkedList;

public class DoublyLinkedList {

    Node head = null;
    Node tail = null;

    int length;

    static class Node {
        Node pointerNext;
        Node pointerPrevious;
        Object value;

        public Node(Object value) {
            this.value = value;
            this.pointerNext = null;
            this.pointerPrevious = null;
        }
    }

    public void insertStart(Node node) {
        if (this.head == null) {
            this.head = node;
            this.head.pointerNext = this.tail;
            this.tail = this.head;
        } else {
            node.pointerNext = this.head;
            this.head.pointerPrevious = node;
            this.head = node;
        }
        this.length++;
    }

    public void insertEnd(Node node) {
        if (this.head == null) {
            this.head = node;
            this.head.pointerNext = this.tail;
            this.tail = this.head;
        } else {
            this.tail.pointerNext = node;
            node.pointerPrevious = this.tail;
            this.tail = node;
        }
        this.length++;
    }

    public void insertIndex(Node node, int index) {
        if (index < this.length) {
            if (index == 0) {
                insertStart(node);
            } else {
                int i = 0;
                Node searchNode = this.head;
                Node leftNode = null;
                while (i < index) {
                    leftNode = searchNode;
                    searchNode = searchNode.pointerNext;
                    i++;
                }
                node.pointerPrevious = leftNode.pointerNext;
                node.pointerNext = searchNode;
                leftNode.pointerNext = node;

                this.length++;
            }
        } else throw new IndexOutOfBoundsException("Index not available.");
    }

    public void printList() {
        int i = 0;
        Node searchNode = this.head;
        String output = "";
        while (i < length) {
            output = output.concat(searchNode.value + " ");
            searchNode = searchNode.pointerNext;
            i++;
        }
        System.out.println(output);
    }
}
