package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {

        String inStr = "Google worked";
        //String inStr = "Hello world!";
        printStringSinusoidally(inStr);
    }

    public static void printStringSinusoidally(String s) {
        if (s == null || s.length() < 3) {
            return;
        }

        int spaceCount = 2, startPos = (s.length() % 2 + 1), i = startPos;
        while (i < s.length()) {
            for (int j = 1; j <= spaceCount; j++) {
                System.out.print(" ");
            }
            char c = s.charAt(i) == ' ' ? '~' : s.charAt(i);
            System.out.print(c);
            spaceCount = 3;
            i += 4;
        }
        System.out.println();

        i = --startPos;
        spaceCount = 1;
        while (i < s.length()) {
            for (int j = 1; j <= spaceCount; j++) {
                System.out.print(" ");
            }
            char c = s.charAt(i) == ' ' ? '~' : s.charAt(i);
            System.out.print(c);
            i += 2;
        }
        System.out.println();

        i = --startPos;
        spaceCount = 0;
        while (i < s.length()) {
            for (int j = 1; j <= spaceCount; j++) {
                System.out.print(" ");
            }
            char c = ' ';
            if (i >= 0) {
                c = s.charAt(i) == ' ' ? '~' : s.charAt(i);
            }
            System.out.print(c);
            spaceCount = 3;
            i += 4;
        }
    }
}
