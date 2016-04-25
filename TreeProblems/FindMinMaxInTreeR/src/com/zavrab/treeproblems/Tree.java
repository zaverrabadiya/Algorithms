package com.zavrab.treeproblems;

/**
 * Created by zavrab on 4/23/16.
 */
public class Tree {

    public Node root;

    public Node add(int value) {
        Node node = new Node(value);
        if (root == null) {
            root = node;
        }
        return new Node(value);
    }
}
