package com.zavrab.graphproblems;

import java.util.*;

public class Solution {

    private static HashSet<String> visited = new HashSet<String>();
    private static HashSet<String> alive = new HashSet<String>();

    public static void main(String[] args) {
        Map<String, List<String>> nodes = createGraph();
        System.out.print("Is graph cyclic: " + isCyclic(nodes));
    }

    public static boolean isCyclic(Map<String, List<String>> nodes) {
        for (String node: nodes.keySet()) {
            if (isCyclic(node, nodes)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isCyclic(String node, Map<String, List<String>> nodes) {
        visited.add(node);
        alive.add(node);

        if (nodes.get(node) != null && nodes.get(node).size() > 0) {
            for (String n : nodes.get(node)) {
                if (!visited.contains(n)) {
                    if (isCyclic(n, nodes)) {
                        return true;
                    }
                } else if (alive.contains(n)) {
                    return true;
                }
            }
        }
        alive.remove(node);
        return false;
    }

    private static Map<String, List<String>> createGraph() {
        Map<String, List<String>> nodes = new HashMap<String, List<String>>();

        List<String> neighbors = new ArrayList<String>();
        neighbors.add("b");
        nodes.put("a", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("c");
        neighbors.add("1");
        nodes.put("b", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("d");
        nodes.put("c", neighbors);

        neighbors = new ArrayList<String>();
        neighbors.add("a");
        nodes.put("d", neighbors);

        return nodes;
    }
}
