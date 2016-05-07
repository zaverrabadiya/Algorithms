package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {
        // e.g.
        // "I will do it." => "it. do will I"
        // "word1;[ ]word2." => "word2.[ ];word1" : '[ ]' is space

        String input = "I will do it.";
        String result = reverseWords(input);
        System.out.print(result);
    }

    public static String reverseWords(String inStr) {
        String reversed = reverseString(inStr);
        String reversedWords = "";
        int i = 0;
        while (i < reversed.length()) {
            String word = "";
            while (i < reversed.length() && reversed.charAt(i) != ' ' && reversed.charAt(i) != ']') {
                word += reversed.charAt(i++);
            }

            reversedWords +=  reverseString(word);
            word = "";
            while (i < reversed.length() && (reversed.charAt(i) == ' ' || reversed.charAt(i) == '[' || reversed.charAt(i) == ']')) {
                word += reversed.charAt(i++);
            }
            reversedWords += reverseString(word);
        }
        return reversedWords;
    }

    private static String reverseString(String inStr) {
        String reversed = "";
        for (int i = inStr.length() - 1; i >=0; i--) {
            reversed += inStr.charAt(i);
        }
        return reversed;
    }
}
