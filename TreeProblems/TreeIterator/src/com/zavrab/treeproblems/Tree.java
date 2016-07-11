package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaverR on 7/9/16.
 */
public class Tree {

    private Node root;

    public Node createBalancedBst(int[] intArr){
        //Constructs the tree from given array
        return createTree(intArr);
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
