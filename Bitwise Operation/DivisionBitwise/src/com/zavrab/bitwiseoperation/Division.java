package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/13/16.
 */
public class Division {
    public static long divide(long x, long y) {
        long result = 0;
        int power = 32;
        long yPower = y << power;

        while(x >= y) {

            while(yPower > x) {
                yPower >>= 1;
                --power;
            }
            result |= 1L << power;
            x -= yPower;
        }
        return result;
    }
}
