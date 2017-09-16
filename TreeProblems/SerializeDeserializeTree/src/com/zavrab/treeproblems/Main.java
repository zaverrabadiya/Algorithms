package com.zavrab.treeproblems;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Node root = createTree();

        String serializedTree = serializeTree(root);
        System.out.print(serializedTree);

        Node newRoot = deserializeTree(serializedTree);
    }

    public static String serializeTree(Node root) {
        if (root == null) return "";
        
        Queue<Node> q = new LinkedList<Node>();
        StringBuilder result = new StringBuilder().append(root.val);
        q.add(root);

        while (!q.isEmpty()) {
            Node n = q.remove();

            if (n.left != null) {
                q.add(n.left);
                result.append(',').append(n.left.val);
            } else {
                result.append(",#");
            }

            if (n.right != null) {
                q.add(n.right);
                result.append(',').append(n.right.val);
            } else {
                result.append(",#");
            }
        }

        return result.toString();
    }

    public static Node deserializeTree(String data) {
        if (data == null || data.length() == 0) return  null;

        String[] parts = data.split(",");
        Queue<Node> q = new LinkedList<Node>();
        int i = 1;
        Node root = new Node(getValue(parts[0]));
        q.add(root);

        while (i < parts.length - 2) {
            Node n = q.remove();

            int leftVal = getValue(parts[i]);
            if (leftVal != Integer.MIN_VALUE) {
                Node left = new Node(leftVal);
                q.add(left);
                n.left = left;
            }

            int rightVal = getValue(parts[++i]);
            if (rightVal != Integer.MIN_VALUE) {
                Node right = new Node(rightVal);
                q.add(right);
                n.right = right;
            }

            i++;
        }

        return root;
    }
    // UTILS Methods
    private static Node createTree() {
        Node root = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);

        root.left = left;
        root.right = right;

        left = new Node(4);
        right = new Node(5);

        root.right.left = left;
        root.right.right = right;

        return  root;
    }

    private static int getValue(String s) {
        return !s.equals("#")? Integer.parseInt(s) : Integer.MIN_VALUE;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        public Node(int v) {
            val = v;
        }
    }
}
