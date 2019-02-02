package com.zavrab.treeproblems;

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

    // ITERATIVE Solution
    public static void postOrderTraversalIteratively(Node root) {

        if (root == null) {
            return;
        }

        Node lastNode = null;
        Stack<Node> nodeStack = new Stack<Node>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty()) {
            final Node currNode = nodeStack.peek();

            if ((currNode.left == null && currNode.right == null) ||
                    currNode.left == lastNode || currNode.right == lastNode) {

                System.out.print(currNode.val + " ");

                lastNode = nodeStack.pop();
            } else {
                if (currNode.right != null){
                    nodeStack.push(currNode.right);
                }

                if (currNode.left != null){
                    nodeStack.push(currNode.left);
                }
            }
        }
    }


    // RECURSIVE Solution
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
