package com.zavrab.treeproblems;

//http://articles.leetcode.com/largest-binary-search-tree-bst-in_22

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] { 15, 10, 20, 5, 7, 2, 5, 0, 8, 3};
        Tree tree = new Tree();
        Node root = tree.createBinaryTree(arr);
        System.out.println("Original tree: ");
        tree.printInOrder(root);

        Node largetBst = tree.findLargestBst(root);

        System.out.println("\n\nLargest BST: ");
        tree.printInOrder(largetBst);
    }
}
