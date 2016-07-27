package com.zavrab.dpproblems;

// http://n00tc0d3r.blogspot.com/2013/07/optimal-game-strategy-maximum-coin-value.html

public class CoinPlay {

    public static void main(String[] args) {
        int[] coins = new int[] {8, 15, 3, 7};

        //System.out.print("Result: " + maxWinRecursive(coins));
        System.out.print("Result: " + maxWin(coins));
    }

    // DP Solution
    public static int maxWin(int[] intCoins) {
        int n = intCoins.length;
        int[][] cache = new int[n][n];

        for (int k = 0; k < n; k++) {
            for (int i = 0, j = k; j < n; i++, j++) {

                int x = ((i + 2) <= j) ? cache[i + 2][j] : 0;

                int y = ((i + 1) <= (j - 1)) ? cache[i + 1][j - 1] : 0;

                int z = ((j - 2) >= i) ? cache[i][j - 2] : 0;

                cache[i][j] = Math.max(intCoins[i] + Math.min(x, y), intCoins[j] + Math.min(y, z));
            }
        }

        return cache[0][n-1];
    }

    // RECURSIVE Solution
    public static int maxWinRecursive(int[] intCoins) {
        return maxWinRecursive(intCoins, 0, intCoins.length - 1);
    }

    private static int maxWinRecursive(int[] coins, int i, int j) {
        if (i == j) {
            return coins[i];
        } else if (i + 1 == j){
            return Math.max(coins[i], coins[j]);
        }

        //Let us look one extra step ahead this time by considering the two coins the opponent will possibly take,
        // Ai+1 and Aj. If the opponent takes Ai+1, the remaining coins are { Ai+2 … Aj }, which our maximum is denoted by P(i+2, j).

        //On the other hand, if the opponent takes Aj,
        // our maximum is P(i+1, j-1). Since the opponent is as smart as you,
        // he  would have chosen the choice that yields the minimum amount to you.

        int a = maxWinRecursive(coins, i + 2, j);
        int b = maxWinRecursive(coins, i + 1, j - 1);
        int maxStart = coins[i] + Math.min(a, b);

        int c = maxWinRecursive(coins, i, j - 2);
        int d = maxWinRecursive(coins, i + 1, j - 1);
        int maxEnd = coins[j] + Math.min(c, d);

//        int maxStart = coins[i] + Math.min(maxWinRecursive(coins, i + 2, j), maxWinRecursive(coins, i + 1, j - 1));
//        int maxEnd = coins[j] + Math.min(maxWinRecursive(coins, i, j - 2), maxWinRecursive(coins, i + 1, j - 1));

        return Math.max(maxStart, maxEnd);
    }
}
