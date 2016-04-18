package com.zavrab.sortingproblems;

public class Main {

    public static void main(String[] args) {
        // A permutation is an array of int from 1 through N
        // Find duplicate in loose permutation
        // e.g.
        // permutation = {1, 7, 4, 3, 2, 7,4}
        // Output 4 or 7
        // permutation = {1, 3, 2}
        // Output = -1

        int[] permutation = {1, 7, 4, 3, 2, 7, 4};
        int duplicate = findDuplicateInLoosePermutation(permutation);

        System.out.print(duplicate);
    }

    public static int findDuplicateInLoosePermutation(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            if (arr[i] != i + 1) {
                int elementBelongsToIdx = arr[i] - 1;
                if (arr[i] == arr[elementBelongsToIdx]) { //Check if current element and the element at the curr element belongs are same
                    return arr[i]; //Found duplicate
                } else {
                    swap(arr, i, elementBelongsToIdx);
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    private static void swap(int[] arr, int s, int d) {
        int temp = arr[s];
        arr[s] = arr[d];
        arr[d] = temp;
    }
}

