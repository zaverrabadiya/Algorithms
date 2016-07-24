package com.zavrab.graphproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void createTrie(String strText) {
        String[] words = strText.split(" ");

        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
    }

    public List<Integer> getItem(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode node = current.children.get(c);
            if (node == null) {
                return null;
            }
            current = node;
        }

        return current.positions;
    }

    public boolean contains(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode node = current.children.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }

        return current.endOfWord;
    }

    public void printPositions(String word) {
        List<Integer> positions = getItem(word);

        if (positions != null) {
            System.out.println("Trie - Posting list: ");

            for (Integer pos : positions) {
                System.out.print(pos + " ");
            }
        } else {
            System.out.println("Term does not exist!");
        }
    }

    private void insert(String word, int pos) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            TrieNode node = current.children.get(c);
            if (node == null) {
                node = new TrieNode();
                current.children.put(c, node);
            }
            current = node;
        }
        current.endOfWord = true;
        current.positions.add(pos);
    }

    private class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;
        List<Integer> positions;

        TrieNode() {
            children = new HashMap<Character, TrieNode>();
            endOfWord = false;
            positions = new ArrayList<Integer>();
        }
    }
}
