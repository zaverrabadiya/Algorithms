package com.zavrab.sortingproblems;

public class Main {

    public static void main(String[] args) {
	    int[] s = {1, 4, 6, 8};
        int[] l = {2, 3, 5, 7, 0, 0, 0, 0};

        int[] mergedArray = mergeFirstIntoAnother(s, l);

        for (int i : mergedArray) {
            System.out.print(i + " ");
        }
    }

    public static int[] mergeFirstIntoAnother(int[] intArrShort, int[] intArrLong) {
        if (intArrShort == null || intArrShort.length == 0) {
            return intArrLong;
        }

        if (intArrLong == null || intArrLong.length == 0) {
            return intArrShort;
        }

        int len = intArrShort.length;
        int i = intArrLong.length - 1;
        int j = len -1, k = len - 1;

        for (; i >= 0; i--) {
            if (k >= 0 && j < 0) {
                intArrLong[i] = intArrLong[k--];
            } else if ( j >= 0 && k < 0){
                intArrLong[i] = intArrShort[j--];
            } else if (intArrLong[k] > intArrShort[j]) {
                intArrLong[i] = intArrLong[k--];
            } else {
                intArrLong[i] = intArrShort[j--];
            }
        }
        return intArrLong;
    }
}
