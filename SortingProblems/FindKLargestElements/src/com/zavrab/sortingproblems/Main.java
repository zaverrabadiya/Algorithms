package com.zavrab.sortingproblems;

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
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>(topK);

        int i = 1;
        priorityQueue.add(arr[0]);
        while (i < arr.length) {
            if (arr[i++] > priorityQueue.peek()) {
                priorityQueue.add(arr[i]);

                if (priorityQueue.size() > topK) {
                    priorityQueue.poll();
                }
            }
        }

        return convertPQToArray(priorityQueue, topK);
    }

    private static int[] convertPQToArray(PriorityQueue<Integer> priorityQueue, int topK) {
        int[] output = new int[topK];
        int i = topK - 1;
        while (priorityQueue.size() > 0 ) {
            output[i--] = priorityQueue.poll();
        }
        return output;
    }
}
