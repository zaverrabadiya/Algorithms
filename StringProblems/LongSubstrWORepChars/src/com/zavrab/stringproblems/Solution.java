package com.zavrab.stringproblems;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcabcbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("bbbb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwke"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("pwwkew"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcadefb"));
        System.out.println(longestSubstringWithoutRepeatingCharacters("abcABC"));
    }

    public static String longestSubstringWithoutRepeatingCharacters(String inStr) {
        int[] members = getPrePopulatedArray();
        int subStrStartPos = -1, maxLength = 0, currLength = 0;

        for (int i = 0;i < inStr.length(); i++) {
            char currChar = Character.toLowerCase(inStr.charAt(i));
            int prevIndx = members[currChar];

            if (prevIndx == -1 || (i - currChar) > prevIndx) {
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
