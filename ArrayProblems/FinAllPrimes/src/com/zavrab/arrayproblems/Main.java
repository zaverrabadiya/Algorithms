package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        for (int prime: findPrimes(18)) {
            System.out.print(prime + "  ");
        }
    }

    public static List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<Integer>();

        //isPrime.get(p) represents is p is prime or not. Initially set each to true excepting 0 and 1.
        //Then use sieving to eliminate nonprimes.
        List<Boolean> isPrime = new ArrayList<Boolean>(Collections.nCopies(n + 1, true));
        isPrime.set(0, false);
        isPrime.set(1, false);

        for(int p = 2; p <= n; p++) {
            if(isPrime.get(p)) {
                primes.add(p);

                //Sieve p's multiples e.g. p = 2, sieve 4, 6, 8, 10 and so on...
                for(int m = p; m <= n; m += p) {
                    isPrime.set(m, false);
                }
            }
        }
        return primes;
    }
}
