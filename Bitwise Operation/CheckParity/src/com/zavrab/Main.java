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
    }

    public static short checkParity(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            x &= x - 1; //Drops the lowest set bit(1) of x
        }
        return result;
    }
}
