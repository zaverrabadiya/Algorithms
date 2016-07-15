package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaverR on 7/13/16.
 */
public class Tree {

    private Node root;

    // Creating BINARY TREE
    public Node createBinaryTree(int[] intArr){
        //Constructs the tree from given array
        return createTree(intArr);
    }

    public Node findLargestBst(Node root) {
        List<Node> queue = new ArrayList<Node>();
        queue.add(root);
        Node largestBst = null;
        int count = 0;

        while (!queue.isEmpty()) {
            ReturnValue returnValue = findLargestBstInternal(queue.remove(0), Integer.MIN_VALUE, Integer.MAX_VALUE, queue);

            if (returnValue != null && returnValue.count > count) {
                largestBst = returnValue.child;
                count = returnValue.count;
            }
        }

        return largestBst;
    }

    public void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    private Node createTree(int[] arr) {
        root = new Node(arr[0]);

        Node node = root;
        Node left = new Node(arr[1]);
        Node right = new Node(arr[2]);
        node.left = left;
        node.right = right;

        node.left.left = new Node(arr[3]);
        node.left.right = new Node(arr[4]);

        node = node.left.right;
        left = new Node(arr[5]);
        right = new Node(arr[6]);
        node.left = left;
        node.right = right;
        node.left.left = new Node(arr[7]);
        node.left.right = new Node(arr[8]);
        node.right.left = new Node(arr[9]);

        return root;
    }

    private ReturnValue findLargestBstInternal(Node root, int min, int max, List<Node> queue) {
        if (root == null) {
            return null;
        }

        if (root.val > min && root.val < max) {
            Node leftChild = null, rightChild = null;
            int leftCount = 0, rightCount = 0;

            ReturnValue leftSubTree = findLargestBstInternal(root.left, min, root.val, queue);
            if (leftSubTree != null) {
                leftChild = leftSubTree.child;
                leftCount = leftSubTree.count;
            }

            ReturnValue rightSubTree = findLargestBstInternal(root.right, root.val, max, queue);
            if (rightSubTree != null) {
                rightChild = rightSubTree.child;
                rightCount = rightSubTree.count;
            }

            ReturnValue r = new ReturnValue();
            r.child = new Node(root.val);
            r.child.left = leftChild;
            r.child.right = rightChild;
            r.count = leftCount + rightCount + 1;

            return r;

        } else {
            queue.add(root);
            return null;
        }

    }

    private class ReturnValue {
        Node child;
        int count;
    }
}
