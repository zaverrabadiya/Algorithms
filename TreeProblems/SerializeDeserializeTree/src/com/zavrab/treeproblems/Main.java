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

        final String[] parts = data.split(",");
        int i = 1;

        final Queue<Node> q = new LinkedList<Node>();
        final Node root = createNode(parts[0]);
        q.add(root);

        while (!q.isEmpty()) {
            final Node n = q.poll();

            final Node left = createNode(parts[i++]);
            final Node right = createNode(parts[i++]);

            n.left = left;
            n.right = right;

            if (left != null)
                q.add(left);

            if (right != null)
                q.add(right);
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

    private static Node createNode(String s) {
        return s.equals("#")? null : new Node(getValue(s));
    }

    private static int getValue(String s) {
        return Integer.parseInt(s);
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
