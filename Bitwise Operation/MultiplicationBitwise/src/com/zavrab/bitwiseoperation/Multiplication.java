package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/12/16.
 */
public class Multiplication {

    public static long multiply(long x, long y) {
        long sum = 0;
        while(x != 0) {
            //Examines each bit of x
            if((x & 1) != 0) {
                sum = add(sum, y);
            }
            x >>= 1;
            y <<= 1;
        }
        return sum;
    }

    private static long add(long x, long y) {
        long tempX = x, tempY = y, carryIn = 0, sum = 0, k = 1;
        while(tempX != 0 || tempY != 0) {
            //Find if x and y is 1
            long xk = (x & k), yk = (y & k);
            //CarryOut is > 0 if at least two bits are 1
            long carryOut = (xk & yk) | (xk & carryIn) | (yk & carryIn);

            //Sum all thre bits e.g. 1 1 1 = 1, 1 0 1 = 0, 1 1 0 = 0
            sum |= xk ^ yk ^ carryIn;

            carryIn = carryOut << 1; // forward carryOut for next left bit sum
            k <<= 1;
            tempX >>= 1;
            tempY >>= 1;
        }
        sum = sum | carryIn;
        return sum;
    }
}
