package com.zavrab.treeproblems;

public class Main {

    public static void main(String[] args) {

        //Find min/max in Binary Tree (not a Binary SEARCH Tress)

        //e.g.
        // {15, 14, 18, 12, 16, 10, 20} => 10

        Tree tree = new Tree();
        Solution solution = new Solution();
        Node root = solution.createTree();

        System.out.println("Min is: " + solution.findMin(root));

        System.out.println("Max is: " + solution.findMax(root));
    }
}
