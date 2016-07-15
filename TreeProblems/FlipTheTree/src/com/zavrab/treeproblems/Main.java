package com.zavrab.treeproblems;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] { 18, 15, 50, 3, 16, 40, 52};
        Tree tree = new Tree();
        Node root = tree.createBalancedBst(arr);
        System.out.println("Original tree: ");
        tree.printBfs(root);

        tree.flipTree(root);
        System.out.println("\nFlipped tree: ");
        tree.printBfs(root);

    }
}
