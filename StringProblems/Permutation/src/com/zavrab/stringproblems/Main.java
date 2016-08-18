package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        permute("abcd");
    }

    public static void permute(String str) {
        permute(str.toCharArray(), 0);
    }

    private static void permute(char[] s, int i) {
        if (i == s.length - 1) {
            System.out.println(s);
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
