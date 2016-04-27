package com.zavrab.treegproblems;

public class Solution {

    public static void main(String[] args) {
	    Node root = createTree();

        printAllPathsInTree(root);
    }

    public static void printAllPathsInTree(Node root) {
        printAllPathsInTree(root, "");
    }

    private static void printAllPathsInTree(Node root, String path) {
        if (root == null) {
            System.out.println(path);
            return;
        }

        printAllPathsInTree(root.left, path + " " + root.val);

        if (root.right != null) {
            printAllPathsInTree(root.right, path + " " + root.val);
        }
    }

    private static Node createTree() {
        Tree tree = new Solution().new Tree();

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
