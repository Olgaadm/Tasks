package com.linkedList;

public class Starter {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.addFirst(4);
        singlyLinkedList.addFirst(79);
        singlyLinkedList.addLast(6);
        singlyLinkedList.addLast(89);
        singlyLinkedList.add(293, 0);
        singlyLinkedList.addLast(22);
        singlyLinkedList.add(999, 5);
        singlyLinkedList.add(11, 3);
        singlyLinkedList.add(52, 2);
        singlyLinkedList.add(45, 0);
        singlyLinkedList.add(121, 5);
        singlyLinkedList.addFirst(43);
        singlyLinkedList.addFirst(712);

        singlyLinkedList.print();
        singlyLinkedList.remove(11);
        singlyLinkedList.remove(712);
        singlyLinkedList.remove(4);
        singlyLinkedList.remove(999);
        singlyLinkedList.remove(121);
        singlyLinkedList.print();

        DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.addFirst(4);
        doublyLinkedList.addFirst(79);
        doublyLinkedList.addLast(6);
        doublyLinkedList.addLast(89);
        doublyLinkedList.add(293, 0);
        doublyLinkedList.addLast(22);
        doublyLinkedList.add(999, 5);
        doublyLinkedList.add(11, 3);
        doublyLinkedList.add(52, 2);
        doublyLinkedList.add(45, 0);
        doublyLinkedList.add(121, 5);
        doublyLinkedList.addFirst(43);
        doublyLinkedList.addFirst(712);

        doublyLinkedList.print();
        doublyLinkedList.remove(11);
        doublyLinkedList.remove(712);
        doublyLinkedList.remove(4);
        doublyLinkedList.remove(999);
        doublyLinkedList.remove(121);
        doublyLinkedList.print();

    }
}
