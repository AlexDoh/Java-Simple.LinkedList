package com.odmytrenko.linkedlist;

public class ListNodeUtils {

    public static void addLast(ListNode node, int val) {
        if (node.next == null) {
            node.next = new ListNode(val);
        } else {
            ListNodeUtils.addLast(node.next, val);
        }
    }

    public static int getLast(ListNode node) {
        if (node.next == null) {
            return node.val;
        } else {
            return ListNodeUtils.getLast(node.next);
        }
    }

    public static void deleteLast(ListNode node) {
        if (node.next.next == null) {
            node.next = null;
        } else {
            ListNodeUtils.deleteLast(node.next);
        }
    }

    public static void printList(ListNode node) {
        System.out.print("[" + node.val + "]");
        if (node.next != null) {
            ListNodeUtils.printList(node.next);
        } else {
            System.out.println();
        }
    }
}
