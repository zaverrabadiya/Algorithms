package com.zavrab.graphproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ZaverR on 7/21/16.
 */
public class Graph {

    private List<Integer>[] edges;
    private Stack<Integer> topoStack;

    public void createGraph(String[] words) {
        int n = words.length;
        edges = new ArrayList[26];

        for (int i = 0; i < n - 1 ; i++) {
            String word1 = words[i], word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                int char1Ascii = word1.charAt(j) - 'a';
                int char2Ascii = word2.charAt(j) - 'a';

                if (char1Ascii != char2Ascii) {
                    if (edges[char1Ascii] == null) {
                        edges[char1Ascii] = new ArrayList<Integer>();
                    }

                    edges[char1Ascii].add(char2Ascii);
                    break;
                }
            }
        }
    }

    public void topologicalSort() {
        topoStack = new Stack<Integer>();
        boolean[] visited = new boolean[edges.length];

        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != null && !visited[i]) {
                topologicalSortInternal(i, visited);
            }
        }
    }

    public void printTopologicalOrder() {
        System.out.println("Topological order: ");
        while (!topoStack.isEmpty()) {
            char c = (char)(topoStack.pop() + 'a');
            System.out.print(c + " ");
        }
    }

    private void topologicalSortInternal(int i, boolean[] visited){
        visited[i] = true;

        List<Integer> neighbors = edges[i];

        if (neighbors != null) {
            for (Integer n : neighbors) {
                if (!visited[n]) {
                    topologicalSortInternal(n, visited);
                }
            }
        }
        topoStack.push(i);
    }
}
