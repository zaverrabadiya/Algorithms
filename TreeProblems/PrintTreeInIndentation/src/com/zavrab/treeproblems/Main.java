package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

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

        String[] a = new String[] {"1", "-2", "-3", "--5", "--6", "---7", "-4"};
        //Node newTree = buildTree(a);
        Node newTree = buildTree(a);
        Node r = newTree;
    }

    // Print tree with indentation
    public static void printTreeInIndentation(Node root) {
        printTreeRecHelper(root, 0);
    }

    private static void printTreeRecHelper(Node curr, int tabs) {
        if (curr == null) {
            return;
        }

        // Print number of tabs
        for (int t = 1; t <= tabs; t++) {
            System.out.print("-");
        }

        // Print node value
        System.out.println(curr.val);

        // Recurse on child nodes
        for (Node child : curr.childs) {
            printTreeRecHelper(child, tabs+1);
        }
    }

    // Build tree from given array of string: where string has tab(s) and value
    static int j = 1;
    public static Node buildTree(String[] strs) {
        if (strs == null || strs.length == 0) {
            return null;
        }

        Node root = new Node(getValue(strs[0]));

        buildTreeRec(strs, 0, root);
        return root;
    }

    // The idea is to check if node at i is parent of current node j, if so then set i to j and start searching for node ith childrens
    private static void buildTreeRec(String[] strs, int i, Node root) {
        while (j < strs.length && getNumberOfTabs(strs[i]) == getNumberOfTabs(strs[j]) - 1) {
            Node child = new Node(getValue(strs[j]));
            root.childs.add(child);

            int start = j;
            j++;

            buildTreeRec(strs, start, child);
        }
    }

    // UTIL methods
    private static int getValue(String s) {
        StringBuilder value = new StringBuilder();

        for (int i = s.length()-1; i >= 0; i--) {
            if(isDigit(s.charAt(i))) {
                value.append(s.charAt(i));
            } else {
                break;
            }
        }

        return Integer.parseInt(value.reverse().toString());
    }

    private static int getNumberOfTabs(String s) {
        int tabs = 0, i = 0;

        while (i < s.length() && s.charAt(i) == '-') {
            tabs++;
            i++;
        }

        return tabs;
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
