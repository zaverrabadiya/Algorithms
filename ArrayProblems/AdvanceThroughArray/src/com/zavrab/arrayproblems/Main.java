package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(3);
        A.add(3);
        A.add(1);
        A.add(0);
        A.add(2);
        A.add(0);
        A.add(2);

        System.out.println("Can reach to the end: " + canReadEnd(A));
    }

    //Input A = {3, 3, 1, 0, 2, 0, 2} Output = true
    //A[0] max steps = 3 so, A[0] 1 step A[1] => 3 steps A[4] => 2 steps A[6] reached to the end

    //Input A = {3, 2, 0, 0, 2, 0, 1} Output = false
    //A[0] to A[1] => A[3] which is 0 so stuck
    public static boolean canReadEnd(List<Integer> maxAdvanceSteps) {
        int furthestReachSoFar = 0, lastIndex = maxAdvanceSteps.size() - 1;

        for(int i = 0; i <= furthestReachSoFar && furthestReachSoFar < lastIndex; i++) {
            furthestReachSoFar = Math.max(furthestReachSoFar, i + maxAdvanceSteps.get(i));
        }
        return furthestReachSoFar >= lastIndex;
    }
}
