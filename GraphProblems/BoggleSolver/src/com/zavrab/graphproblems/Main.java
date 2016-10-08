package com.zavrab.graphproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    //TODO Create graph same as board but with 8 edges i.e. b[1][1] -> i-1,j-1=true, i-1=true, j-1=true, j+1=true etc...
        String[] dictionary = {"Geek", "Quiz"};
        String[][] boggle = {
                {"G", "I", "Z"},
                {"U", "E", "K"},
                {"Q", "S", "E"}
        };

        findWords(dictionary, boggle);
    }

    public static String[] findWords(String[] dictionary, String[][] board) {
        List<String> result = new ArrayList<String>();
        HashMap<String, List<String>> graph = createGraph(board);
        return result.toArray(new String[result.size()]);
    }

    private  static HashMap<String, List<String>> createGraph(String[][] board) {
        HashMap<String, List<String>> graph = new HashMap<String, List<String>>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!graph.containsKey(board[i][j])) {
                    graph.put(board[i][j], new ArrayList<String>());
                }

                if (j != 0){
                    graph.get(board[i][j-1]).add(board[i][j]);
                    graph.get(board[i][j]).add(board[i][j-1]);

                    if (i != 0) {
                        graph.get(board[i- 1][j-1]).add(board[i][j]);
                        graph.get(board[i][j]).add(board[i -1][j-1]);
                    }
                }

                if (i != 0) {
                    graph.get(board[i-1][j]).add(board[i][j]);
                    graph.get(board[i][j]).add(board[i - 1][j]);

                    if (j != 0) {
                        graph.get(board[i- 1][j-1]).add(board[i][j]);
                        graph.get(board[i][j]).add(board[i -1][j-1]);
                    }
                }
            }
        }
        return graph;
    }
}
