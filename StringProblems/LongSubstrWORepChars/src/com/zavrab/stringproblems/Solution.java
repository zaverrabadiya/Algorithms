package com.zavrab.stringproblems;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestStringWithoutRepeatingCharacters("abcabcbb"));    // "abc"
        System.out.println(longestStringWithoutRepeatingCharacters("bbbb"));        // "b"
        System.out.println(longestStringWithoutRepeatingCharacters("pwwke"));       // "wke"
        System.out.println(longestStringWithoutRepeatingCharacters("pwwkew"));      // "wke"
        System.out.println(longestStringWithoutRepeatingCharacters("abcadefb"));    // "bcadef"
        System.out.println(longestStringWithoutRepeatingCharacters("abcABC"));      // "abc"
    }

    public static String longestStringWithoutRepeatingCharacters(String str) {
        // Store the index of given character at character's ascii
        int[] members = getPrePopulatedArray();

        int lenMax = 0, lenSoFar, posStart = 0, posCurr = 0, idxPrev, i = 0;
        char charCurr;

        for (; i < str.length(); i++) {
            charCurr = Character.toLowerCase(str.charAt(i));
            idxPrev = members[charCurr];

            // If same character was found before, then check if that character is still in the range of longest substring seen so far
            if (idxPrev >= posCurr) {
                lenSoFar = i - posCurr;

                if (lenSoFar > lenMax) {
                    lenMax = lenSoFar;
                    posStart = posCurr;
                }

                // If same character is in range then move current position to next of that character
                posCurr = idxPrev + 1;
            }

            members[charCurr] = i;
        }

        // If whole string or last substring is unique then if (idxPrev >= posCurr) won't be executed hence max len won't be counted
        lenSoFar = i - posCurr;

        if (lenSoFar > lenMax) {
            lenMax = lenSoFar;
            posStart = posCurr;
        }

        return str.substring(posStart, (posStart + lenMax));
    }

    // SOLUTION: 2
    public static String longestSubstringWithoutRepeatingCharacters(String inStr) {
        int[] members = getPrePopulatedArray();
        int subStrStartPos = -1, maxLength = 0, currLength = 0;

        for (int i = 0;i < inStr.length(); i++) {
            char currChar = Character.toLowerCase(inStr.charAt(i));
            int prevIndx = members[currChar];

            if (prevIndx == -1 || (i - currLength) > prevIndx) {
                currLength++;
            } else {
                if (currLength > maxLength) {
                    maxLength = currLength;
                    subStrStartPos = i - currLength;
                }
                currLength = i - prevIndx;
            }

            members[currChar] = i;
        }

        // If last longest substring ends with last character then it won't get caught in For loop i.e "pwwke" -> "wke"
        if (currLength > maxLength) {
            maxLength = currLength;
            subStrStartPos = inStr.length() - currLength;
        }

        return inStr.substring(subStrStartPos, (subStrStartPos + maxLength));
    }

    private static int[] getPrePopulatedArray() {
        int[] members = new int[230]; // Total alphabets Uppercase letters 256 - 26 = 230
        for (int i = 0; i < members.length; i++) {
            members[i] = -1;
        }

        return members;
    }
}
