package com.zavrab.sortingproblems;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int[] input = {5, 6, 7, 2, 1, 4, 3};

        int[] result = findKLargest(input, 2);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] findKLargest(int[] arr, int topK) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(topK, Collections.<Integer>reverseOrder());

        int i = 0;
        while (i < arr.length) {
            priorityQueue.add(arr[i++]);
        }

        return convertPQToArray(priorityQueue, topK);
    }

    private static int[] convertPQToArray(PriorityQueue<Integer> priorityQueue, int topK) {
        int[] output = new int[topK];
        int i = 0;
        while (priorityQueue.size() > 0 && i < topK) {
            output[i++] = priorityQueue.poll();
        }
        return output;
    }
}
