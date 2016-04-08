package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        //e.g.
        // "123" = 123
        // "    - 123" = -123
        //"+123x2" = 123
        //"abc" = 0

        String s = "-123";
        System.out.println("Integral: " + atoi(s));
    }

    static int atoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        String nonWhiteSpaceStr = removeWhiteSpace(s);
        if (nonWhiteSpaceStr.isEmpty()) {
            return 0;
        }

        int sign = 1, i = 0;
        if (nonWhiteSpaceStr.charAt(0) == '-') {
            sign = -1;
            i = 1;
        } else if (nonWhiteSpaceStr.charAt(0) == '+') {
            i = 1;
        }

        int number = 0;
        while (i < nonWhiteSpaceStr.length() && isDigit(nonWhiteSpaceStr.charAt(i))) {
            number *= 10;
            number += getDigit(nonWhiteSpaceStr.charAt(i++));
        }
        return number >= Integer.MAX_VALUE? Integer.MAX_VALUE : number * sign;
    }

    static String removeWhiteSpace(String s) {
        int i = 0;
        String newString = "";
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (c == '+' || c == '-') {
                    newString += c;
                } else {
                    newString += s.substring(i);
                    return newString;
                }
            }
            i++;
        }

        return newString;
    }

    static boolean isDigit(char c) {
        int digit = getDigit(c);
        return  digit >= 0 && digit <= 9;
    }

    static int getDigit(char c) {
        return c - '0';
    }
}
