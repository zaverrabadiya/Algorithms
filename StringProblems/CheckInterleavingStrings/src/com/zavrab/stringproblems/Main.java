package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        // Given three strings I, A and B.
        // Check if I is an interleaving of A and B
        // I is interleaving of A and B, if it contains all characters of A and B and order of all characters in individual string is preserved

        //e.g.
        // I = "112233", A = "123", B = "123" => true
        // I = "1234", A = "123", B = "123" => false
        // I = "112233", A = "123", B = "132" => false
        // I = "123456", A = "123456", B = "" => true
        // I = "123456", A = "" B = "123456" => true
        // I = "adab", A = ab" B =ad" => true

        String I = "adab", A = "ab", B = "ad";
        System.out.print("Result: " + isInterleaved(I, A, B));

        //System.out.print("Result: " + checkInterleaving(I, A, B));
    }

    public static boolean isInterleaved(String I, String A, String B) {
        return isInterleaved(0, 0, 0, A, B, I);
    }

    private static boolean isInterleaved(int i, int a, int b, String A, String B, String I) {
        if (a == A.length() && b == B.length() && i == I.length()) {
            return true;
        }

        boolean aMatches = false, bMatches = false;

        if (a < A.length() && I.charAt(i) == A.charAt(a)) {
            aMatches = isInterleaved(i + 1, a + 1, b, A, B, I);
        }

        if (b < B.length() && I.charAt(i) == B.charAt(b)) {
            bMatches = isInterleaved(i + 1, a, b + 1, A, B, I);
        }

        return aMatches || bMatches;
    }

    //NOT SO OPTIMIZED
    public static boolean checkInterleaving(String I, String A, String B) {
        if (A.length() + B.length() != I.length()) {
            return false;
        }
        if (A.equals("") && B.length() > 0) {
            return B.equals(I);
        } else if (B.equals("") && A.length() > 0){
            return A.equals(I);
        } else {
            return checkInterleaving(I, A, B, 0, 0) || checkInterleaving(I, B, A, 0, 0);
        }
    }

    private static boolean checkInterleaving(String I, String a, String b, int i, int j) {
        if ( i == a.length() || j == b.length()) {
            return false;
        }

        String result = a.substring(0, i + 1) + b.substring(0, j + 1) + a.substring(i+1) + b.substring(j+1);
        if (result.equals(I)) {
            return true;
        }

        return checkInterleaving(I, a, b, i, j + 1) ||
                checkInterleaving(I, a, b, i + 1, j);
    }
}
