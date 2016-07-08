package com.zavrab.stringproblems;

import java.util.HashMap;
import java.util.Map;

public class SuffixTree {

    private final TrieNode root;

    public SuffixTree() {
        root = new TrieNode();
    }

    public void insert(String inStr) {
        for (int i = inStr.length() - 1; i >=0; i--) {
            insertInternal(inStr.substring(i));
        }
    }
    private void insertInternal(String word) {
        TrieNode current = root;
        int i = 0;

        for (Map.Entry<String, TrieNode> childNode : current.children.entrySet() ) {
            String key = childNode.getKey();
            i = 0;

            while ((i < word.length() && i < key.length()) && key.charAt(i) == word.charAt(i)) {
                i++;
            }

            if (i > 0) {
                forkWord(current, key, word, i);
                break;
            }
        }

        if (i == 0) {
            TrieNode newNode = new TrieNode();
            newNode.endOfWord = true;
            current.children.put(word, newNode);
        }
    }

    public boolean search(String word) {
        TrieNode current = root;
        int startIndx = 0, matchIndx = -1;
        for (int i = 0; i < word.length(); i++) {
            TrieNode node = current.children.get(word.substring(startIndx, i+1));

            if (node != null) {
                current = node;
                startIndx = i + 1;
                matchIndx = i;
            }
        }

        return matchIndx == word.length() - 1 && current.endOfWord;
    }

    private void forkWord(TrieNode node, String key, String word, int i) {
        TrieNode currentNode = node.children.get(key);

        if (i > 1) {
            TrieNode forkNode = new TrieNode();
            forkNode.children.put(key.substring(i), currentNode);
            node.children.remove(key);
            node.children.put(key.substring(0, i), forkNode);
        }

        TrieNode newNode = new TrieNode();
        newNode.endOfWord = true;

        TrieNode nodeToAddIn = node.children.get(key.substring(0, i));
        nodeToAddIn.children.put(word.substring(i), newNode);
    }

    private class TrieNode {
        Map<String, TrieNode> children;
        boolean endOfWord;

        TrieNode() {
            children = new HashMap<String, TrieNode>();
            endOfWord = false;
        }
    }
}
