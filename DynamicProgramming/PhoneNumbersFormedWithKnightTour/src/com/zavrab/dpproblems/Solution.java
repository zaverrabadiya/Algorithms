package com.zavrab.dpproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Total phone number formed using Knight tour constraint
 *
 * http://stackoverflow.com/questions/2893470/generate-10-digit-number-using-a-phone-keypad
 * https://github.com/harishvc/challenges/blob/master/dp-knight-chess-movement
 *
 */
public class Solution {
    
    private static int[][] legalMoves = new int[][] {
            {1, 2}, // Down right-right
            {1, -2},// Down left-left
            {2, 1}, // Down-down right
            {2, -1},// Down-down left
            {-1, 2},// Up right-right
            {-1, -2},// Up left-left
            {-2, 1}, // Up-up right
            {-2, -1} // Up-up left
    };

    // DP Solution
    public static int totalPhoneNumbers(int start, int len) {
        if (len == 0) return 0;
        final Map<Integer, List<Integer>> graph = createGraph();
        int[] cache = new int[10];
        Arrays.fill(cache, 1);

        for (int l = 2; l <= len; l++) {
            // Will be used to store sum for current length by looking at previous length's sum
            int[] currRowSum = new int[10];
            for (int s = 0; s < 10; s++) {

                // Iterate over each path for current number "s"
                for (int d : graph.getOrDefault(s, new ArrayList<>(0))) {
                    currRowSum[s] += cache[d];
                }
            }

            cache = currRowSum;
        }

        return cache[start];
    }

    // RECURSION with cache
    public static int numPhoneNumbers(int startDigit, int phoneNumberLength) {
        int[][] phonePad = createPhonePad();
        int[][] cache = new int[phoneNumberLength + 1][10];

        return numPhoneNumbers(phonePad, cache, phoneNumberLength, startDigit);
    }

    private static int numPhoneNumbers(int[][] pad, int[][] cache, int len, int start) {
        if (len == 1) {
            return 1;
        }

        if (cache[len][start] == 0) {
            for (Integer nextMove : nextKnightMoveNew(start, pad)) {
                cache[len][start] += numPhoneNumbers(pad, cache, len - 1, nextMove);
            }
        }

        return  cache[len][start];
    }

    private static List<Integer> nextKnightMoveNew(int val, int[][] pad) {
        List<Integer> nextMoves = new ArrayList<Integer>();

        int[] coordinates = getCoordinates(val, pad);

        int i = coordinates[0];
        int j = coordinates[1];

        for (int[] move : legalMoves) {
            int row = i + move[0];
            int col = j + move[1];

            if (isValidMove(pad, row, col)) {
                nextMoves.add(pad[row][col]);
            }
        }

        return nextMoves;
    }

    private static boolean isValidMove(int[][] pad, int i, int j) {
        return ((i >= 0 && j >= 0) && (i < pad.length && j < pad[0].length) && pad[i][j] >= 0);
    }

    private static int[] getCoordinates(int val, int[][] pad) {

        int[] coordinates = new int[2];

        for (int i = 0; i < pad.length; i++) {
            for (int j = 0; j < pad[0].length; j++) {

                if (pad[i][j] == val) {
                   coordinates[0] = i;
                   coordinates[1] = j;

                   return coordinates;
                }
            }
        }

        return coordinates;
    }

    private static int[][] createPhonePad() {

        return new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {-1, 0, -1}
        };
    }

    private static Map<Integer, List<Integer>> createGraph() {
        final Map<Integer, List<Integer>> graph = new HashMap<>();
        final int[][] pad = createPhonePad();

        for (int i = 0; i < pad.length; i++) {
            for (int j = 0; j < pad[0].length; j++) {

                for (int[] move : legalMoves) {
                    int row = i + move[0];
                    int col = j + move[1];

                    if (isValidMove(pad, row, col)) {
                        if (!graph.containsKey(pad[i][j])){
                            graph.put(pad[i][j], new ArrayList<>());
                        }

                        graph.get(pad[i][j]).add(pad[row][col]);
                    }
                }
            }
        }

        return graph;
    }
}
