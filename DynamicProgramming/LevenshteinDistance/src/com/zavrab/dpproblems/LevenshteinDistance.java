package com.zavrab.dpproblems;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
 *
 * Insert, Remove, Replace
 *
 * All of the above operations are of equal cost.
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * https://en.wikipedia.org/wiki/Levenshtein_distance
 *
 * */
public class LevenshteinDistance {

    public static void main(String[] args) {
        String strS = "kitten";
        String strT = "sitting";
        System.out.println("\nDistance: " + levenshteinDistance(strS, strT));

        strS = "pizza";
        strT = "yolo";
        System.out.println("\nDistance: " + levenshteinDistance(strS, strT));
    }

    public static int levenshteinDistance(String strS, String strT) {
        //return distanceRec(strS, strT, strS.length(), strT.length());
        return distanceDp(strS, strT);
    }

    private static int distanceDp(String s, String t) {
        int n = s.length(), m = t.length();

        if (n == 0) {
            return m;
        }

        if (m == 0) {
            return n;
        }

        int[][] cache = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) { // Iterates String source
            for (int j = 0; j <= m; j++) { // Iterates String target

                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0) {
                    cache[i][j] = j;
                }

                // If second string is empty, only option is to
                // remove all characters of second string
                else if (j == 0) {
                    cache[i][j] = i;
                }
                else if (s.charAt(i-1) == t.charAt(j-1)) {
                    cache[i][j] = cache[i-1][j-1];
                }
                // If last character are different, consider all
                // possibilities and find minimum
                else {
                    int delete = cache[i-1][j];
                    int insert = cache[i][j-1];
                    int replace = cache[i-1][j-1];

                    cache[i][j] = 1 + Math.min(Math.min(delete, insert), replace);
                }
            }
        }

        // Print table for DEBUG PURPOSE ONLY
        printDebugTable(cache);

        return cache[n][m];
    }

    // RECURSIVE Solution
    private static int distanceRec(String s, String t, int i, int j) {
        if (i == 0) {
            return j;   // String a is empty, so needs to add j characters to a
        }

        if (j == 0) {
            return i;   // String b is empty, so needs to remove i characters from a
        }

        if (s.charAt(i -1) == t.charAt(j - 1)) {
            return distanceRec(s, t, i-1, j-1);
        }

        int delete = distanceRec(s, t, i-1, j);
        int insert = distanceRec(s, t, i, j-1);
        int replace = distanceRec(s, t, i-1, j-1);

        return 1 + Math.min(Math.min(delete, insert), replace);
    }

    private static void printDebugTable(int[][] cache) {
        System.out.println("==============================");
        for (int[] aCache : cache) {
            for (int j : aCache) {
                System.out.print(j + "\t");
            }

            System.out.println("");
        }
    }
}
