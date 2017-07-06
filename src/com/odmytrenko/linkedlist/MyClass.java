package com.odmytrenko.linkedlist;

public class MyClass {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(7);
        listNode1.addLast(5);
        listNode1.addLast(2);
        listNode1.addLast(4);
        listNode1.addLast(3);
        listNode1.printList();

        ListNode listNode2 = new ListNode(5);
        listNode2.addLast(6);
        listNode2.addLast(4);
        listNode2.printList();

        ListNode listNode3 = ListNode.addTwoNumbers(listNode1, listNode2);
        listNode3.printList();
    }
}
