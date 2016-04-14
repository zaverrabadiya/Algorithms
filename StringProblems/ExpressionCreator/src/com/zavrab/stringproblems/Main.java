package com.zavrab.stringproblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //e.g.
        // "222", 24 = 2+22, 22+2
        String[] result = expressionCreator("222", 24);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    public static String[] expressionCreator(String strDigits, int iK) {
        List<String> results = new ArrayList<String>();

        createExpression(strDigits, iK, 1, results);

        String[] ret = new String[results.size()];
        return results.toArray(ret);
    }

    private final static String[] ops = new String[] {"", "*", "+"};

    private static void createExpression(String s, int k, int i, List<String> results) {
        int numSoFar = evaluate(s);

        if (numSoFar == k) {
            String result = s + "=" + k;
            if (!results.contains(result)) {
                results.add(result);
            }
            return;
        }

        if (i == s.length()){
            return ;
        }

        for (int j = 0; j < ops.length; j++) {
            String newStr = s.substring(0, i) + ops[j] + s.substring(i);
            int nextIdx = (ops[j].isEmpty())? i + 1 : i + 2;
            createExpression(newStr, k, nextIdx, results);
        }
    }

    private static int evaluate(String expressionString) {

        LinkedList<Object> expressionList = buildLinkedList(expressionString);

        if (expressionList.size() <=2 ) {
            return (Integer) expressionList.removeFirst();
        }

        for (int j = 1; j < ops.length; j++) {
            int i = 0;
            char currOperator = ops[j].charAt(0);
            while (i < expressionList.size()) {
                Object curr = expressionList.get(i);
                if (curr instanceof Character && curr.equals(currOperator)) {
                    Integer intermediateSum = getSum (((Integer) expressionList.get(i - 1)), ((Integer) expressionList.get(i + 1)), currOperator);
                    expressionList.set(i - 1, intermediateSum);
                    expressionList.remove(i);// Removes current
                    expressionList.remove(i);// Removes next, since next becomes current, so i is not increased.
                } else {
                    i++;
                }
            }

            if (expressionList.size() <=2 ) {
                return (Integer) expressionList.removeFirst();
            }
        }

        return (Integer) expressionList.removeFirst();
    }

    private static LinkedList<Object> buildLinkedList(String expressionString) {
        int intermediateResult = 0;
        LinkedList<Object> expressionList = new LinkedList<Object>();
        for (int i = 0; i < expressionString.length(); i++) {
            char currChar = expressionString.charAt(i);

            if (isDigit(currChar)) {
                intermediateResult = (intermediateResult * 10) + (currChar - '0');
            } else {
                expressionList.push(intermediateResult);
                expressionList.push(currChar);
                intermediateResult = 0;
            }
        }
        expressionList.push(intermediateResult);
        return expressionList;
    }

    private static boolean isDigit(char c) {
        int digit = c - '0';
        return digit >= 0 && digit <= 9;
    }

    private static int getSum(int sum, int intermediateResult, char operator) {
        switch (operator) {
            case '*':
                return sum * intermediateResult;
            case '+':
                return sum + intermediateResult;
            default:
                return intermediateResult;
        }
    }

}
