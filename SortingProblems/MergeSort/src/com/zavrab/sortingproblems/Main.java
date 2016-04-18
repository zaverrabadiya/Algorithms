package com.zavrab.sortingproblems;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {5, 4, 0, 1, 3, 2};
        int[] result = MergeSort(input);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] MergeSort(int[] intArr) {
        int[] sortedArray = new int[intArr.length];
        sort(intArr, 0, intArr.length - 1, sortedArray);
        return sortedArray;
    }

    private static void sort(int[] arr, int s, int e, int[] result) {
        if (s < e) {
            int mid = s + ((e-s) / 2);

            sort(arr, s, mid, result);
            sort(arr, mid + 1, e, result);
            merge(arr, s, mid, e, result);
        }
    }

    private static void merge(int[] arr, int s, int mid, int e, int[] result) {
        int i = s, j = s, k = mid + 1;

        while (j <= mid && k <= e) {
            if (arr[j] <= arr[k]) {
                result[i++] = arr[j++];
            } else {
                result[i++] = arr[k++];
            }
        }

        while (j <= mid) {
            result[i++] = arr[j++];
        }

        while (k <= e) {
            result[i++] = arr[k++];
        }

        for (int l = 0; l <= e; l++) {
            arr[l] = result[l];
        }
    }
}
