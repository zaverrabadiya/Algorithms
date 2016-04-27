package com.zavrab.treegproblems;

public class Main {

    public static void main(String[] args) {
        Node root = createTree();

        System.out.println("Is BST: " + isBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    public static boolean isBst(Node root, int low, int high) {
        if (root == null) {
            return true;
        }

        if (low < root.val && root.val < high) {
            return isBst(root.left, low, root.val) &&
                    isBst(root.right, root.val, high);
        } else {
            return false;
        }
    }

    private static Node createTree() {
        Tree tree = new Main().new Tree();

        Node root = tree.add(15);
        root.left = tree.add(14);
        root.right = tree.add(18);

        Node left = root.left;
        left.left = tree.add(12);
        left.right = tree.add(16);

        Node right = root.right;
        right.left = tree.add(10);
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
