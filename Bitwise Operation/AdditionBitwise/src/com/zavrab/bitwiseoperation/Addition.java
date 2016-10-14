package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/12/16.
 */
public class Addition {

    public static long sum(long x, long y) {
        long tempX = x, tempY = y, carryIn = 0, sum = 0, k = 1;

        while(tempX != 0 || tempY != 0) {
            long xk = (x & k), yk = (y & k);
            long carryOut = (xk & yk) | (xk & carryIn) | (yk & carryIn);
            sum |= xk ^ yk ^ carryIn;

            carryIn = carryOut << 1;
            k <<= 1;
            tempX >>= 1;
            tempY >>= 1;
        }

        sum = sum | carryIn;

        return sum;
    }
}
