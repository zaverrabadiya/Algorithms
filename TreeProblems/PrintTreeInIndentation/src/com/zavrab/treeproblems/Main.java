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
 * Its pre-order printing, where you have to pass the tabs counter along with recursive call
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
        Node newTree = buildTree(a);
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

        System.out.println(curr.val);

        for (Node child : curr.childs) {
            printTreeRecHelper(child, tabs+1);
        }
    }

    // Build tree from given array of string: where string has tab(s) and value
    public static Node buildTree(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        // Create root from first string element
        int i = 0;
        NodeWrapper rootWrapper = new NodeWrapper(a[i++]);

        Stack<NodeWrapper> previousNodes = new Stack<NodeWrapper>();
        previousNodes.push(rootWrapper);

        while (i < a.length) {
            // Create new node from ith string in array
            NodeWrapper nodeWrapper = new NodeWrapper(a[i++]);

            // Remove the nodes till we find the node that has exactly 1 tab less than the newly create node
            // 1 tab less meaning parent node has 1 tab less since it 1 level up than the child nodes
            while (previousNodes.peek().tabs != nodeWrapper.tabs - 1) {
                previousNodes.pop();
            }

            // Get the current node who is parent node of newly created node
            NodeWrapper currWrapper = previousNodes.peek();

            // Add new node to the parent node
            currWrapper.node.childs.add(nodeWrapper.node);
            previousNodes.push(nodeWrapper);
        }

        return rootWrapper.node;
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

    private static class NodeWrapper {
        Node node;
        int tabs;

        NodeWrapper(String s) {
            node = new Node(getValue(s));
            tabs = getNumberOfTabs(s);
        }

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
    }
}
