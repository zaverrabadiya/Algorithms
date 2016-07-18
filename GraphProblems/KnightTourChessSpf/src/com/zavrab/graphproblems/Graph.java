package com.zavrab.graphproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by ZaverR on 7/17/16.
 */
public class Graph {


    public HashMap<Integer, List<Integer>> createGraph(int boardSize) {
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

        for (int x = 0; x < boardSize; x++) {
            for (int y = 0; y < boardSize; y++) {
                int nodeId = coordinatesToNodeId(x, y, boardSize);
                List<Integer> nextPositions = genLegalMoves(x, y, boardSize);
                graph.put(nodeId, nextPositions);
            }
        }

        return graph;
    }

    public static int coordinatesToNodeId(int x, int y, int boardSize) {
        return (x * boardSize) + y;
    }

    public static int[] nodeIdToCoordinates(int nodeId, int boardSize) {
        int[] coordinates = new int[2];
        coordinates[0] = nodeId / boardSize;
        coordinates[1] = nodeId % boardSize;
        return coordinates;
    }

    private List<Integer> genLegalMoves(int x, int y, int boardSize) {
        List<Integer> moves = new ArrayList<Integer>();
        int[][] legalMoves = new int[][]{
                {-1, -2}, {-1, 2}, {-2, -1}, {-2, 1},
                {1, -2}, {1, 2}, {2, -1}, {2, 1}};

        for (int i = 0; i < legalMoves.length; i++) {
            int newX = x + legalMoves[i][0];
            int newY = y + legalMoves[i][1];

            if (isLegalCoordinates(newX, newY, boardSize)) {
                int nodeId = coordinatesToNodeId(newX, newY, boardSize);
                moves.add(nodeId);
            }
        }
        return moves;
    }

    private boolean isLegalCoordinates(int x, int y, int boardSize) {
        return (x >= 0 && x < boardSize) && (y >= 0 && y < boardSize);
    }


}
