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
        priorityQueue.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > priorityQueue.peek()) {

                // Remove the top small element, so bigger than that element can be pushed in
                if (priorityQueue.size() == topK) {
                    priorityQueue.poll();
                }

                priorityQueue.add(arr[i]);
            }
        }

        return convertPqToArray(priorityQueue, topK);
    }

    private static int[] convertPqToArray(PriorityQueue<Integer> priorityQueue, int topK) {
        int[] output = new int[topK];
        int i = topK - 1;

        while (priorityQueue.size() > 0 ) {
            output[i--] = priorityQueue.poll();
        }

        return output;
    }
}
