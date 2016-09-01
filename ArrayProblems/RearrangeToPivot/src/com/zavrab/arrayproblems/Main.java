package com.zavrab.arrayproblems;

/*
* Created by Zaver R on 02/17/2016
* */
public class Main {

    public static void main(String[] args) {
        int[] a = new int[] {9, 2, 3, 6, 5, 7, 4, 8, 6};

        String input = "";
        for(int v : a) {
            input += v + " ";
        }
        System.out.println("Input : " + input);

        rearrange(a, 3);
        String output = "";
        for(int v : a) {
            output += v + " ";
        }
        System.out.println("Output : " + output);
    }

    public static void rearrange(int[] A, int pivotIndex) {
        int i =0, j = 0, l = A.length-1;
        int pivot = A[pivotIndex];
        while(j <= l) {
            if(A[j] < pivot) {
                swap(A, i, j);
                i++;
                j++;
            } else if(A[j] == pivot) {
                j++;
            } else {
                swap(A, j, l);
                l--;
            }
        }
    }

    private static void swap(int[] A, int s, int d) {
        int temp = A[d];
        A[d] = A[s];
        A[s] = temp;
    }
}
