package com.zavrab.treeproblems;

public class Solution {
    private static int k;

    public static void main(String[] args) {
	    Node root = createTree();
        k = 2;
        printTopKSmallestElements(root);
    }

    public static void printTopKSmallestElements(Node root) {
        if (k == 0 || root == null) {
            return;
        }



            printTopKSmallestElements(root.left);

            if (k > 0) {
                System.out.println(root.val);
                --k;

                printTopKSmallestElements(root.right);
            }

    }

    private static Node createTree() {
        Node root = new Solution(). new Node(15);

        Node left = new Solution(). new Node(10);
        Node right = new Solution(). new Node(20);

        root.left = left;
        root.right = right;

        left.left = new Solution(). new Node(8);
        left.right = new Solution(). new Node(12);

        right.left = new Solution(). new Node(16);
        right.right = new Solution(). new Node(25);

        return root;
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
