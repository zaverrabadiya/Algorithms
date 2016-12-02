package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/10/16.
 */
public class ReverseBits {

    private static int length = 1 << 16;
    private static long[] precomputedReverse = new long[length];

    public static long reverseBits(int x) {
        //Swap LSB with MSB
        //Need to do this only through half way e.g. 8 bits- i=0 to 3 and j= 7 to 4
        //When x is 16 bits i= 0 to 7 and j= 15 to 8
        for (int i = 0, j = 15; i < j; i++, j--) {
            if(((x >>> i) & 1) != ((x >>> j) & 1)) { // Check if MSB and LSB bits are not same
                long bitMask = (1 << i) | (1 << j); // Set 1 to MSB and LSB
                x ^= bitMask;   // XORing x to bitmask will revert the original bit ie 1 to 0 and 0 to 1
            }
        }
        return x;
    }

    //Using look up table
    public static long reverse64Bits(long x) {
        int BIT_MASK = (1 << 16) - 1;
        int WORD_SIZE = 16;
        createComputedTable();

        return  (precomputedReverse[(int)(x & BIT_MASK)] << (3 * WORD_SIZE))
                | (precomputedReverse[(int)((x >>> WORD_SIZE) & BIT_MASK)] << (2 * WORD_SIZE))
                | (precomputedReverse[(int)((x >>> (2 * WORD_SIZE)) & BIT_MASK)] << WORD_SIZE)
                | precomputedReverse[(int)((x >>> (3 * WORD_SIZE)) & BIT_MASK)];
    }

    private static void createComputedTable() {
        for(int i = 0; i < length; i++) {
            precomputedReverse[i] = reverseBits(i);
        }
    }
}
