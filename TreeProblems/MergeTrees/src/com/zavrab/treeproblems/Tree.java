package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaverR on 7/9/16.
 */
public class Tree {

    private Node root;
    private static Node head = null;

    public void createBalancedBst(int[] intArr){
        //Constructs the tree from given sorted array
        createTree(intArr);
    }

    public Node flatten() {
        FlattNode result = new FlattNode();
        flatten(root, result);

        return result.root;
    }

    public static Node merge(Node head1, Node head2) {
        Node last, newRoot;

        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        } else if (head1.val < head2.val) {
            newRoot = head1;
            head1 = head1.right;
        } else {
            newRoot = head2;
            head2 = head2.right;
        }

        last = newRoot;

        while (head1 != null || head2 != null) {
            if (head1 != null && head2 == null) {
                last.right = head1;
                head1 = head1.right;
            } else if (head1 == null) {
                last.right = head2;
                head2 = head2.right;
            } else if (head1.val < head2.val) {
                last.right = head1;
                last = head1;
                head1 = head1.right;
            } else {
                last.right = head2;
                last = head2;
                head2 = head2.right;
            }
        }

        return newRoot;
    }

    public static Node balance(Node root) {
        Node curr = root;
        int size = 0;

        while (curr != null) {
            curr = curr.right;
            size++;
        }

        head = root;
        return balance(size, head);
    }

    public static void printBst(Node root) {
        List<Node> queue = new ArrayList<Node>();
        Node curr = root;
        queue.add(curr);
        queue.add(null);

        while (queue.size() > 0 && curr != null) {
            curr = queue.remove(0);

            if (curr == null) {
                queue.add(null);
                curr = queue.remove(0);

                if (queue.isEmpty()) {
                    return;
                }

                System.out.println();
            }

            System.out.print(curr.val + " ");

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }

        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    private void createTree(int[] pre) {
        root = new Node(pre[0]);

        for (int i = 1; i < pre.length; i++) {
           root = insert(pre[i], root);
        }
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

    private void insertIteratively(int val) {
        Node curr = root;

        while (true) {
            if (val < curr.val) {
                if (curr.left == null) {
                    curr.left = new Node(val);
                    return;
                } else {
                    curr = curr.left;
                }
            } else {
                if (curr.right == null) {
                    curr.right = new Node(val);
                    return;
                } else {
                    curr = curr.right;
                }
            }
        }
    }


    private void flatten(Node curr, FlattNode fNode) {
        if (curr == null) {
            return;
        }

        flatten(curr.left, fNode);

        // Root can be null only once, when we went all the way down to left node
        if (fNode.root == null) {
            fNode.root = curr;
        }

        if (fNode.prev != null) {
            fNode.prev.right = curr;
        }

        fNode.prev = curr;
        curr.left = null;

        flatten(curr.right, fNode);
    }

    private static Node balance(int size) {
        if (size == 0) {
            return null;
        }

        Node node;
        if (size == 1) {
            node = head;
            head = head.right;
            node.right = null;
            return node;
        }

        int leftSize = size / 2;
        int rightSize = size - leftSize - 1;

        Node leftRoot = balance(leftSize);

        node = head;
        head = head.right;
        node.left = leftRoot;

        node.right = balance(rightSize);

        return node;
    }

    /****************************** PRIVATE CLASSES *************************/
    private static class FlattNode {
        Node prev;
        Node root;
    }
}
