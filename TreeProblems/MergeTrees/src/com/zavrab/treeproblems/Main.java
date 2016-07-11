package com.zavrab.treeproblems;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arr1 = new int[] {39, 4, 80, 50, 18, 6, 5, 13, 32, 28, 23, 22, 25, 41, 66, 53, 52, 58, 84, 82};
        int[] arr2 = new int[] {27, 69, 18, 12, 16, 66, 53, 30, 27, 37, 62, 58, 95, 73};
        Tree tree1 = new Tree();
        tree1.createBalancedBst(arr1);
        Node head1 = tree1.flatten();

        Tree tree2 = new Tree();
        tree2.createBalancedBst(arr2);
        Node head2 = tree2.flatten();

        Node root = Tree.merge(head1, head2);

        Tree.printInOrder(root);
        root = Tree.balance(root);
        Tree.printBst(root);
    }
}
