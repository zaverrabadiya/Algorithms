package com.zavrab.linkedlist;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Node head = createLinkedList();
        partitionLl(head, 2);
    }

    public static Node partitionLl(Node head, int x) {
        Node newHead = new Node(-1);
        Node lowNode, curr = head;
        newHead.next = head;
        lowNode = newHead;

        while (curr != null) {

            if (curr.val < x) {
                Node temp = lowNode.next;
                lowNode.next = curr;

                if (curr.next != null){
                    lowNode = lowNode.next;
                }
                lowNode.next = temp;
            }

            curr = curr.next;
        }

        return newHead.next;
    }


    private static Node createLinkedList() {
        Node head = new Node(2);
        head.next = new Node(1);

        return head;
    }

    private static class Node {
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }
}
