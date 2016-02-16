package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/15/16.
 */
public class Power {
    public static double power(double x, int y) {
        double result = 1.0;
        long power = y;
        //When y is negative
        if(y < 0) {
            power = -power;
            x = 1.0 / x;
        }

        while(power > 0) {
            if((power & 1) != 0) {
                result *= x;
            }
            x *= x;
            power >>>= 1;
        }
        return result;
    }
}
