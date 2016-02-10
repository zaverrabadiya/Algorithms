package com.zavrab;
/*
 * @author Zaver R
 * Date: Feb 8, 2016
*/
public class Main {

    public static void main(String[] args) {
        //Count number of 1's and return 1 if its odd else 0
        //Check parity of 1011 (11) should return 1
        //10100 (20) should return 0
        System.out.println("Parity is: " + checkParity(11));
        //Faster way to check parity for 64 bit word
        //System.out.println("Parity is: " + parityTable(11));
    }

    public static short checkParity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            x &= x - 1; //Drops the lowest set bit(1) of x
        }
        return result;
    }

    // another very fast implementation, uses lookuptable
    private static short[] precomputedParity;

    static {
        precomputedParity = new short[1 << 16];
        for (int i = 0; i < (1 << 16); ++i) {
            precomputedParity[i] = checkParity(i);
        }
    }

    public static short parityTable(long x) {
        final int WORD_SIZE = 16;
        final int BIT_MASK = 0xFFFF;
        // final int BIT_MASK = 0xFF;
        // clang-format off
        ///*
        int offset = WORD_SIZE;
        short result = precomputedParity[(int) (x & BIT_MASK)];
        x = x >>> offset;
        result ^= precomputedParity[(int) (x) & BIT_MASK];
        x = x >>> offset;
        result ^= precomputedParity[(int) (x) & BIT_MASK];
        x = x >>> offset;
        result ^= precomputedParity[(int) (x) & BIT_MASK];
        return result;
    }
}
