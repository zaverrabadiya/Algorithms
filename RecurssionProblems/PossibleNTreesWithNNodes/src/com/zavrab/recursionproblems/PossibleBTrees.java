package com.zavrab.recursionproblems;

/**
 * http://techieme.in/count-binary-search-trees/2/
 * http://cslibrary.stanford.edu/110/BinaryTrees.html
 * */
public class PossibleBTrees {

    public static void main(String[] args) {
        int nodes = 2;
        System.out.format("Possible Trees with %d nodes: %d \n", nodes, countTrees(nodes));

        nodes = 3;
        System.out.format("Possible Trees with %d nodes: %d \n", nodes, countTrees(nodes));

        nodes = 4;
        System.out.format("Possible Trees with %d nodes: %d \n", nodes, countTrees(nodes));

        nodes = 5;
        System.out.format("Possible Trees with %d nodes: %d \n", nodes, countTrees(nodes));
    }

    public static int countTrees(int nodes) {
        if (nodes <= 1) {
            return 1;
        }

        int left, right, sum = 0;

        for (int i = 1; i <= nodes; i++) {
            left = countTrees(i - 1); // Assign i-1 nodes to left, (i - 1) because one for root
            right = countTrees(nodes - i); // Assign nodes - i: total nodes - nodes assigned to left and root
            sum += (left * right); // (left * right) because left subtree and right subtree constitutes only 1 tree
        }

        return sum;
    }
}
