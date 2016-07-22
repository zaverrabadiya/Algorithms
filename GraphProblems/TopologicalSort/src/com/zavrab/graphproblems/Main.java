package com.zavrab.graphproblems;

// http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph();
        //String[] words = new String[] {"caa", "aaa", "aab"}; // => c a b
        String[] words = {"baa", "abcd", "abca", "cab", "cad"}; // => b d a c

        graph.createGraph(words);
        graph.topologicalSort();
        graph.printTopologicalOrder();
    }
}
