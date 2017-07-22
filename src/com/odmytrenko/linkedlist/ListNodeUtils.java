package com.odmytrenko.linkedlist;

public class ListNodeUtils {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        boolean addDigit = false;
        while (true) {
            int element = ListNodeUtils.getLast(l1) + ListNodeUtils.getLast(l2);
            if (element % 10 == element) {
                if (addDigit) element++;
                if (resultNode == null) {
                    resultNode = new ListNode(element);
                } else {
                    ListNodeUtils.addLast(resultNode, element);
                }
                if (l1.next == null || l2.next == null) break;
                ListNodeUtils.deleteLast(l1);
                ListNodeUtils.deleteLast(l2);
            } else {
                if (addDigit) element++;
                if (resultNode == null) {
                    resultNode = new ListNode(element % 10);
                } else {
                    ListNodeUtils.addLast(resultNode, element % 10);
                }
                addDigit = true;
                if (l1.next == null || l2.next == null) break;
                ListNodeUtils.deleteLast(l1);
                ListNodeUtils.deleteLast(l2);
            }
        }
        while (l1.next != null) {
            ListNodeUtils.deleteLast(l1);
            ListNodeUtils.addLast(resultNode, ListNodeUtils.getLast(l1));
        }
        while (l2.next != null) {
            ListNodeUtils.deleteLast(l2);
            ListNodeUtils.addLast(resultNode, ListNodeUtils.getLast(l2));
        }
        return resultNode;
    }

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
