package com.zavrab.stringproblems;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	    //e.g.
        // "MMMMCMXCIX" = 4999
        // "I" = 1
        // "IV" = 4
        // "VI" = 6

        String roman = "XI";
        System.out.println("Roman to Decimal: " + rtoi(roman));
    }

    private static final HashMap<Character, Integer> rToIMap = prePopulateMap();

    static int rtoi(String strRoman) {
        if (strRoman == null || strRoman.isEmpty()) {
            return 0;
        }
        int number = 0;

        for (int i = 0; i < strRoman.length(); i++) {
            int current = rToIMap.get(strRoman.charAt(i));
            if (i < strRoman.length() - 1) {
                int next = rToIMap.get(strRoman.charAt(i + 1));
                if (next > current) {
                    current = next - current;
                    i++;
                }
            }
            number += current;
        }
        return number;
    }
    
    private static HashMap<Character, Integer> prePopulateMap() {
        HashMap<Character, Integer> rToIMap = new HashMap<Character, Integer>();
        rToIMap.put('I', 1);
        rToIMap.put('V', 5);
        rToIMap.put('X', 10);
        rToIMap.put('L', 50);
        rToIMap.put('C', 100);
        rToIMap.put('D', 500);
        rToIMap.put('M', 1000);
        return rToIMap;
    }
}
