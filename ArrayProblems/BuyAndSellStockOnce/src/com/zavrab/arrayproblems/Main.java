package com.zavrab.arrayproblems;

public class Main {

    public static void main(String[] args) {

        int[] stockPrices = new int[] {310, 315, 275, 295, 260, 270, 290, 230, 255, 250};
        System.out.println("Max profit: " + computeMaxProfit(stockPrices));
    }

    public static int computeMaxProfit(int[] S) {
        int maxProfit = 0;
        int minPrice = S[0];

        for (int i = 1; i < S.length; i++) {
            maxProfit = Math.max(maxProfit, (S[i] - minPrice));
            minPrice = Math.min(minPrice, S[i]);
        }
        return maxProfit;
    }
}
