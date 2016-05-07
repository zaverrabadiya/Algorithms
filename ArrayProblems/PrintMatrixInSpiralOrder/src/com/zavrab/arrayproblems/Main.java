package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] input = new int[3][3];
        input[0][0] = 1;
        input[0][1] = 2;
        input[0][2] = 3;
        input[1][0] = 4;
        input[1][1] = 5;
        input[1][2] = 6;
        input[2][0] = 7;
        input[2][1] = 8;
        input[2][2] = 9;
        spiral(input);
    }

    public static void spiral(int[][] list) {
        int low = 0, i = 0, j = 0, rowHigh = list.length, colHigh = list.length;
        List<Integer> result = new ArrayList<Integer>();

        while (low <= colHigh) {
            while (j < colHigh) {
                result.add(list[i][j]);
                j++;
            }
            colHigh--;
            i++;
            while (i < rowHigh) {
                result.add(list[i][colHigh]);
                i++;
            }
            rowHigh--;
            j--;
            low++;
            while (j-- > low) {
                result.add(list[rowHigh][j]);
            }
        }
    }
}
