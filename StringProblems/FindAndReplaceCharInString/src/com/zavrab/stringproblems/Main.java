package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        String input = "aabb";
        String result = addRemoveCharacters(input);
        System.out.print(result);
    }

    public static String addRemoveCharacters(String inStr) {
        int len = findRequiredLength(inStr);
        char[] chars = new char[len];

        int i = 0, j = 0;

        while (i < inStr.length()) {
            if (inStr.charAt(i) == 'a') {
                chars[j++] = 'z';
                chars[j++] = 'z';
                i++;
            } else if (inStr.charAt(i) != 'b') {
                chars[j++] = inStr.charAt(i++);
            } else {
                i++;
            }
        }

        return new String(chars);
    }

    private static int findRequiredLength(String inStr) {
        int len = 0;
        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == 'a') {
                len += 2;
            } else if (inStr.charAt(i) != 'b') {
                len++;
            }
        }
        return len;
    }
}
