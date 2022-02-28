package com.linkedList;

public class Starter {

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.insertStart(new SinglyLinkedList.Node(4));
        singlyLinkedList.insertStart(new SinglyLinkedList.Node(79));
        singlyLinkedList.insertEnd(new SinglyLinkedList.Node(6));
        singlyLinkedList.insertEnd(new SinglyLinkedList.Node(89));
        singlyLinkedList.insertIndex(new SinglyLinkedList.Node(293), 0);
        singlyLinkedList.insertEnd(new SinglyLinkedList.Node(22));
        singlyLinkedList.insertIndex(new SinglyLinkedList.Node(999), 5);
        singlyLinkedList.insertIndex(new SinglyLinkedList.Node(11), 3);
        singlyLinkedList.insertIndex(new SinglyLinkedList.Node(52), 2);
        singlyLinkedList.insertIndex(new SinglyLinkedList.Node(45), 0);
        singlyLinkedList.insertIndex(new SinglyLinkedList.Node(121), 5);
        singlyLinkedList.insertStart(new SinglyLinkedList.Node(43));
        singlyLinkedList.insertStart(new SinglyLinkedList.Node(712));

        singlyLinkedList.printList();


        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.insertStart(new DoublyLinkedList.Node(4));
        doublyLinkedList.insertStart(new DoublyLinkedList.Node(79));
        doublyLinkedList.insertEnd(new DoublyLinkedList.Node(6));
        doublyLinkedList.insertEnd(new DoublyLinkedList.Node(89));
        doublyLinkedList.insertIndex(new DoublyLinkedList.Node(293), 0);
        doublyLinkedList.insertEnd(new DoublyLinkedList.Node(22));
        doublyLinkedList.insertIndex(new DoublyLinkedList.Node(999), 5);
        doublyLinkedList.insertIndex(new DoublyLinkedList.Node(11), 3);
        doublyLinkedList.insertIndex(new DoublyLinkedList.Node(52), 2);
        doublyLinkedList.insertIndex(new DoublyLinkedList.Node(45), 0);
        doublyLinkedList.insertIndex(new DoublyLinkedList.Node(121), 5);
        doublyLinkedList.insertStart(new DoublyLinkedList.Node(43));
        doublyLinkedList.insertStart(new DoublyLinkedList.Node(712));
        doublyLinkedList.printList();


    }
}
