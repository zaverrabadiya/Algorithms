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

        String I = "112233", A = "123", B = "123";
        System.out.print("Result: " + checkInterleaving(I, A, B));
    }

    public static boolean checkInterleaving(String I, String A, String B) {
        if (A.length() + B.length() != I.length()) {
            return false;
        }

        int a = 0, b = 0;

        for (int i = 0; i < I.length(); i++) {
            if (a < A.length() && I.charAt(i) == A.charAt(a)) {
                a++;
            } else if (b < B.length() && I.charAt(i) == B.charAt(b)) {
                b++;
            } else {
                return false;
            }
        }
        return true;
    }
}
