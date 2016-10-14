package com.zavrab.graphproblems;

import java.util.ArrayDeque;
import java.util.Queue;

public class FindMinPathInMaze {

    public static void main(String[] args) {
        int[][] maze = new int[][] {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {1, 0, 0, 0}
        };

        int sx = 2, sy = 3, dx = 0, dy = 2;

        System.out.print(findMinPathInMaze(maze, sx, sy, dx, dy));
    }

    public static int findMinPathInMaze(int[][] maze, int sx, int sy, int dx, int dy) {
        if (maze == null || maze.length == 0) {
            return -1;
        }

        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<Node> queue = new ArrayDeque<Node>();
        // Valid move from current cell
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        visited[sx][sy] = true;
        queue.add(new Node(sx, sy, 1));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == dx && curr.y == dy) {
                return curr.distance;
            }

            // BFS all valid moves from current cell
            for (int[] aDir : dir) {
                int row = curr.x + aDir[0];
                int col = curr.y + aDir[1];

                if (isValid(row, col, n, m) && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.add(new Node(row, col, curr.distance + 1));
                }
            }
        }

        return -1;
    }

    private static boolean isValid(int row, int col, int n, int m) {
        return (row >= 0) && (row < n) && (col >= 0) && (col < m);
    }

    private static class Node {
        int x;
        int y;
        int distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
