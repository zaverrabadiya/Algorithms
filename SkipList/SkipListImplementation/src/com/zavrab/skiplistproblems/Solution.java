package com.zavrab.skiplistproblems;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    public static void main(String[] args) {
	    int[] intArr = {2, 7, 5, 1, 8, 4, 9, 3, 10};
        Node head = createSkipList(intArr);

        Node result = search(head, 6);

        head = insert(head, 6);
    }


    public static Node createSkipList(int[] intArr) {
        Arrays.sort(intArr);
        Node head = createBottomList(intArr);
        head = createKLists(head);
        return head;
    }

    public static Node search(Node head, int value) {
        Node curr = head;
        if (curr == null || value <= curr.value) {
            return head;
        }

        while (curr != null) {
            if (curr.value == value) {
                return curr;
            }

            if (value > curr.value) {
                if (curr.right != null) {
                    curr = curr.right;
                    continue;
                } else {
                    return curr;
                }
            }

            if (value < curr.value && curr.down == null) {
                return curr;
            }
            curr = curr.left.down;
        }
        return null;
    }

    public static Node insert(Node head, int value) {

        Node neighborNode = search(head, value);

        if (neighborNode == null) {
            head.value = value;
            return head;
        }

        Node newNode = insertInBottomList(neighborNode, value);

        if (value < head.value) {
            head = insertNewHead(newNode.right, newNode);
        } else {
            insertAtLevelUp(newNode, value);
        }
        return head;
    }

    public static Node delete(Node head, int value) {
        Node nodeToDelete = search(head, value);

        if (nodeToDelete.value == value) {
            Node curr = nodeToDelete;
            while (curr != null) {

            }
        }
        return head;
    }

    private static Node createKLists(Node head) {

        while (head.right.right != null) {
            Node dummyHead = new Solution().new Node(head.value);
            dummyHead.down = head;
            head.up = dummyHead;
            Node curr = head.right, currTopList = dummyHead;

            while (curr != null) {
                if (curr.right != null) {
                    curr = curr.right;
                }

                Node temp = new Solution().new Node(curr.value);
                temp.down = curr;
                temp.left = currTopList;
                curr.up = temp;
                currTopList.right = temp;
                currTopList = temp;

                curr = curr.right;
            }
            head = dummyHead;
        }
        return head;
    }

    private static Node insertInBottomList(Node neighborNode, int value) {
        Node newNode = new Solution().new Node(value);
        Node currNode = neighborNode;
        while (currNode.down != null) {
            currNode = currNode.down;
        }

        if (newNode.value < currNode.value) {
            newNode.left = currNode.left;
            newNode.right = currNode;
            if (currNode.left != null) {
                currNode.left.right = newNode;
            }
            currNode.left = newNode;
        } else {
            newNode.right = currNode.right;
            newNode.left = currNode;
            if (currNode.right != null) {
                currNode.right.left = newNode;
            }
            currNode.right = newNode;
        }
        return newNode;
    }

    private static Node insertNewHead(Node head, Node newHead) {
        Node curr = head;
        while (curr != null) {
            Node newNode = new Solution().new Node(newHead.value);
            newNode.right = curr;
            newNode.down = newHead;
            curr.left = newNode;
            newHead.up = newNode;
            curr = curr.up;
            newHead = newNode;
        }
        return newHead;
    }

    private static void insertAtLevelUp(Node bottomNode, int value) {
        Node towerNode = findTowerNode(bottomNode);
        while (towerNode != null && flipCoin() == 1) {
            Node nodeToAdd = new Solution().new Node(value);
            addNewNode(nodeToAdd, towerNode, bottomNode);
            bottomNode = nodeToAdd;
            towerNode = findTowerNode(bottomNode);
        }
    }

    private static void addNewNode(Node newNode, Node left, Node down) {
        newNode.left = left;
        newNode.right = left.right;
        if (newNode.right != null) {
            newNode.right.left = newNode;
        }
        newNode.down = down;
        down.up  = newNode;
        left.right = newNode;

    }

    private static Node findTowerNode(Node curr) {
        //Find node from bottom list who has pointer to the level up
        while (curr.left != null && curr.up == null) {
            curr = curr.left;
        }
        return curr.up;
    }

    private static int flipCoin() {
        Random randomNum = new Random();
        return randomNum.nextInt(2);
    }

    private static Node createBottomList(int[] arr) {
        Node head = new Solution().new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            Node newNode =  new Solution().new Node(arr[i]);
            temp.right = newNode;
            newNode.left = temp;
            temp = newNode;
        }
        return head;
    }

    private class Node {
        int value;
        Node right;
        Node left;
        Node up;
        Node down;

        Node(int value) {
            this.value = value;
        }
    }
}
