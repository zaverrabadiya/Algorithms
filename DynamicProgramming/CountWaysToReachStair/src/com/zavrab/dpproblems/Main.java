package com.zavrab.dpproblems;

/**
 * There are n stairs, a person standing at the bottom wants to reach the top.
 * The person can climb either 1 stair or 2 stairs at a time. Count the number of ways,
 * the person can reach the top.
 *
 * http://www.geeksforgeeks.org/count-ways-reach-nth-stair/
 * */
public class Main {

    public static void main(String[] args) {
        int numOfStairs = 4;
        int climbUpto = 3;
        System.out.println("Total ways: " + numOfWaysToClimb(numOfStairs, climbUpto));
    }

    public static int numOfWaysToClimb(int numOfStairs, int jump) {
        //return numOfWaysToClimbRec(numOfStairs + 1, jump);
        return numOfWaysToClimbDp(numOfStairs + 1, jump);
    }

    //DP solution
    private static int numOfWaysToClimbDp(int stairs, int jump) {
        int ways[] = new int[stairs + 1];
        ways[1] = 1;

        for (int i = 2; i <= stairs; i++) {

            for (int j = 1; j <= jump && j <= i; j++) {
                ways[i] += ways[i - j];
            }
        }

        return ways[stairs];
    }

    // RECURSION Solution
    private static int numOfWaysToClimbRec(int stairs, int jump) {
        if (stairs <= 1) {
            return stairs;
        }

        int ways = 0;

        for (int i = 1; i <= jump && i <= stairs; i++) {
            ways += numOfWaysToClimbRec(stairs - i, jump);
        }

        return ways;
    }




}
