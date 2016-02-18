package com.zavrab.arrayproblem;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Integer> a = new ArrayList<Integer>();
        a.add(1);
        a.add(2);
        a.add(9);

        //Input {1,2,9} Output {1,3,0}
        List<Integer> result = plusOne(a);
        for (int x:result) {
            System.out.println(x);
        }
    }

    public static List<Integer> plusOne(List<Integer> A) {
        int n = A.size() - 1;
        A.set(n, (A.get(n) + 1));
        for(int i = n; i >0 && A.get(i) == 10; i--) {
            A.set(i, 0);
            A.set((i - 1), (A.get(i - 1) + 1));
        }

        //Need to add additional digit as A.get(0) has a carry-out
        if(A.get(0) == 10) {
            A.set(0, 0);
            A.add(0, 1);
        }
        return A;
    }
}
