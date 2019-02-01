package com.zavrab.treeproblems;

public class Main {

    public static void main(String[] args) {
        Tree tree = new Tree();
        Node root = tree.createTree();
        tree.populateSiblingPointers(root);

        tree.printBfsUsingNextPointer(root);
    }
}
