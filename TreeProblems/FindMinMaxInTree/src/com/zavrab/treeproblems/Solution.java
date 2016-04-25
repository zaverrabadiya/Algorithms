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

        int min = root.val;
        if (leftMin < min ) {
            min = leftMin;
        }
        if (rightMin < min) {
            min = rightMin;
        }
        return min;
    }

    public int findMax(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        int max = root.val;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);

        if (leftMax > max) {
            max = leftMax;
        }

        if (rightMax > max) {
            max = rightMax;
        }

        return max;
    }

    public boolean isBst(Node root, int low, int high) {
        if (root == null) {
            return true;
        }

        int min = low, max  = high;
        if (root.left != null) {
            min = Math.min(root.left.val, root.val);
            max = Math.max(root.left.val, root.val);
        }

        if (root.right != null) {
            min = Math.min(root.right.val, root.val);
            max = Math.max(root.left.val, root.val);
        }

        if (low < root.val && high > root.val) {

            return isBst(root.left, low, )
        }
    }
}
