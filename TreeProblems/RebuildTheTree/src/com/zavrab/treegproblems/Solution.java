package com.zavrab.treegproblems;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private static int preIdx = 0;

    public static void main(String[] args) {
        //e.g.
        // In-Order : {10, 30, 40, 50, 60, 70, 90}
        // Pre-Order : {50, 30, 10, 40, 70, 60, 90}
        // Output:
        // 50
        // 30 70
        // 10 40 60 90
        
        int[] inOrder = {10, 30, 40, 50, 60, 70, 90};
        int[] preOrder = {50, 30, 10, 40, 70, 60, 90};

        constructTree(inOrder, preOrder);
    }

    public static void constructTree(int[] inOrder, int[] preOrder){
        //Constructs the tree from given In-Order and Pre-Order arrays
        Node root = constructTree(inOrder, preOrder, 0, inOrder.length - 1);

        //Traverse BF and print node level by level
        List<Node> queue = new ArrayList<Node>();
        queue.add(root);
        queue.add(null);
        traverseBFS(queue);
    }


    private static Node constructTree(int[] inOrder, int[] preOrder, int start, int end){
        if (start > end) {
            return null;
        }

        Node node = new Solution().new Node(preOrder[preIdx++]);

        int inOrderIdx = search(inOrder, node.val, start, end);

        node.left = constructTree(inOrder, preOrder, start, inOrderIdx - 1);
        node.right = constructTree(inOrder, preOrder, inOrderIdx + 1, end);

        return node;
    }

    private static void traverseBFS(List<Node> queue) {
        if (queue == null || queue.isEmpty()) {
            return;
        }

        Node node = queue.remove(0);

        if (node == null) {
            queue.add(null);
            node = queue.remove(0);

            if (queue.isEmpty()) {
                return;
            }
            System.out.println();
        }

        System.out.print(node.val + " ");

        if (node.left != null) {
            queue.add(node.left);
        }

        if (node.right != null) {
            queue.add(node.right);
        }

        traverseBFS(queue);
    }

    private static int search(int[] inOrder, int value, int start, int end) {

        if (start > end) {
            return -1;
        }

        int mid = start + (end  - start) / 2;

        if (inOrder[mid] == value) {
            return mid;
        } else if (inOrder[mid] < value) {
            return search(inOrder, value, start, mid - 1);
        } else {
            return search(inOrder, value, mid + 1, end);
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
