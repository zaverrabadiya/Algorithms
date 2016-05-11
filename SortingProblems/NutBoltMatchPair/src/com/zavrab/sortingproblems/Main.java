package com.zavrab.sortingproblems;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args)
    {
        // Nuts and bolts are represented as array of characters, NO DUPLICATES
        int[] nuts = new int[] {2, 5, 3, 4, 1};
        int[] bolts = new int[] {5, 3, 2, 1, 4};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, 4);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);
    }

    // Method to print the array
    private static void printArray(int[] arr) {
        for (int ch : arr){
            System.out.print(ch + " ");
        }
        System.out.print("\n");
    }

    // Method which works just like quick sort
    private static void matchPairs(int[] nuts, int[] bolts, int low,
                                   int high)
    {
        if (low < high)
        {
            // Choose last character of bolts array for nuts partition.
            int pivot = partition(nuts, low, high, bolts[high]);

            // Now using the partition of nuts choose that for bolts
            // partition.
            partition(bolts, low, high, bolts[high]);

            // Recur for [low...pivot-1] & [pivot+1...high] for nuts and
            // bolts array.
            matchPairs(nuts, bolts, low, pivot-1);
            matchPairs(nuts, bolts, pivot+1, high);
        }
    }

    // Similar to standard partition method. Here we pass the pivot element
    // too instead of choosing it inside the method.
    private static int partition(int[] arr, int low, int high, int pivot)
    {
        int i = low;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot){
                swap(arr, i, j);
                i++;
            } else if (arr[j] == pivot){
                swap(arr, j, high);
                j--;
            }
        }
        swap(arr, i, high);
        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
