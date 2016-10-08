package com.zavrab.treeproblems;

import java.util.Stack;

public class Solution {
    private static int k;

    public static void main(String[] args) {
	    Node root = createTree();
        k = 2;
       // printTopKSmallestElements(root);
        printTopKSmallestElementsIteratively(root, 2);
    }

    // RECURSIVELY
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

    // ITERATIVELY
    public static void printTopKSmallestElementsIteratively(Node root, int k) {
        if (k == 0) {
            return;
        }

        Stack<Node> visitedNodes = new Stack<Node>();
        Node curr = root;

        while ((!visitedNodes.isEmpty() || curr != null) && k > 0) {
            if (curr != null) {
                visitedNodes.push(curr);
                curr = curr.left;
            } else {
                curr = visitedNodes.pop();
                System.out.print(curr.val + " ");

                k--;
                curr = curr.right;
            }
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
