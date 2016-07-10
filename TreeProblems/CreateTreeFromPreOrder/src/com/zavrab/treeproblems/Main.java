package com.zavrab.treeproblems;

public class Main {

    public static void main(String[] args) {
	    int[] preOrder = new int[] {39, 18, 4, 3, 5, 21, 19, 32, 80, 50, 41, 52, 82};

        BinarySearchTree tree = new BinarySearchTree();
        tree.createTree(preOrder);
        System.out.println("In-order print: ");
        tree.printInOrder();

        System.out.println("\n");
        System.out.println("Pre-order print: ");
        tree.printPreOrder();
    }
}
