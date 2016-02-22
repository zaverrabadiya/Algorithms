package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Integer> A = new ArrayList<Integer>();
        A.add(5);
        A.add(7);
        A.add(3);
        A.add(11);
        A.add(2);
        A.add(3);
        A.add(13);
        A.add(5);
        A.add(7);

        System.out.println("Number of valid entries after deletion: " + deleteKey(A, 3));
    }

    //Returns the number of valid entries after deletion
    public static int deleteKey(List<Integer> A, int key) {
        int writeIdx = 0;

        for(int i = 0; i < A.size(); i++) {
            if(A.get(i) != key) {
                A.set(writeIdx++, A.get(i));
            }
        }
        return writeIdx;
    }
}
