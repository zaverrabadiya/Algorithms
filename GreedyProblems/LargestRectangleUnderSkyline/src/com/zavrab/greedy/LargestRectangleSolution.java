package com.zavrab.greedy;

import java.util.*;

public class LargestRectangleSolution {

    /**
     * Compute the largest rectangle under the skyline
     *
     * Input: {1, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3} -> Output = 20 which includes buildings from 2nd to 11th
     *
     * Input: {2, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3} -> Output = 22 which includes buildings from 1st to 11th
     *
     *
     * Idea is iterate through buildings and go backward when you find current building's height is less than the last taller building.
     * At that point go backward till last building height is greater than the current building
     *
     * To maintain the last taller building- Using stack here
     * */
    public static void main(String[] args) {
        int[] h = new int[] {1, 4, 2, 5, 6, 3, 2, 6, 6, 5, 2, 1, 3};

        int rect = calculateLargestRectangle(h);

        System.out.print("Largest rectangle is: " + rect);
    }

    public static int calculateLargestRectangle(int[] heights) {

        Stack<Integer> pillarIndices = new Stack<Integer>();
        int maxRectangleArea = 0;

        for (int i = 0; i <= heights.length; ++i) {

            if (!pillarIndices.isEmpty() && i < heights.length && heights[i] == heights[pillarIndices.peek()]) {
                // Replace earlier building with same height by current building. This
                // ensures the later buildings have the correct left endpoint.
                pillarIndices.pop();
                pillarIndices.push(i);
            }

            // By iterating to heights.size() instead of heights.size() - 1, we can
            // uniformly handle the computation for rectangle area here.
            while (!pillarIndices.isEmpty() && isNewPillarOrReachEnd(heights, i, pillarIndices.peek())) {

                int height = heights[pillarIndices.pop()];

                // i - pillarIndices.peekFirst() - 1; excludes the last building with less height than current building
                int width = pillarIndices.isEmpty() ? i : i - pillarIndices.peek() - 1;

                maxRectangleArea = Math.max(maxRectangleArea, height * width);
            }

            pillarIndices.push(i);
        }

        return maxRectangleArea;
    }

    private static boolean isNewPillarOrReachEnd(int[] heights, int currIdx, int lastPillarIdx) {

        return currIdx >= heights.length || heights[currIdx] < heights[lastPillarIdx];
    }

}
