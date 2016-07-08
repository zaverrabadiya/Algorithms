package com.zavrab.stringproblems;

public class Main {

    public static void main(String[] args) {

        String inStr = "cagtcagg";
        SuffixTree suffixTree = new SuffixTree();

        suffixTree.insert(inStr);


        String searchWord = "cagg";
        String result = suffixTree.search(searchWord) ? "exist" : "does not exist";

        System.out.format("Word: \"%s\" %s \n", searchWord, result);
    }
}
