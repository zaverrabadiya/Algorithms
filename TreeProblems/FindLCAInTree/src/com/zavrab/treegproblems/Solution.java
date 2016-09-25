package com.zavrab.treegproblems;

public class Solution {

    private static boolean n1Found = false, n2Found = false;

    public static void main(String[] args) {

        // Find Lowest/Least Common Ancestor in tree
        // Given Tree root and node n1 and n2
        // e.g.
        //        15
        //   14       18
        //12    16 10    20
        //{n1:12, n2:16} => 14
        //{n1:14, n2:16} => 14
        //{n1:12, n2:20} => 15

        Node root = createTree();
        Node n1 = new Solution().new Node(16);
        Node n2 = new Solution().new Node(20);
        Node lca = findLCAInTree(root, n1, n2);
        System.out.print(lca.val);
    }

    public static Node findLCAInTree(Node root, Node n1, Node n2) {
        if (root == null || (n1Found && n2Found)) { // Checking global variables just to break the recursion when both node found
                                                    // else it would traverse though entire tree even when nodes are found. NO DIFFERENCE IN RESULT
            return null;
        }

        if (root.val == n1.val) {
            n1Found = true;
            return root;
        }

        if (root.val == n2.val) {
            n2Found = true;
            return root;
        }

        Node leftLca = findLCAInTree(root.left, n1, n2);
        Node rightLca = findLCAInTree(root.right, n1, n2);

        if (leftLca != null && rightLca != null) {
            return root;
        }

        return (leftLca != null)? leftLca : rightLca;
    }

    private static Node createTree() {
        Tree tree = new Solution().new Tree();

        Node root = tree.add(15);
        root.left = tree.add(14);
        root.right = tree.add(18);

        Node left = root.left;
        left.left = tree.add(12);
        left.right = tree.add(16);

        Node right = root.right;
        right.left = tree.add(10);
        right.right = tree.add(20);

        return root;
    }

    private class Tree {

        public Node root;

        public Node add(int value) {
            Node node = new Node(value);
            if (root == null) {
                root = node;
            }
            return new Node(value);
        }
    }

    private class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }
}
