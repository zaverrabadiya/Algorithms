package com.zavrab.treeproblems;

import java.util.HashSet;
import java.util.Stack;

/**
 * Created by ZaverR on 7/9/16.
 */
public class Tree {

    private Node root;

    public Node createBalancedBst(int[] intArr){
        //Constructs the tree from given array
        return createTree(intArr);
    }

    public Node cloneTree(Node root) {
        return cloneTreeRec(root);
    }

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    private Node cloneTreeRec(Node root) {
        if (root == null) {
            return null;
        }

        Node newRoot = new Node(root.val);

        newRoot.left = cloneTreeRec(root.left);
        newRoot.right = cloneTreeRec(root.right);

        return newRoot;
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
