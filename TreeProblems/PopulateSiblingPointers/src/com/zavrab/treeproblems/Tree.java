package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

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
//        joinSibling(root, null);
        joinSiblingIteratively(root);
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

    private void joinSiblingIteratively(final Node root) {
        final List<Node> queue = new ArrayList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {
            final Node n = queue.remove(0);

            if (n == null) {
                queue.add(null);
                continue;
            }

            n.nextRight = queue.get(0);

            if (n.left != null) {
                queue.add(n.left);
            }

            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    private void joinSibling(Node root, Node next) {
        if (root == null) {
            return;
        }

        root.nextRight = next;

        next = root.right;
        if (root.right == null && root.nextRight != null) {
            if (root.nextRight.left != null) {
                next = root.nextRight.left;
            } else {
                next = root.nextRight.right;
            }
        }

        // Recurse with next
        joinSibling(root.left, next);

        next = null;
        if (root.nextRight != null) {
            if (root.nextRight.left != null) {
                next = root.nextRight.left;
            } else {
                next = root.nextRight.right;
            }
        }

        // Recurse with next
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
