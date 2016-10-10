package com.zavrab.recurssionproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int boardSize = 5;
        List<Integer[]> validQueenPositions = findNQueenPositions(boardSize);

        for (Integer[] positions : validQueenPositions) {
            List<String> arr = new ArrayList<String>(positions.length);

            for (int i = 0; i < positions.length; i++) {
                arr.add("" + positions[i]);
            }

            String output = String.join(",", arr);
            System.out.println(output);
        }
    }

    public static List<Integer[]> findNQueenPositions(int n) {
        Integer[] queens = new Integer[n];

        for (int i = 0; i < n; i++) {
            queens[i] = i;
        }

        List<Integer[]> result = new ArrayList<Integer[]>();
        findNQueenPositions(queens, 0, result);

        return  result;
    }

    private static void findNQueenPositions(Integer[] queens, int pos, List<Integer[]> result) {

        if (pos == queens.length - 1) {
            if (isValid(queens, pos)) {
                Integer[] temp = queens.clone();
                result.add(temp);
            }

            return ;
        }

        for (int j = pos; j < queens.length; j++) {
            swap(queens, pos, j);

            if (isValid(queens, pos)) {
                findNQueenPositions(queens, pos + 1, result);
            }

            swap(queens, j, pos);
        }
    }

    private static void  swap(Integer[] a, int l, int r) {
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    private static boolean isValid(Integer[] a, int pos) {
        // Queens positions in diagonal up and down direction
        int x = a[pos] - 1, y = a[pos] + 1;

        // As we go backward, check if current queen collides with any in diagonal up and down direction
        for (int i = pos - 1; i >= 0; i--) {
            if (x == a[i] || y == a[i]) {
                return false;
            }

            x--; // Diagonal down
            y++; // Diagonal up
        }

        return true;
    }
}
