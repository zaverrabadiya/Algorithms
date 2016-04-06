package com.zavrab.arrayproblems;

import java.util.*;

public class Main {

    public static void main(String[] args) {

//        Boolean true or false, whether there is a group of integers (may or may not be contiguous) in the input, that sums to K.
//
//        e.g.
//        Sum({2, 4, 8}, 6) → true
//        Sum({2, -4, 8}, 1) → false
//        Sum({2, 4, 8}, 14) → true
//        Sum({2, 4, 8}, 9) → false

        int[] a = new int[] {2, 4, 8};
        System.out.println("Sums to K is: " + sum(a, 14));
    }

    public static boolean sum(int[] a, int k) {
        if (a == null || a.length == 0) {
            return false;
        }
        Arrays.sort(a);
        HashSet<Integer> resultsSoFar = new HashSet<Integer>(); //Used for memoization

        for (int i : a) {
            List<Integer> tempList = new ArrayList<Integer>();
            tempList.add(i);
            if (resultsSoFar.size() > 0) {

                int targetNeeds = k - i;
                if (resultsSoFar.contains(targetNeeds)) {
                    return true;
                }

                Iterator iterator = resultsSoFar.iterator();
                while (iterator.hasNext()) {
                    int v = (Integer) iterator.next();
                    int sum  = i + v;
                    if (sum == k) {
                        return true;
                    } else {
                        tempList.add(sum);
                    }
                }
            }
            resultsSoFar.addAll(tempList);
        }
        return false;
    }
}
