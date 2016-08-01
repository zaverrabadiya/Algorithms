package com.zavrab.dpproblems;

public class HouseRobberySolution {

    public static void main(String[] args) {
        int[] houseValues = new int[] {6, 1, 2, 7, 1};
        //int[] houseValues = new int[] {1,2,3,4,5};

        System.out.print("Maximal robbery: " + maxStolenValue(houseValues));
    }

    public static int maxStolenValue(int[] arrHouseValues) {
        //return maxStolenValueInternal(arrHouseValues, 0);
        return maxStolen(arrHouseValues);
    }

    private static int maxStolenValueInternal(int[] houseValues, int start) {
        if (start >= houseValues.length) {
            return 0;
        }

        int first = houseValues[start] + maxStolenValueInternal(houseValues, start + 2);
        int second = maxStolenValueInternal(houseValues, start + 1);

        return Math.max(first, second);
    }

    private static int maxStolen(int[] houseValues) {
        if (houseValues.length == 0) {
            return 0;
        }

        int value1 = houseValues[0];
        if (houseValues.length == 1) {
            return value1;
        }

        int value2 = Math.max(value1, houseValues[1]);
        if (houseValues.length == 2) {
            return value2;
        }

        int value = 0;

        for (int i = 2; i < houseValues.length; i++) {
            value = Math.max(value2, value1 + houseValues[i]);
            value1 = value2;
            value2 = value;
        }

        return value;
    }
}
