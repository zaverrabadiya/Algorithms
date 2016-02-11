package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/10/16.
 */

public class Main {

    public static void main(String[] args) {
        //Input 43690  : 1010 1010 1010 1010
        //Output 21845 : 0101 0101 0101 0101
        System.out.println("Number after bits reversed: " + ReverseBits.reverseBits(43690));

        //Input  0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 1100 1110 = 206
        //Output 0111 0011 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 0000 = 8286623314361712640
        System.out.println("Number after bits reversed: " + ReverseBits.reverse64Bits(206));
    }


}

