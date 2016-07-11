package com.zavrab.treeproblems;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{39, 18, 80, 4, 21, 50, 82, 3, 5, 41, 52};
        Tree tree = new Tree();
        Node root = tree.createBalancedBst(arr);
        TreeIterator iterator = new TreeIterator(root);
        while (iterator.hasNext()) {
            System.out.print(iterator.next().val + " ");
        }
    }
}
