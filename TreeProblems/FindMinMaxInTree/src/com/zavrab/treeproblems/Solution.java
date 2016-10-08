package com.zavrab.treeproblems;

public class Solution {

    public Node createTree() {
        Tree tree = new Tree();

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

    public int findMin(Node root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }

        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);

        return Math.min(root.val, Math.min(leftMin, rightMin));
    }

    public int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        return Math.max(root.val, Math.max(leftMax, rightMax));
    }
}
