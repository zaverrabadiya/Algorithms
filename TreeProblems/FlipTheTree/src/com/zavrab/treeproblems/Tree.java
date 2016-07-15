package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaverR on 7/13/16.
 */
public class Tree {

    private Node root;

    public Node createBalancedBst(int[] intArr){
        //Constructs the tree from given array
        return createTree(intArr);
    }

    public void flipTree(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        flipTree(root.left);
        flipTree(root.right);
    }

    public void printBfs(Node root) {
        Node node = root;
        List<Node> queue = new ArrayList<Node>();
        queue.add(node);
        queue.add(null);

        while (!queue.isEmpty()) {
            node = queue.remove(0);

            if (node == null) {
                queue.add(null);
                node = queue.remove(0);
                System.out.println();

                if (queue.isEmpty()) {
                    return;
                }
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

    private Node createTree(int[] arr) {
        root = new Node(arr[0]);

        for (int i = 1; i < arr.length; i++) {
           root = insert(arr[i], root);
        }

        return root;
    }

    private Node insert(int val, Node root) {

        if (root == null) {
            return new Node(val);
        } else {

            if (val < root.val) {
                root.left = insert(val, root.left);
            } else {
                root.right = insert(val, root.right);
            }
        }

        return root;
    }
}
