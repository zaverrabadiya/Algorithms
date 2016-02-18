package com.zavrab.bitwiseoperation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    List<Integer> num1 = new ArrayList<Integer>();
        num1.add(1);
        num1.add(5);
        num1.add(4);

        List<Integer> num2 = new ArrayList<Integer>();
        num2.add(2);
        num2.add(5);

        //Input 154 * 25 Output = 3850
        List<Integer> result = multiply(num1, num2);
        for (int x: result) {
            System.out.print(x);
        }
    }

    public static List<Integer> multiply(List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<Integer>(A.size() + B.size());

        Collections.reverse(A);
        Collections.reverse(B);

        for(int x = 0; x < A.size() + B.size(); x++) {
            result.add(x, 0);
        }

        for(int i = 0; i < A.size(); i++) {
            for(int j = 0; j < B.size(); j ++) {
                result.set((i + j), (result.get(i + j) + (A.get(i) * B.get(j))));
                result.set((i + j + 1), result.get(i + j + 1) + (result.get(i + j) / 10));
                result.set((i + j), result.get(i + j) % 10);
            }
        }
        //Remove leading zero and if result is 0 then leave one 0
        while (result.size() != 1 && result.get(result.size() - 1) == 0) {
            result.remove(result.size() - 1);
        }

        //Reverse the result
        Collections.reverse(result);
        return result;
    }
}
