package com.zavrab.treeproblems;

/**
 * Created by ZaverR on 7/12/16.
 */
public class Tree {

    private Node root;

    public Node createBalancedBst(int[] intArr){
        //Constructs the tree from given array
        return createTree(intArr);
    }

    public void populateSiblingPointers(Node root) {
        joinSibling(root, null);
    }

    public void printBfsUsingNextPointer(Node root) {
        Node curr = root;
        Node leftMost = curr;

        while (curr != null) {
            System.out.print(curr.val + " ");

            if (curr.nextRight != null) {
                curr = curr.nextRight;
            } else {
                System.out.println();
                curr = leftMost.left;
                leftMost = leftMost.left;
            }
        }
    }

    private void joinSibling(Node root, Node next) {
        if (root == null) {
            return;
        }

        root.nextRight = next;

        joinSibling(root.left, root.right);

        next = (root.nextRight != null) ? root.nextRight.left : null;
        joinSibling(root.right, next);
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
