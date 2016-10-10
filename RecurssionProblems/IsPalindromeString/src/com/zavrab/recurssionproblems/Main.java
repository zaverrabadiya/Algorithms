package com.zavrab.recurssionproblems;

public class Main {

    public static void main(String[] args) {

        //e.g.
        //"racecar" = true
        //"-racecar" = true
        //"racecar!" = true
        //"RaceCar" = true
        //"Race car" = true
        //"test" = false
        //"a" = true

        String s = "racecar";
        System.out.println("Is Palindrome: " + isPalindrome(s));
    }

    public static boolean isPalindrome(String strInput) {
        if (strInput.length() <= 1) {
            return true;
        }

        String first = strInput.substring(0, 1);
        String last = strInput.substring(strInput.length() - 1);

        if (first.equalsIgnoreCase(last)) {
            return isPalindrome(strInput.substring(1, strInput.length() - 1));
        }

        if (ignore(first.charAt(0))) {
            return isPalindrome(strInput.substring(1));
        }
        else if (ignore(last.charAt(0))) {
            return isPalindrome(strInput.substring(0, strInput.length() -1));
        }

        return false;
    }

    private static boolean ignore(char c) {
        return (isPunctuation(c) || c == ' ');
    }

    private static boolean isPunctuation(char c) {
        return c == '.' || c == ',' || c == '?' || c == '!' || c =='\'' || c == ';' || c == ':' || c == '"';
    }
}
