package com.zavrab.adhoc;

public class Main {

    public static void main(String[] args) {
        int a = 9;
        System.out.format("\nSqrt of: %d = %.1f", a, sqrt(a));

        a = 10;
        System.out.format("\nSqrt of: %d = %.1f", a, sqrt(a));
    }

    public static double sqrt(int a) {
        double start = 0;
        double end = a;
        double e = 0.000001; // e decides the accuracy level
        double mid = 0.0;

        while(end - start > e)
        {
            mid = (start + end) / 2;
            double estimate = mid * mid;

            if (estimate == a) {
                return a;
            }
            else if (estimate > a) {
                end = mid;
            }
            else {
                start = mid;
            }
        }

        return mid;
    }

    public static double sqrt2ndApproach(int a) {
        double start = 1;
        double end = a;
        double e = 0.000001; /* e decides the accuracy level*/

        while(end - start > e)
        {
            end = (start + end)/2;
            start = a/end;
        }

        return end;
    }
}
