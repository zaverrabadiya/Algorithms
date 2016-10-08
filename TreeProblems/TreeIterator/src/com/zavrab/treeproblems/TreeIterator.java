package com.zavrab.treeproblems;

import java.util.Stack;

/**
 * Created by ZaverR on 7/10/16.
 */
public class TreeIterator {

    private Node root;
    private Stack<Node> nodes = new Stack<Node>();

    public TreeIterator(Node root) {
        this.root = root;

        populateNodes(root);
    }

    public boolean hasNext() {
        return !nodes.isEmpty();
    }

    public Node next() {
        Node node = nodes.pop();
        populateNodes(node.right);  // Push nodes from right-subtree

        return node;
    }

    private void populateNodes(Node node) {
        while (node != null) {
            nodes.push(node);
            node = node.left;
        }
    }
}
