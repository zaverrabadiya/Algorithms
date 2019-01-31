package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        // e.g.
        // {10, 30, 40, 50, 60, 70, 90}
        // Output:
        // 50
        // 30 70
        // 10 40 60 90

        //int[] input = {10, 30, 40, 50, 60, 70, 90};
        int[] input = {8, 10, 12, 15, 16, 20, 25};
        createBalancedBST(input);
    }

    public static void createBalancedBST(int[] intArr){
        //Constructs the tree from given sorted array
        Node root = createBalancedBST(intArr, 0, intArr.length - 1);

        //Traverse BF and print node level by level
        List<Node> queue = new ArrayList<Node>();
        queue.add(root);
        queue.add(null);
        traverseBFS(queue);
    }


    private static Node createBalancedBST(int[] intArr, int start, int end){
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) /2;
        Node node = new Node(intArr[mid]);

        node.left = createBalancedBST(intArr, start, mid - 1);
        node.right = createBalancedBST(intArr, mid + 1, end);

        return node;
    }

    private static void traverseBFS(List<Node> queue) {

        while (queue != null && queue.size() > 1) {

            Node node = queue.remove(0);

            if (node == null) {
                queue.add(null);
                node = queue.remove(0);

                System.out.println();
            }

            System.out.print(node.val + " ");

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
}
