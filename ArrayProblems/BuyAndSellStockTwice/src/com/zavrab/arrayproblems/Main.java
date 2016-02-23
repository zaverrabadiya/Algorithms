package com.zavrab.arrayproblems;

public class Main {

    public static void main(String[] args) {
        int[] prices = new int[] {12, 11, 13, 9, 12, 8, 14, 13, 15};
        System.out.println("Max profit is: " + computeMaxProfitByBuyingAndSellingTwice(prices));
    }


    //Buy and sell twice, second buy must be after 1st sell
    public static int computeMaxProfitByBuyingAndSellingTwice(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        //Forward max profits
        int[] f = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]);

            f[i] = maxProfit;
        }

        //f[] = {0, 0, 2, 2, 3, 3, 6, 6, 7}

        //Backward max profits b = {7, 7, 7, 7, 7, 7, 2, 2, 0}
        //We compute maxProfit[i] = b[i] + f[i -1]; since the second buy must happen strictly after the first sell
        int maxPrice = Integer.MIN_VALUE;
        for (int j = prices.length - 1; j > 0; j--) {
            maxPrice = Math.max(maxPrice, prices[j]);
            maxProfit = Math.max(maxProfit , (maxPrice - prices[j]) + f[j - 1]);
        }

        return maxProfit;
    }
}
