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
            sum += (left * right); // (left * right) because left subtree and right subtree constitutes only 1 tree.
                                    // e.g. left-subtree has 2 nodes and right-subtree has 3- so one on left treats as root and its child-2nd node on left and right-subtree with 3 nodes, thats one combination. then child-2nd node on right with right-subtree with 3 nodes, thats another combination... so each node on left-subtree be on left or right. so generating all possible combinations with right-subtree
        }

        return sum;
    }

    //DP SOLUTION
    public static int countTreesDp(int n) {
        int[] cache = new int[n+1];
        cache[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                int left = cache[j - 1];
                int right = cache[i - j];
                cache[i] += left * right;
            }
        }

        return cache[n];
    }
}
