package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
	    Solution solution = new Solution();
        //Create tree k-ary tree
        Node root = solution.createTree();

        // Result => true
        System.out.println("Result: " + solution.isUnival(root, root.val));

        // Result => false
        root.childrens.get(2).val = 2;
        System.out.println("Result: " + solution.isUnival(root, root.val));
    }

    public boolean isUnival(Node root, int val) {
        if (root == null) {
            return true;
        }

        if (root.val != val) {
            return false;
        }

        for (Node node : root.childrens) {
            if (!isUnival(node, val)){
                return false;
            }
        }
        return true;
    }

    private  Node createTree() {
        Node root  = new Node(5);
        for (int c = 0; c < 5; c++) {
            root.childrens.add(new Node(5));
        }
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
