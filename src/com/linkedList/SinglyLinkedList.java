package com.linkedList;

public class SinglyLinkedList {

    Node head = null;
    Node tail = null;

    int length;

    static class Node {
        Node pointer;
        Object value;

        public Node(Object value) {
            this.value = value;
            this.pointer = null;
        }
    }

    public void insertStart(Node node) {
        if (this.head == null) {
            this.head = node;
            this.head.pointer = this.tail;
            this.tail = this.head;
        } else {
            node.pointer = this.head;
            this.head = node;
        }
        this.length++;
    }


    public void insertEnd(Node node) {
        if (this.head == null) {
            this.head = node;
            this.head.pointer = this.tail;
            this.tail = this.head;
        } else {
            this.tail.pointer = node;
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
                    searchNode = searchNode.pointer;
                    i++;
                }
                node.pointer = searchNode;
                leftNode.pointer = node;

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
            searchNode = searchNode.pointer;
            i++;
        }
        System.out.println(output);
    }
}
