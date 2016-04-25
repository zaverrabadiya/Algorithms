package com.zavrab.sortingproblems;

public class Main {

    public static void main(String[] args) {

        int[] input = {5, 4, 0, 1, 3, 2};
        int[] result = MergeSort(input);

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] MergeSort(int[] intArr) {
        sort(intArr, 0, intArr.length - 1);
        return intArr;
    }

    private static void sort(int[] arr, int s, int e) {
        if (s < e) {
            int mid = s + ((e-s) / 2);

            sort(arr, s, mid);
            sort(arr, mid + 1, e);
            merge(arr, s, mid, e);
        }
    }

    private static void merge(int[] arr, int s, int mid, int e){
        int[] mergedArr = new int[arr.length];
        int j = s, k = mid + 1;

        for (int i = s; i <= e; i++) {
            if (j <= mid && k > e) {
                mergedArr[i] = arr[j++];
            } else if (k <= e && j > mid) {
                mergedArr[i] = arr[k++];
            } else if (arr[j] < arr[k]) {
                mergedArr[i] = arr[j++];
            } else {
                mergedArr[i] = arr[k++];
            }
        }

        for (int l = s; l <= e; l++) {
            arr[l] = mergedArr[l];
        }
    }
}
