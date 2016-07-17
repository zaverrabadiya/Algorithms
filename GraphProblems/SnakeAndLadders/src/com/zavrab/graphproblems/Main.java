package com.zavrab.graphproblems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//http://www.geeksforgeeks.org/snake-ladder-problem-2/

public class Main {

    public static void main(String[] args) {
        Node result = getMinDiceThrows();
        System.out.println("Min dice throw is: " + result.diceThrows);

        System.out.println("\nMoves: ");
        for (Integer move : result.moves) {
            System.out.print(move + " ");
        }

        System.out.println("\n\nPath: ");
        for (Integer path : result.path) {
            System.out.print(path + " ");
        }
    }

    public static Node getMinDiceThrows() {
        int[] moves = constructBoard();
        int n = moves.length;
        boolean[] visited = new boolean[n];
        Queue<Node> queue = new ArrayDeque<Node>();

        Node start = new Node();
        queue.add(start);
        visited[0] = true;
        Node curr = start;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            int v = curr.vertex;

            if (v == n - 1) {
                break;
            }

            for (int j = v + 1; j <= (v + 6) && j < n ; j++) {
                if (!visited[j]) {
                    Node node = new Node();
                    node.diceThrows = curr.diceThrows + 1;
                    node.path.addAll(curr.path);
                    node.path.add(j);

                    node.moves.addAll(curr.moves);
                    node.moves.add(j - v);

                    visited[j] = true;

                    if (moves[j] != -1) {
                        node.vertex = moves[j];
                        node.path.add(moves[j]);
                    } else {
                        node.vertex = j;

                    }

                    queue.add(node);
                }
            }
        }
        return curr;
    }

    private static int[] constructBoard() {
        int[] moves = new int[31];

        for (int i = 0; i < moves.length; i++)
            moves[i] = -1;

        // Ladders
        moves[3] = 22;
        moves[5] = 8;
        moves[11] = 26;
        moves[20] = 29;

        // Snakes
        moves[27] = 1;
        moves[21] = 9;
        moves[17] = 4;
        moves[19] = 7;

        return moves;
    }

    private static class Node {
        int vertex = 0;
        int diceThrows = 0;
        List<Integer> path = new ArrayList<Integer>();
        List<Integer> moves = new ArrayList<Integer>();
    }
}
