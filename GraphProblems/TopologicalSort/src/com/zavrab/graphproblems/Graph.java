package com.zavrab.graphproblems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ZaverR on 7/21/16.
 */
public class Graph {

    private List<Integer>[] vertices;
    private Stack<Integer> topoStack;

    public void createGraph(String[] words) {
        int n = words.length;
        vertices = new ArrayList[26];

        for (int i = 0; i < n - 1 ; i++) {
            String word1 = words[i], word2 = words[i + 1];

            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                int char1Ascii = word1.charAt(j) - 'a';
                int char2Ascii = word2.charAt(j) - 'a';

                if (char1Ascii != char2Ascii) {
                    if (vertices[char1Ascii] == null) {
                        // Create edges for this vertex
                        vertices[char1Ascii] = new ArrayList<Integer>();
                    }

                    // Add edge to the vertex
                    vertices[char1Ascii].add(char2Ascii);
                    break;
                }
            }
        }
    }

    public void topologicalSort() {
        topoStack = new Stack<Integer>();
        boolean[] visited = new boolean[vertices.length];

        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != null && !visited[i]) {
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

        List<Integer> neighbors = vertices[i];

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
