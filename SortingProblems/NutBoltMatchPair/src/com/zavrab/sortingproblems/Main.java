package com.zavrab.sortingproblems;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args)
    {
        // Nuts and bolts are represented as array of characters, NO DUPLICATES
        int[] nuts = new int[] {2, 5, 3, 4, 1, 3, 6};
        int[] bolts = new int[] {5, 3, 2, 1, 3, 4, 6};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, nuts.length - 1);

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
    private static void matchPairs(int[] nuts, int[] bolts, int low, int high)
    {
        if (low < high)
        {
            // Choose first element of nuts array for nuts partition.
            int pivotIndx = partition(nuts, low, high, nuts[low]);

            // Now using the partition of nuts choose that for bolts partition.
            partition(bolts, low, high, nuts[pivotIndx]);

            // Recur for [low...pivot-1] & [pivot+1...high] for nuts and bolts array.
            matchPairs(nuts, bolts, low, pivotIndx-1);
            matchPairs(nuts, bolts, pivotIndx+1, high);
        }
    }

    // Similar to standard partition method. Here we pass the pivot element
    // too instead of choosing it inside the method.
    private static int partition(int[] arr, int low, int high, int pivot) {
        int i = low, end = high, j = low ;

        while (j <= end) {
            if (arr[j] < pivot){
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[j] == pivot){
                swap(arr, j, end);
                end--;
            } else {
                j++;
            }
        }

        // Put pivot to the place where it belongs to
        swap(arr, i, high);
        // Return the partition index of an array based on the pivot element of other array.
        return i;
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}
