package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Integer> permutation = computeRandomPermutation(4);
        for (int p : permutation) {
            System.out.print(p + " ");
        }
    }

    public static List<Integer> computeRandomPermutation(int n) {
        List<Integer> permutation = new ArrayList<Integer>(n);
        for (int i = 0; i < n; i++) {
            permutation.add(i);
        }

        randomSampling(n, permutation);
        return permutation;
    }

    private static void randomSampling(int k, List<Integer> A) {
        Random gen = new Random();
        for (int i = 0; i < k; i++) {
            //Generate random int in A[i, A.size() - i]
            int x = i + gen.nextInt(A.size() - i);
            Collections.swap(A , i, x);
        }
    }
}
