package com.zavrab.adhoc;

import java.util.ArrayList;
import java.util.List;

/**
 * A long array A[] is given to you. There is a sliding window of size w
 * which is moving from the very left of the array to the very right.
 * You can only see the w numbers in the window. Each time the sliding window moves rightwards by one position.
 *
 * Following is an example:
 * The array is [1 3 -1 -3 5 3 6 7], and w is 3.

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7        3
 1  3 [-1  -3  5] 3  6  7        5
 1  3  -1 [-3  5  3] 6  7        5
 1  3  -1  -3 [5  3  6] 7        6
 1  3  -1  -3  5 [3  6  7]       7

 * Input: A long array A[], and a window width w
 * Output: An array B[], B[i] is the maximum value of from A[i] to A[i+w-1]
 * Requirement: Find a good optimal way to get B[i]
 *
 * http://articles.leetcode.com/sliding-window-maximum
 *
 * */
public class SlidingWindowMax {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int window = 3;

        Integer[] result = findWindowMax(arr, window);

        for (Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public static Integer[] findWindowMax(int[] A, int w) {
        List<Integer> queue = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();

        for (int i = 0; i < w; i++) {
            while (!queue.isEmpty() && A[i] >= A[back(queue)]) {
                queue.remove(queue.size()-1);
            }
            queue.add(i);
        }

        for (int i = w; i < A.length; i++) {
            B.add(A[front(queue)]);

            while (!queue.isEmpty() && A[i] >= A[back(queue)]) {
                queue.remove(queue.size()-1);
            }

            while (!queue.isEmpty() && front(queue) <= i-w) {
                queue.remove(0);
            }
            queue.add(i);
        }
        B.add(A[front(queue)]);

        return B.toArray(new Integer[B.size()]);
    }

    private static int front(List<Integer> queue) {
        return queue.get(0);
    }

    private static int back(List<Integer> queue) {
        return queue.get(queue.size() - 1);
    }
}
