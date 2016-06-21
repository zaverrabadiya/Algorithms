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
        else {
            int left, right, sum = 0;

            for (int i = 1; i <= nodes; i++) {
                left = countTrees(i - 1);
                right = countTrees(nodes - i);
                sum += (left * right);
            }

            return sum;
        }
    }
}
