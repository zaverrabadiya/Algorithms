package com.zavrab.treeproblems;

/**
 * Created by ZaverR on 7/15/16.
 */
public class Tree {

    // Creating BINARY TREE
    public Node createBinaryTree(){
        return createTree();
    }

    public int findUnivalTrees(Node root) {
        return countUnivalTrees(root).count;
    }

    private ReturnValue countUnivalTrees(Node root) {
        if (root == null) {
            return new ReturnValue(0, true);
        }

        ReturnValue left = countUnivalTrees(root.left);
        ReturnValue right = countUnivalTrees(root.right);

        int countSofar = left.count + right.count;
        ReturnValue returnValue = new ReturnValue(countSofar, false);

        if (left.isUnival && right.isUnival) {
            if (root.left == null && root.right == null) {
                returnValue.isUnival = true;
                returnValue.count += 1; // Include subtree formed from current root
            }
            else if (root.left != null && root.right != null && root.val == root.left.val && root.val == root.right.val) {
                returnValue.isUnival = true;
                returnValue.count += 1; // Include subtree formed from current root
            }
            else if (root.left == null && root.right != null && root.val == root.right.val) {
                returnValue.isUnival = true;
                returnValue.count += 1; // Include subtree formed from current root
            }
            else if (root.right == null && root.left != null && root.val == root.left.val) {
                returnValue.isUnival = true;
                returnValue.count += 1;  // Include subtree formed from current root
            }
        }

        return returnValue;
    }

    private class ReturnValue {
        int count;
        boolean isUnival;

        ReturnValue(int count, boolean isUnival) {
            this.count = count;
            this.isUnival = isUnival;
        }
    }

    private Node createTree() {
        Node root = new Node(5);
        root.left = new Node(1);
        root.right = new Node(5);

        root.left.left = new Node(5);
        root.left.right = new Node(5);

        root.right.left = new Node(5);
        root.right.right = new Node(5);

        return root;
    }

}
