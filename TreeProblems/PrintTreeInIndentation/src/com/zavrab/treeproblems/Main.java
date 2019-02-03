package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Part-1: Print tree with indentation; where number of tab represents level of node in tree
 * e.g.
 *          1
 *        / | \
 *       2  3  4
 *         / \
 *        5  6
 *          /
 *         7
 * Output:
 * 1
 * -2
 * -3
 * --5
 * --6
 * ---7
 * -4
 *
 * Its PRE-ORDER printing, where you have to pass the tabs counter along with recursive call
 *
 *
 * Part-2: Build tree from given array of string; which is pre-order with number of tabs as prefix
 * its reverse of part-1
 *
 * */
public class Main {

    public static void main(String[] args) {
	    Node root = createTree();
        printTreeInIndentation(root);

        String[] a = new String[] {"-1", "--2", "--3", "---5", "---6", "----7", "--4"};
        Node newTree = buildTree(a);
        Node r = newTree;
    }

    // Print tree with indentation
    public static void printTreeInIndentation(Node root) {
        printTreeRecHelper(root, "-");
    }

    private static void printTreeRecHelper(Node curr, String tabs) {
        if (curr == null) {
            return;
        }

        // Print node value
        System.out.println(tabs + curr.val);

        // Recurse on child nodes
        for (Node child : curr.childs) {
            printTreeRecHelper(child, tabs + "-");
        }
    }

    // Build tree from given array of string: where string has tab(s) and value
    public static Node buildTree(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        // Add each node into this stack
        final Stack<NodeWrapper> stack = new Stack<>();
        final Node root  = new Node(getValue(strs[0]));
        stack.push(new NodeWrapper(root, 1));

        for (int i = 1; i < strs.length; i++) {
            final int tabs = getNumberOfTabs(strs[i]);

            // Remove node(s) till we find parent of the node we are going to create
            while (!stack.isEmpty() && stack.peek().tabs >= tabs) {
                stack.pop();
            }

            final Node child = new Node(getValue(strs[i]));
            stack.peek().node.childs.add(child);

            final NodeWrapper nodeWrapper = new NodeWrapper(child, tabs);
            stack.push(nodeWrapper);
        }

        return root;
    }

    private static class NodeWrapper {
        final Node node;
        final int tabs;

        NodeWrapper(final Node node, final int tabs) {
            this.node = node;
            this.tabs = tabs;
        }
    }

    // UTIL methods
    private static int getValue(String s) {
        final StringBuilder value = new StringBuilder();
        int i = s.length() - 1;

        while (i >= 0 && isDigit(s.charAt(i))) {
            value.append(s.charAt(i--));
        }

        return Integer.parseInt(value.reverse().toString());
    }

    private static int getNumberOfTabs(String s) {
        int i = 0;

        while (i < s.length() && s.charAt(i++) == '-');

        return i + 1;
    }

    private static boolean isDigit(char c) {
        int ascii = c - '0';
        return ascii >= 0 && ascii <= 9;
    }

    public static Node createTree() {
        Node root = new Node(1);

        root.childs.add(new Node(2));
        root.childs.add(new Node(3));
        root.childs.add(new Node(4));

        Node secondChild = root.childs.get(1);
        secondChild.childs.add(new Node(5));
        secondChild.childs.add(new Node(6));

        secondChild.childs.get(1).childs.add(new Node(7));

        return root;
    }

    private static class Node {
        int val;
        List<Node> childs;

        Node(int val) {
            this.val = val;
            childs = new ArrayList<Node>();
        }
    }
}
