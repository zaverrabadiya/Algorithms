package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {

        String inStr = "Google worked";
        System.out.println("String sinusoidally with rows 3\n");
        printStringSinusoidally(inStr);

        System.out.println("\nString sinusoidally with rows 4 \n");
        inStr = "abcde fghi jklmno pqrst";
        printStringSinusoidally(inStr);

        System.out.println("\nString sinusoidally with rows 5");
        inStr = "abcde fghi jklmno pqrstu v wxy z";
        printStringSinusoidally(inStr);
    }

    public static void printStringSinusoidally(String s) {
        int rows = findNumberOfRows(s);
        int totalSpaces = ((rows - 1) * 2) - 1;
        int prevSpaces = totalSpaces;

        for (int row = 0; row < rows; row++) {
            //Initial spaces
            for (int j = 0; j < row; j++) {
                System.out.print(" ");
            }

            int spaces = totalSpaces;
            if (prevSpaces > 0){
                spaces = prevSpaces;
                prevSpaces -= 2;
            }

            int i = row;
            while (i < s.length()) {
                char c = s.charAt(i) == ' ' ? '~' : s.charAt(i);
                System.out.print(c);

                for (int j = 0; j < spaces; j++) {
                    System.out.print(" ");
                }

                i += spaces + 1;
                if (spaces != totalSpaces) {
                    spaces = (totalSpaces - spaces) - 1;
                }
            }
            System.out.println();
        }
    }

    private static int findNumberOfRows(String s) {
        int i = 0;
        while ((++i * i) <= s.length());

        return i - 1;
    }
}
