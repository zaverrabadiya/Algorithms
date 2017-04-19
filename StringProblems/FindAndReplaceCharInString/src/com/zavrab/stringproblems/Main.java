package com.zavrab.stringproblems;

/**
 * Replace 'a' with 'zz' and remove 'b' rest characters stay as it is
 *
 * */
public class Main {

    public static void main(String[] args) {
        String input = "aabcd";
        String result = addRemoveCharacters(input);
        System.out.print(result);
    }

    public static String addRemoveCharacters(String inStr) {
        int len = findRequiredLength(inStr);
        char[] chars = new char[len];

        int j = 0;

        for (int i = 0; i < inStr.length(); i++) {
            if (inStr.charAt(i) == 'a') {
                chars[j++] = 'z';
                chars[j++] = 'z';
            } else if (inStr.charAt(i) != 'b') {
                chars[j++] = inStr.charAt(i);
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
