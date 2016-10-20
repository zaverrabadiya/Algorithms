package com.zavrab.dpproblems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
* Get code sequence to unlock Safe-locker
* Given digit pad contains 0-9 digit keys, pass code to unlock safe is any 4 digits
* Press any keys and safe will validate last 4 digits anytime
* e.g. if pressed 1234 then it will validated then if pressed 5 then safe will validate 2345 then if pressed 9 then 3459 will be validated
*
* Generate minimum code sequence to unlock safe
*
* Solution: Idea is to take advantage of prefix- means use last 3 digits and add new digit to generate new code
* Start from adding 4 1s then start appending from 9,8...1 and check if the newly generated code is not covered
*
* */
public class GeneratePassCode {

    public static void main(String[] args) {
        int[] pad = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        List<Character> codeSequence = generateMinimumPassCodeToUnlockSafe(4, pad);

        for (Character c : codeSequence) {
            System.out.print(c + " ");
        }
    }

    public static List<Character> generateMinimumPassCodeToUnlockSafe(int k, int[] pad) {
        List<Character> codeSequence = new ArrayList<Character>();
        HashSet<String> exist = new HashSet<String>();

        int totalDigits = (int)Math.pow(pad.length, k) + (k-1);

        String firstCode = "";
        // Add first-digit repeatedly as first possible code
        for (int i = 0; i < k; i++) {
            codeSequence.add(Character.forDigit(pad[0], 10));
            firstCode += pad[0];

            // Decrease totalDigits
            totalDigits--;
        }

        // Add first code to covered record
        exist.add(firstCode);

        for (int i = 1; i <= totalDigits; i++) {
            // Get last k-1 digits to use as a prefix for next possible sequence
            String partialCode = getLastKDigits(k - 1, codeSequence);

            // Try all possible suffix code with prefix
            for (int j = pad.length-1; j >= 0; j--) {
                // Add new digit at end
                partialCode += pad[j];

                if (exist.add(partialCode)) {
                    // Add last digit to the result
                    codeSequence.add(Character.forDigit(pad[j], 10));

                    // Breaking so next code can be generated from last digit again
                    break;
                } else {
                    // Remove just added last-digit
                    partialCode = partialCode.substring(0, partialCode.length()-1);
                }
            }
        }

        return codeSequence;
    }

    private static String getLastKDigits(int k, List<Character> sequence) {
        StringBuilder sb = new StringBuilder();

        if (k <= 0) {
            return "";
        }

        int i = sequence.size() - k;

        if (i < 0) {
            return "";
        }

        while (i < sequence.size()) {
            sb.append(sequence.get(i++));
        }

        return sb.toString();
    }
}

