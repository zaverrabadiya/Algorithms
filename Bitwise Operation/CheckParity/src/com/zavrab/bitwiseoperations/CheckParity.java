package com.zavrab.bitwiseoperations;
/**
 * @author Zaver R
 * Date: Feb 8, 2016
 *
 * Count number of 1's and return 1 if its odd else 0
 * Check parity:
 * e.g. 10101 (21) should return 1
 *      10100 (20) should return 0
 */
public class CheckParity {

    public static void main(String[] args) {

        long x = 21L;
        System.out.format("Parity of %d is: %d",x, checkParity(x));

        x = 20L;
        System.out.format("\nParity of %d is: %d",x, checkParity(x));

        //Faster way to check parity for 64 bit word
        x = 21L;
        System.out.format("\n(Faster way) Parity of %d is: %d",x, parityTable(x));

        x = 20L;
        System.out.format("\n(Faster way) Parity of %d is: %d",x, parityTable(x));
    }

    public static short checkParity(long x) {
        short result = 0;

        while (x != 0) {
            result ^= 1;
            x &= x - 1; //Drops the lowest set bit(1) of x
        }

        return result;
    }

    // another very fast implementation, uses lookup-table
    private static short[] precomputedParity;

    static {
        precomputedParity = new short[1 << 16];

        for (int i = 0; i < (1 << 16); ++i) {
            precomputedParity[i] = checkParity(i);
        }
    }

    public static short parityTable(long x) {
        final int WORD_SIZE = 16;
        final int BIT_MASK = (1 << 16) - 1;

        // Check the parity of last 16 bits of total 64 bits
        short result = precomputedParity[(int) (x & BIT_MASK)];

        // Remove last 16 bits since they are already computed
        x = x >>> WORD_SIZE;
        result ^= precomputedParity[(int) (x) & BIT_MASK];

        // Same as above
        x = x >>> WORD_SIZE;
        result ^= precomputedParity[(int) (x) & BIT_MASK];

        // Same as above
        x = x >>> WORD_SIZE;
        result ^= precomputedParity[(int) (x) & BIT_MASK];

        return result;
    }
}
