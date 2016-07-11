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

    public void printList(Node head) {
        Node curr = head;
        System.out.print(curr.val + " ");
        curr = curr.right;

        while (curr != head) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
    //http://cslibrary.stanford.edu/109/TreeListRecursion.html
    public Node convertToDoublyLinkList(Node node) {
        if (node == null) {
            return null;
        }

        Node aList = convertToDoublyLinkList(node.left);
        Node bList = convertToDoublyLinkList(node.right);


        node.left = node;
        node.right = node;

        aList = append(aList, node);
        aList = append(aList, bList);

        return aList;
    }

    private Node append(Node a, Node b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }

        Node aLast = a.left;
        Node bLast = b.left;

        join(aLast, b);
        join(bLast, a);

        return a;
    }

    private void join(Node a, Node b) {
        a.right = b;
        b.left = a;
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

    // Brute-force way
    public Node convertToDoublyLl(Node node) {
        Stack<Node> nodes = new Stack<Node>();
        Node head = null, last = null;
        HashSet<Node> visited = new HashSet<Node>();
        nodes.push(node);

        while (!nodes.isEmpty() || node != null) {
            if (node != null) {
                if (!visited.contains(node)) {
                    nodes.push(node);
                    visited.add(node);
                    node = node.left;
                } else {
                    node = null;
                }
            } else {
                node = nodes.pop();
                if (last != null) {
                    last.right = node;
                    node.left = last;
                }
                last = node;

                if (head == null) {
                    head = last;
                }

                node = node.right;
            }
        }

        return  head;
    }
}
