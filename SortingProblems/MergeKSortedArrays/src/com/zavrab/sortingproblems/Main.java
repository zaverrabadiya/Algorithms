package com.zavrab.sortingproblems;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	    int[][] input = {
                {2, 5, 8, 9},
                {0, 6, 10, 11},
                {1, 3, 4, 7}
        };

        int[] mergedArray = merge(input, 3, 4);

        for (int i : mergedArray) {
            System.out.println(i);
        }
    }

    public static int[] merge(int[][] arr, int k, int n) {
        int[] output = new int[k * n];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(k);
        int s = 0;

        int min;
        for (int i = 0; i < n; i++) { //Pick ith elements in each array, since they are sorted
            for (int j = 0; j < k; j++) {
                priorityQueue.add(arr[j][i]);
            }
            min = priorityQueue.poll();
            output[s++] = min;
        }

        while (priorityQueue.size() > 0) {
            min = priorityQueue.poll();
            output[s++] = min;
        }

        return output;
    }
}
