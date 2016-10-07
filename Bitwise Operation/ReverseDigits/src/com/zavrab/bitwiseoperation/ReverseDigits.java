package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/15/16.
 */
public class ReverseDigits {
    public static long reverse(long x) {
        boolean isNegative = x < 0;
        long result = 0;

        while (x != 0) {
            result = (result * 10) + (x % 10);
            x /= 10;
        }

        return (isNegative)? -result : result;
    }
}
