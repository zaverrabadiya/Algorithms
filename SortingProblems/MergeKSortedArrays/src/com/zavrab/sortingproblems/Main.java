package com.zavrab.sortingproblems;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	    int[][] input = {
                {2, 5, 8, 9},
                {6, 10, 11, 12},
                {1, 3, 4, 7}
        };

        int[][] input2 = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[][] input3 = {
                {9, 10, 11, 12},
                {5, 6, 7, 8},
                {1, 2, 3, 4}
        };

        int[] mergedArray = merge(input, 3, 4);

        for (int i : mergedArray) {
            System.out.println(i);
        }
    }

    public static int[] merge(int[][] arr, int k, int n) {
        int[] output = new int[k * n];
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(k);
        int s = 0, row, col;
        Node minNode;

        for (int i = 0; i < k; i++) {
            priorityQueue.add(new Node(arr[i][0], i, 0));
        }

        while (!priorityQueue.isEmpty()) {
            minNode = priorityQueue.poll();

            // Add min element to the result
            output[s++] = minNode.val;

            // Add next element to the queue from the same array that of Just-extracted minimum element belongs to
            if (minNode.col < n-1) {
                row = minNode.row;
                col = minNode.col + 1;
                priorityQueue.add(new Node(arr[row][col], row, col));
            }

        }

        return output;
    }

    private static class Node implements Comparable {
        int val;
        int row;
        int col;

        Node(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Object o) {
            Node other = (Node)o;

            if (val < other.val) {
                return  -1;
            } else if (val > other.val) {
                return 1;
            }

            return 0;
        }
    }
}
