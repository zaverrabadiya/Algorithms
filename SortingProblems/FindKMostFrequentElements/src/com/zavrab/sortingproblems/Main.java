package com.zavrab.sortingproblems;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        
        int[] nums2 = {1,1,1,2,2,3};

        List<Integer> result = topKFrequent(nums2, 2);
        System.out.println(String.format("expected: [1, 2], result {%s}", Arrays.toString(result.toArray(new Integer[result.size()]))));

        int[] nums3 = {5, 6, 7, 8};

        result = topKFrequent(nums3, 4);
        System.out.println(String.format("expected: [5, 6, 7, 8], result {%s}", Arrays.toString(result.toArray(new Integer[result.size()]))));

        int[] nums4 = {5, 5, 7, 7};

        result = topKFrequent(nums4, 1);
        System.out.println(String.format("expected: [5], result {%s}", Arrays.toString(result.toArray(new Integer[result.size()]))));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

        for (int i : nums) {
            int currCount = freq.get(i) != null ? freq.get(i) : 0;
            freq.put(i,  currCount+ 1);
        }

        List<Integer>[] t = new ArrayList[nums.length + 1];

        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            int val = e.getKey();
            int count = e.getValue();

            if (t[count] == null) {
                t[count] = new ArrayList<Integer>();
            }

            t[count].add(val);
        }

        List<Integer> result = new ArrayList();
        int j = 0;

        for (int i = t.length - 1; i >= 0 && result.size() < k; i--) {
            List<Integer> elements = t[i];

            for (int x = 0; elements != null && x < elements.size(); x++) {
                result.add(elements.get(x));

                 if (result.size() == k) {
                     return result;
                 }
            }
        }

        return result;
    }
}
