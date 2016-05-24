package com.zavrab.recurssionproblems;

public class Main {

    // e.g.
    // 1 => ()
    // 2 => (())  ()()   
    // 3 => ((()))  (()())  (())()  ()(())  ()()()
    
    public static void main(String[] args) {
        brackets(3);
    }

    public static void  brackets(int n) {
        brackets(" ", 0, 0, n);
    }

    private static void brackets(String output, int leftCount, int rightCount, int n) {
        if (leftCount == n && rightCount == n) {
            System.out.print(output);
            return;
        }

        if (leftCount < n) { // Append opening brackets
            brackets(output + "(", leftCount + 1, rightCount, n);
        }

        if (rightCount < leftCount) { // Append closing brackets
            brackets(output + ")", leftCount, rightCount + 1, n);
        }
    }
}
