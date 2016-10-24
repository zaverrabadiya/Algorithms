package com.zavrab.stringproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Scrabble Game:
 * Given 7 characters with their score, find a dictionary word with highest score
 *
 * e.g. B-2, A-3, C-4, M-1, T-6, A-3, X-4 => CAT-13, CAB-9... so result is CAT
 *
 * */
public class ScrabbleGame {

    public static void main(String[] args) {
        Tile[] tiles = new Tile[] {
                new Tile('B', 2), new Tile('A', 3), new Tile('C', 4), new Tile('A', 3),
                new Tile('M',1), new Tile('T', 6), new Tile('X', 4)
        };

        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("ACT");
        dictionary.add("CAB");
        dictionary.add("CAT");

        ReturnValue result = findMaxScoreWord(tiles, dictionary);

        System.out.format("Max score word: %s with score: %d", result.word, result.score);
    }

    public static ReturnValue findMaxScoreWord(Tile[] tiles, HashSet<String> dictionary) {
        if (tiles == null || tiles.length == 0) {
            return new ReturnValue("", 0);
        }

        return generateSetsFoTiles(tiles, 0, dictionary, new ArrayList<Tile>());
    }

    private static ReturnValue generateSetsFoTiles(Tile[] tiles, int i, HashSet<String> dictionary, List<Tile> partialSet) {
        if (i == tiles.length) {
            String word = getWordFromTiles(partialSet);
            int score = getScoreFromTiles(partialSet);

            List<String> permutations = new ArrayList<String>();
            // Permute the partialset-word to get all the possible words from it
            permute(word, 0, permutations);

            // Find out if there is any dictionary word in permutations
            for (String permute : permutations) {
                if (dictionary.contains(permute)) {
                    return new ReturnValue(permute, score);
                }
            }

            return new ReturnValue("", Integer.MIN_VALUE);
        }

        // Recurse to get word without ith character
        ReturnValue wordWithoutIthChar = generateSetsFoTiles(tiles, i+1, dictionary, partialSet);

        // Add ith character
        partialSet.add(tiles[i]);

        // Recurse to get word with ith character
        ReturnValue wordWithIthChar = generateSetsFoTiles(tiles, i+1, dictionary, partialSet);

        // Remove last added tile on backtracking
        partialSet.remove(partialSet.size()-1);

        // Check max score from with and without ith character and return whoever is max
        return (wordWithIthChar.score > wordWithoutIthChar.score) ? wordWithIthChar : wordWithoutIthChar;
    }

    private static String getWordFromTiles(List<Tile> set) {
        StringBuilder sb = new StringBuilder(set.size());

        for (Tile tile : set) {
            sb.append(tile.character);
        }

        return sb.toString();
    }

    private static int getScoreFromTiles(List<Tile> set) {
        int num = 0;

        for (Tile tile : set) {
            num += tile.score;
        }

        return num;
    }

    private static void permute(String word, int start, List<String> permutations) {
        if (start == word.length() - 1) {
            permutations.add(word);
            return;
        }

        for (int i = start; i < word.length(); i++) {
            word = swap(word, start, i);

            permute(word, start+1, permutations);

            word = swap(word, i, start);
        }
    }

    private static String swap(String word, int i, int j) {
        char[] chars = word.toCharArray();

        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

        return new String(chars);
    }

    private static class Tile {
        char character;
        int score;

        Tile(char c, int score) {
            this.character = c;
            this.score = score;
        }
    }

    private static class ReturnValue{
        String word;
        int score;

        ReturnValue(String word, int score) {
            this.word = word;
            this.score = score;
        }
    }
}
