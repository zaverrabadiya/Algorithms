package com.zavrab.treeproblems;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] { 39, 18, 80, 4, 21, 50, 82, 3, 5, 41, 52 };
        Tree tree = new Tree();
        Node root = tree.createBalancedBst(arr);

        System.out.println("Print original tree InOrder: ");
        tree.printInOrder(root);

        Node clonedRoot = tree.cloneTree(root);
        System.out.println("\n");
        System.out.println("Print cloned tree InOrder: ");
        tree.printInOrder(clonedRoot);
    }
}
