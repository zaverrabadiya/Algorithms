package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        Node root = createTree();
        int max = height(root);
        System.out.print("Max height: " + max);
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int max = 0, height;

        for (Node node: root.childrens) {
            height = height(node);
            max = Math.max(max, height);
        }

        return max + 1;
    }

    private static Node createTree() {
        Node root = new Solution(). new Node(15);

        root.childrens.add(new Solution(). new Node(10));
        root.childrens.add(new Solution(). new Node(20));

        root.childrens.get(0).childrens.add(new Solution(). new Node(8));
        return root;
    }

    private class Node {
        int val;
        List<Node> childrens = new ArrayList<Node>();

        Node(int val) {
            this.val = val;
        }
    }
}
