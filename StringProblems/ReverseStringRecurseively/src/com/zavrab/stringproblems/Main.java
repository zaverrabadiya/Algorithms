package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        String input = "abcd";
        System.out.println("Reversed string: " + reverseString(input));
    }

    public static String reverseString(String s) {
        if (s.length() == 0) {
            return "";
        }
        char last = s.charAt(s.length() - 1);
        String reversed = reverseString(s.substring(0, s.length() - 1)); //substring endIndex is exclusive
        return last + reversed;
    }
}
