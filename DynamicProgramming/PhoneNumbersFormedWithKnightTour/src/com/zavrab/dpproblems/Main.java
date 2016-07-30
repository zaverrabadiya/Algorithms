package com.zavrab.dpproblems;

public class Main {

    public static void main(String[] args) {
        int startDigit = 1, length = 10;
        System.out.format("Starting number: %d length: %d Total number formed: %d ", startDigit, length, Solution.numPhoneNumbers(startDigit, length));

        startDigit = 6; length = 20;
        System.out.format("\n\nStarting number: %d length: %d Total number formed: %d ", startDigit, length, Solution.numPhoneNumbers(startDigit, length));

        startDigit = 1; length = 5;
        System.out.format("\n\nStarting number: %d length: %d Total number formed: %d ", startDigit, length, Solution.numPhoneNumbers(startDigit, length));

        startDigit = 5; length = 5;
        System.out.format("\n\nStarting number: %d length: %d Total number formed: %d ", startDigit, length, Solution.numPhoneNumbers(startDigit, length));
    }
}
