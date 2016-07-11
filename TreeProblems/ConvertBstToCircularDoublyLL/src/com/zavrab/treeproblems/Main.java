package com.zavrab.treeproblems;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] { 39, 18, 80, 4, 21, 50, 82, 3, 5, 41, 52 };
        Tree tree = new Tree();
        Node root = tree.createBalancedBst(arr);
//        Node head = tree.convertToDoublyLl(root);
        Node head = tree.convertToDoublyLinkList(root);
        tree.printList(head);
    }
}
