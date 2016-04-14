package com.zavrab.stringproblems;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(2, 3, 4);
        System.out.println("Result: " + expressionSynthesis(A, 5));
    }

    // @include
    public static boolean expressionSynthesis(List<Integer> digits, int target) {
        List<Character> operators = new ArrayList<Character>();
        List<Integer> operands = new ArrayList<Integer>();
        return directedExpressionSynthesis(digits, target, 0, 0, operands,
                operators);
    }

    private static boolean directedExpressionSynthesis(
            List<Integer> digits, int target, int currentTerm, int offset,
            List<Integer> operands, List<Character> operators) {
        currentTerm = currentTerm * 10 + digits.get(offset);
        if (offset == digits.size() - 1) {
            operands.add(currentTerm);
            if (evaluate(operands, operators) == target) { // Found a match.
                // @exclude
                int operandIdx = 0;
                System.out.print(operands.get(operandIdx));
                for (Character oper : operators) {
                    ++operandIdx;
                    System.out.print(" " + oper + " " + operands.get(operandIdx));
                }
                System.out.println(" = " + target);
                // @include
                return true;
            }
            operands.remove(operands.size() - 1);
            return false;
        }

        // No operator.
        if (directedExpressionSynthesis(digits, target, currentTerm, offset + 1,
                operands, operators)) {
            return true;
        }
        // Tries multiplication operator '*'.
        operands.add(currentTerm);
        operators.add('*');
        if (directedExpressionSynthesis(digits, target, 0, offset + 1, operands,
                operators)) {
            return true;
        }
        operators.remove(operators.size() - 1);
        operands.remove(operands.size() - 1);
        // Tries addition operator '+'.
        operands.add(currentTerm);
        if (target - evaluate(operands, operators)
                <= remainingInt(digits, offset + 1)) {
            operators.add('+');
            if (directedExpressionSynthesis(digits, target, 0, offset + 1, operands,
                    operators)) {
                return true;
            }
            operators.remove(operators.size() - 1);
        }
        operands.remove(operands.size() - 1);
        return false;
    }

    // Calculates the int represented by digits.subList(idx, digits.size()).
    private static int remainingInt(List<Integer> digits, int idx) {
        int val = 0;
        for (int i = idx; i < digits.size(); ++i) {
            val = val * 10 + digits.get(i);
        }
        return val;
    }

    private static int evaluate(List<Integer> operands,
                                List<Character> operators) {
        Deque<Integer> intermediateOperands = new LinkedList<Integer>();
        int operandIdx = 0;
        intermediateOperands.addFirst(operands.get(operandIdx++));
        // Evaluates '*' first.
        for (char oper : operators) {
            if (oper == '*') {
                intermediateOperands.addFirst(intermediateOperands.removeFirst()
                        * operands.get(operandIdx++));
            } else {
                intermediateOperands.addFirst(operands.get(operandIdx++));
            }
        }

        // Evaluates '+' second.
        int sum = 0;
        while (!intermediateOperands.isEmpty()) {
            sum += intermediateOperands.removeFirst();
        }
        return sum;
    }
}
