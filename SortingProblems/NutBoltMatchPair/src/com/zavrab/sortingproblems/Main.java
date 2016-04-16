package com.zavrab.sortingproblems;

import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args)
    {
        // Nuts and bolts are represented as array of characters
        int[] nuts = new int[] {2, 3, 5, 4, 1};
        int[] bolts = new int[] {4, 5, 2, 1, 3};

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
            partition(bolts, low, high, nuts[pivot]);

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
        int temp1, temp2;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot){
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
            } else if(arr[j] == pivot){
                temp1 = arr[j];
                arr[j] = arr[high];
                arr[high] = temp1;
                j--;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[high];
        arr[high] = temp2;

        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }
}
