package com.zavrab.treeproblems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZaverR on 7/12/16.
 */
public class Tree {

    public Node createTree() {
        /*
         *         1
         *        / \
         *       2   3
         *      / \   \
         *     4   5   6
         *    /         \
         *   7           8
         *    \
         *     9
         *
         * */

        final Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);

        root.left.left.left.right = new Node(9);

        return root;
    }

    public void populateSiblingPointers(final Node root) {
        final List<Node> queue = new ArrayList<>();
        queue.add(root);
        queue.add(null);

        while (queue.size() > 1) {
            final Node n = queue.remove(0);

            if (n == null) {
                queue.add(null);
                continue;
            }

            n.nextRight = queue.get(0);

            if (n.left != null) {
                queue.add(n.left);
            }

            if (n.right != null) {
                queue.add(n.right);
            }
        }
    }

    public void printBfsUsingNextPointer(final Node root) {
        Node curr = root;
        Node first = curr;

        while (curr != null) {
            System.out.print(curr.val + " ");

            if (curr.nextRight != null) {
                curr = curr.nextRight;
            } else {
                System.out.println();
                curr = first.left != null ? first.left : first.right;
                first = curr;
            }
        }
    }
}
