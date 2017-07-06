package com.odmytrenko.linkedlist;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public void addLast(int val) {
        if (this.next == null) {
            this.next = new ListNode(val);
        } else {
            this.next.addLast(val);
        }
    }

    public int getLast() {
        if (this.next == null) {
            return this.val;
        } else {
            return this.next.getLast();
        }
    }

    public void deleteLast() {
        if (this.next.next == null) {
            this.next = null;
        } else {
            this.next.deleteLast();
        }
    }

    public void printList() {
        System.out.print("[" + val + "]");
        if (next != null) {
            this.next.printList();
        } else {
            System.out.println();
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = null;
        boolean addDigit = false;
        while (true) {
            int element = l1.getLast() + l2.getLast();
            if (element % 10 == element) {
                if (addDigit) element++;
                if (resultNode == null) {
                    resultNode = new ListNode(element);
                } else {
                    resultNode.addLast(element);
                }
                if (l1.next == null || l2.next == null) break;
                l1.deleteLast();
                l2.deleteLast();
            } else {
                if (addDigit) element++;
                if (resultNode == null) {
                    resultNode = new ListNode(element % 10);
                } else {
                    resultNode.addLast(element % 10);
                }
                addDigit = true;
                if (l1.next == null || l2.next == null) break;
                l1.deleteLast();
                l2.deleteLast();
            }
        }
        while (l1.next != null) {
            l1.deleteLast();
            resultNode.addLast(l1.getLast());
        }
        while (l2.next != null) {
            l2.deleteLast();
            resultNode.addLast(l2.getLast());
        }
        return resultNode;
    }
}

