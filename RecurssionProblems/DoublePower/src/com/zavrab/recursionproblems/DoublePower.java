package com.zavrab.recursionproblems;

public class DoublePower {

    public static void main(String[] args) {
        double x = 2;
        int y = 4;
        System.out.format("%.2f power %d is: %.4f \n", x, y, power(x, y));

        x = 4; y = -2;
        System.out.format("%.2f power %d is: %.4f \n", x, y, power(x, y));
    }


    /**
     * Optimized
     * If n is even, then xn = (x2)n/2
     * If n is odd, then xn = x * (x2)(n-1)/2
     * deepest the recursion will ever go is 1 + log2 n levels.
     * */
    public static double power(double x, int y) {
        if (y == 0) {
            return 1;
        }

        if (y < 0) {
            return 1 / power(x, -y);    // Handling negative power
        }

        double tempResult = power(x, y / 2);

        if (y % 2 == 0) {
            return tempResult * tempResult;
        } else {
            return x * (tempResult * tempResult);
        }
    }

    /**
     * Brute-force
     * deepest the recursion will n levels.
     * */
    public static double powerBt(double x, int y) {
        if (y == 0) {
            return 1;
        }

        if (y < 0) {
            return 1 / (x * power(x, -y - 1)); // Handling negative power
        }

        return x * power(x, y - 1);
    }
}
