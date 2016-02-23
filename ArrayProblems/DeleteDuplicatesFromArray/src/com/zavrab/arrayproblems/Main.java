package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<Integer>();
        A.add(2);
        A.add(3);
        A.add(5);
        A.add(5);
        A.add(7);
        A.add(11);
        A.add(11);
        A.add(11);
        A.add(13);

        System.out.println("Number of valid entries after deleting duplicates: " + deleteDuplicates(A));
    }

    //Returns the number of valid entries after deletion
    public static int deleteDuplicates(List<Integer> A) {
        if(A.isEmpty()) {
            return 0;
        }

        int writeIdx = 1;

        for(int i = 1; i < A.size(); i++) {
            if(!A.get(i-1).equals(A.get(i))) {
                A.set(writeIdx++, A.get(i));
            }
        }
        return writeIdx;
    }
}
