package com.zavrab.graphproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// http://interactivepython.org/runestone/static/pythonds/Graphs/TheKnightsTourProblem.html
// http://stackoverflow.com/questions/2339101/knights-shortest-path-chess-question
public class Main {

    private static HashMap<Integer, List<Integer>> vertices;
    private static List<Integer> shortestPath;
    private static List<Integer> path;
    private static boolean[] visited;

    public static void main(String[] args) {
        int boardSize = 8;
        Graph graph = new Graph();
        vertices = graph.createGraph(boardSize);

        // Knight tour shortest path call
        // Input Source cell: x1, y1 and  Destination cell: x2, y2
        // i.e. source: 0, 0 and destination: 2, 4
        knightTourPath(0, 0, 2, 4, boardSize);
    }

    public static void knightTourPath(int x1, int y1, int x2, int y2, int boardSize) {
        visited = new boolean[vertices.size()];
        path = new ArrayList<Integer>();

        int src = Graph.coordinatesToNodeId(x1, y1, boardSize);
        int dest = Graph.coordinatesToNodeId(x2, y2, boardSize);

        knightTourPathInternal(src, dest);

        if (shortestPath.size() > 0) {
            System.out.format("Shortest path for knight tour from {%d,%d} to {%d,%d} is:\n", x1, y1, x2, y2);
            for (Integer v : shortestPath) {
                int[] coordinates = Graph.nodeIdToCoordinates(v, boardSize);
                System.out.format("{%d,%d} ", coordinates[0], coordinates[1]);
            }
        }
    }

    private static void knightTourPathInternal(int node, int dest) {
        path.add(node);

        if (node == dest){
            if (shortestPath == null || path.size() < shortestPath.size()) {
                shortestPath = new ArrayList<Integer>(path);
            }
            return;
        }

        if (!visited[node]) {
            visited[node] = true;
            List<Integer> neighbors = vertices.get(node);

            for (int i = 0; i < neighbors.size(); i++) {
                if (!visited[neighbors.get(i)]) {

                    knightTourPathInternal(neighbors.get(i), dest);

                    // Remove last node when backtracking
                    if (path.size() > 0) {
                        path.remove(path.size() - 1);
                    }
                }
            }
        }
    }
}
