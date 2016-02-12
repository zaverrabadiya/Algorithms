package com.zavrab.bitwiseoperation;

/**
 * Created by Zaver R on 2/11/16.
 */

public class Main {

    public static void main(String[] args) {

        //Input  1011 :11
        //Output 1101 :13

        //Input  1010 :10
        //Output 1001 :9
        System.out.println("Closest int with same weight is: " + FindIntWithSameWeight.findClosestIntWithSameBitCount(10));
    }
}
