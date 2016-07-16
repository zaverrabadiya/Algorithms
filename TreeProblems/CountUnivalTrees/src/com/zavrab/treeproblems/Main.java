package com.zavrab.treeproblems;

//https://crazycoderzz.wordpress.com/count-the-number-of-unival-subtrees-in-a-binary-tree/

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.createBinaryTree();

        int totalUnivalTrees = tree.findUnivalTrees(root);

        System.out.println("Number of unival trees: " + totalUnivalTrees);
    }
}
