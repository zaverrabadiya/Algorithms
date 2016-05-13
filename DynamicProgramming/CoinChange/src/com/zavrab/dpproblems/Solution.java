package com.zavrab.dpproblems;

public class Solution {

    public static void main(String[] args) {

        int[] coins = {1, 5, 7};
        int change = 11;
        //System.out.print("Min coins: " + coinChangeRecursively(coins, change));

//        int[] cache = new int[change + 1];
//        System.out.print("Min coins: " + coinChangeWithCache(coins, change, cache));
        System.out.print("Min coins: " + coinChangeWithCacheIteratively(coins, change));
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

    public static int coinChangeWithCacheIteratively(int[] coins, int change) {
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
}
