package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Integer> a = new ArrayList<Integer>(Arrays.asList(1, 0, 5, 3, 2, 0));

        //Output should be 1 2 0 0 3 5
        List<Integer> result = findNextPermute(a);
        for ( int i : result ) {
            System.out.print(i +" ");
        }
    }

    public static List<Integer> findNextPermute(List<Integer> a) {
        int k = a.size() - 2;

        //Start from right and find the suffix in decreasing order
        //Index k is less than the max number in suffix
        while (k >= 0 && a.get(k) > a.get(k + 1)) {
            k--;
        }

        if(k == -1) {
            return Collections.emptyList();
        }

        //Swap element at k with element at l in suffix which is greater than k
        for (int l = a.size() -1; l > k; l--) {
            if (a.get(l) > a.get(k)) {
                Collections.swap(a, k, l);
                break;
            }
        }

        //Reverse the suffix since it is in decreasing order
        Collections.reverse(a.subList((k + 1), a.size()));

        return a;
    }
}
