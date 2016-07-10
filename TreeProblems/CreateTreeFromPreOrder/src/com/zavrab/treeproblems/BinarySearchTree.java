package com.zavrab.treeproblems;

import java.util.Stack;

/**
 * Created by zaverR on 7/10/16.
 */
public class BinarySearchTree {
    private Node root = null;

    public void createTree(int[] pre) {
        root = new Node(pre[0]);
        Node ptr;
        Stack<Node> context = new Stack<Node>();
        context.push(root);

        for(int i = 1; i<pre.length; i++){
            ptr = null;

            while(!context.isEmpty() && (pre[i] > context.peek().val)) {
                ptr = context.pop();
            }

            if(ptr == null){
                context.peek().left = new Node(pre[i]);
                context.push(context.peek().left);
            }
            else{
                ptr.right = new Node(pre[i]);
                context.push(ptr.right);
            }
        }
    }

    public void createTreeRecursively(int[] pre) {

    }

    private void createTreeRecInternal() {

    }

    public void printInOrder() {
        printInOrder(root);
    }

    public void printPreOrder() {
        printPreOrder(root);
    }

    private void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    private void printPreOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }
}
