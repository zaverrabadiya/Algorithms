package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/11/16.
 */
public class FindIntWithSameWeight {

    //Finds closet int with same weight(same bit count) i.e. 1011 = 3 bits should return 1101 = 3 bits
    //(X - result) should be minimum difference
    public static long findClosestIntWithSameBitCount(long x) {
        for (int i = 0; i <=63; i++) {
            //Check if LSB differs
            if(((x >> i) & 1) != ((x >> (i+1)) & 1)){
                //Swap bits- i and (i+1)
                x ^= (1 << i) | (1 << (i + 1));
                return x;
            }
        }
        throw new IllegalArgumentException("All bits are 0 or 1");
    }
}
