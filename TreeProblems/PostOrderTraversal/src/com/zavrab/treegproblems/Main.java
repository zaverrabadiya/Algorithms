package com.zavrab.treegproblems;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	    Node root = createTree();

        System.out.print("Iteratively: ");
        postOrderTraversalIteratively(root);

        System.out.println("\n");
        System.out.print("Recursively: ");
        postOrderTraversalRecursively(root);
    }

    public static void postOrderTraversalIteratively(Node root) {

        if (root == null) {
            return;
        }

        Node currNode = root;
        Node lastNode = null;
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

        while (nodeStack.size() > 0) {

            if (currNode.left != null && currNode.left != lastNode && currNode.right != lastNode) {
                currNode = currNode.left;
                nodeStack.push(currNode);
            } else if (currNode.right != null && currNode.right != lastNode){
                currNode = currNode.right;
                nodeStack.push(currNode);
            } else {
                lastNode = nodeStack.pop();
                System.out.print(lastNode.val + " ");
                if (nodeStack.size() > 0) {
                    currNode = nodeStack.peek();
                }
            }
        }
    }


    public static void  postOrderTraversalRecursively(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversalIteratively(root.left);
        postOrderTraversalIteratively(root.right);

        System.out.print(root.val + " ");
    }

    private static Node createTree() {
        Tree tree = new Main().new Tree();

        Node root = tree.add(15);
        root.left = tree.add(13);
        root.right = tree.add(18);

        Node left = root.left;
        left.left = tree.add(12);
        left.right = tree.add(14);

        Node right = root.right;
        right.left = tree.add(17);
        right.right = tree.add(20);

        return root;
    }

    private class Tree {

        public Node root;

        public Node add(int value) {
            Node node = new Node(value);
            if (root == null) {
                root = node;
            }
            return new Node(value);
        }
    }

    private class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
}