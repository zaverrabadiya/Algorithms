package com.zavrab.arrayproblems;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[] {3, 3, 1, 0, 2, 0, 2};
        System.out.println("Can reach to the end: " + canReadEnd(arr));

        int[] arr2 = new int[] {3, 2, 0, 0, 2, 0, 1};
        System.out.println("Can reach to the end: " + canReadEnd(arr2));
    }

    //Input A = {3, 3, 1, 0, 2, 0, 2} Output = true
    //A[0] max steps = 3 so, A[0] 1 step A[1] => 3 steps A[4] => 2 steps A[6] reached to the end

    //Input A = {3, 2, 0, 0, 2, 0, 1} Output = false
    //A[0] to A[1] => A[3] which is 0 so stuck
    public static boolean canReadEnd(int[] maxAdvanceSteps) {
        int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.length - 1;

        for(int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; i++) {
            furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps[i]);
        }
        return furthestReachSoFar >= lastIndex;
    }
}
