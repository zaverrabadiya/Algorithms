package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        permute("abcd".toCharArray(), 0);
    }

    public static void permute(char[] s, int i) {

        if (i == s.length - 1) {
            System.out.println(s);
            return;
        }
        for (int j = i; j < s.length; j++) {
            swap(s, i, j);
            permute(s, i + 1);
            swap(s, j, i);
        }
    }

    private static void swap(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;
    }
}
