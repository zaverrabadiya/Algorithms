package com.zavrab.bitwiseoperation;

/*
 * @author Zaver R
 * Date: Feb 9, 2016
*/

public class Main {

    public static void main(String[] args) {

        //Input  0101 1101 (93) and i = 1, j = 6
        //Output 0001 1111 (31)
        System.out.println("Int after swapping bits: " + swapBits(93, 1, 6));
    }

    public static long swapBits(long x, int i, int j) {
        //Extract ith and jth bits and see if they are different
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            //ith and jth bits are different
            //set 1 to ith and jth index and add them to form bitmastk
            long bitMask = (1 << i) | (1 << j); //i = 1 and j = 6; bitMask = 0100 0010

            //X ^ 1 = 1 when X = 0 and its 0 when X = 1, so
            x ^= bitMask;
        }
        return x;
    }
}
