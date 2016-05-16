package com.zavrab.dpproblems;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        // e.g.
        // coins: {1, 5, 7}, change: 11 => minCoins: 3, combination: {1,5,5}
        // coins: {1, 2, 3}, change: 4 => minCoins: 2, combination: {1,3}, {2,2}

        int[] coins = {1, 5, 7};
        int change = 11;

        printMinCoinCombinations(coins, change);
        //System.out.print("Min coins: " + minCoinChangeWithCacheIteratively(coins, change));

        //int[] cache = new int[change + 1];
        //System.out.print("Min coins: " + coinChangeWithCache(coins, change, cache));

        //System.out.print("Min coins: " + coinChangeRecursively(coins, change));
    }

    public static int minCoinChangeWithCacheIteratively(int[] coins, int change) {
        int[] cache = new int[change + 1];
        cache[0] = 0;

        for (int i = 1; i <= change; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    if (cache[i] == 0 || (cache[i] >= cache[i - coin])) {
                        cache[i] = cache[i - coin] + 1;
                    }
                }
            }
        }
        return cache[change];
    }

    public static int coinChangeWithCache(int[] coins, int change, int[] cache) {
        if (cache[change] > 0) {
            return cache[change];
        }
        int min = 0;

        for (int coin : coins) {
            if (change - coin == 0) {
                return 1;
            }
            if (change - coin > 0) {
                int ans = coinChangeWithCache(coins, change - coin, cache);
                if (ans != 0) {
                    if (min == 0 || ans < min) {
                        min = ans;
                    }
                }
                cache[change - coin] = min;
            }
        }
        return min + 1;
    }

    public static int coinChangeRecursively(int[] coins, int change) {
        int min = 0;

        for (int coin : coins) {
            if (change - coin == 0) {
                return 1;
            }
            if (change - coin > 0) {
                int ans = coinChangeRecursively(coins, change - coin);

                if (ans != 0) {
                    if (min == 0 || ans < min) {
                        min = ans;
                    }
                }
            }
        }
        return min + 1;
    }

    // ASSUMING coins in order, have multiple coins of each denominator
    public static void printMinCoinCombinations(int[] coins, int change) {
        List<Integer>[][] cache = new List[change + 1][coins.length];

        // Init Zero change with empty list
        for (int x = 0; x < coins.length; x++) {
            cache[0][x] = new ArrayList<Integer>();
        }


        // i represents change and j represents coin
        for (int i = 1; i <= change; i++) {
            for (int j = 0; j < coins.length; j++) {
                cache[i][j] = new ArrayList<Integer>();
                if (j > 0) {
                    cache[i][j].addAll(cache[i][j - 1]); //Copy result of previous coin
                }

                if (coins[j] <= i) {
                    int subChange = i - coins[j];

                    List<Integer> newCombination = new ArrayList<Integer>(cache[subChange][j]); //Copy result of previous change with current coin
                    newCombination.add(coins[j]); //Add current coin to the combination

                    if (cache[i][j].size() == 0 || newCombination.size() <= cache[i][j].size()) { //Copy new combination only if it is <= previous coin combination
                        cache[i][j] = newCombination;
                    }
                }
            }
        }

        printCombinationFromCache(cache, change, coins.length);
    }

    private static void printCombinationFromCache(List[][] cache, int n, int m) {
        int min = Integer.MAX_VALUE;
        String result = "";

        for (int c = m - 1; c >= 0; c--) {
            List<Integer> combination = cache[n][c];
            if (combination.size() <= min) {
                String currResult = "";
                for (Integer d : combination) {
                    currResult += d + ",";
                }
                if (!result.equals(currResult)) {
                    System.out.println(currResult.substring(0, currResult.length() - 1)); //Trim last ','
                    result = currResult;
                }
                min = combination.size();
            }
        }
    }
}
