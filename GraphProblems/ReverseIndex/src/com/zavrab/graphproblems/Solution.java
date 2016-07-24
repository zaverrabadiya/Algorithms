package com.zavrab.graphproblems;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
// http://www.ardendertat.com/2011/12/20/programming-interview-questions-23-find-word-positions-in-text/
public class Solution {

    private static Hashtable<String, List<Integer>> index;

    public static void main(String[] args) {
        String text = "us use uses used user users using useful username user utah";
        String word = "user";

        Trie trie = new Trie();
        trie.createTrie(text);
        trie.printPositions(word);

        //Using HashTable
        createIndex(text);
        printPositions(word);
    }

    /**
     * Using HashTable
     * */
    public static void createIndex(String text) {
        String[] words = text.split(" ");
        index = new Hashtable<String, List<Integer>>();

        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
    }

    private static void insert(String word, int pos) {
        if (index.get(word) == null) {
            index.put(word, new ArrayList<Integer>());
        }
        index.get(word).add(pos);
    }

    private static void printPositions(String word) {
        List<Integer> positions = index.get(word);

        if (positions != null) {
            System.out.println("\n\nHashTable - Posting list: ");

            for (Integer pos : positions) {
                System.out.print(pos + " ");
            }
        } else {
            System.out.println("Term does not exist!");
        }
    }
}
