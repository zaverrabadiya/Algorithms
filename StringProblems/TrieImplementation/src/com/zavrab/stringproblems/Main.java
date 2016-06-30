package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {

        String inStr = "Hello Friend Help";
	    Trie trie = new Trie();
        String[] words = inStr.split(" ");

        for (String word : words) {
            trie.insert(word);
        }

        String word = "Help";
        System.out.format("String=> %s\nWord=> %s \nFound: %s \n",inStr, word, trie.search(word));

        System.out.format("\nWord: \"%s\" deleted= %s \n", word, trie.delete(word));
    }
}
