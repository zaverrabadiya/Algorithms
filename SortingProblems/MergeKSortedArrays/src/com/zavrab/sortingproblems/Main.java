package com.zavrab.sortingproblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
	    int[][] input = {
                {2, 5, 8, 9},
                {0, 10, 6, 11},
                {1, 3, 4, 7}
        };

        int[] mergedArray = merge(input, 3, 4);

        for (int i : mergedArray) {
            System.out.println(i);
        }
    }

    public static int[] merge(int[][] arr, int n, int k) {
        PriorityQueue priorityQueue = new PriorityQueue(n * k);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                priorityQueue.add(arr[i][j]);
            }
        }
        return convertPQToArray(priorityQueue);
    }

    private static int[] convertPQToArray(PriorityQueue<Integer> priorityQueue) {
        int[] arr = new int[priorityQueue.size()];
        int i = 0;
        while (priorityQueue.size() > 0) {
            arr[i++] = priorityQueue.poll();
        }
        return arr;
    }
}
