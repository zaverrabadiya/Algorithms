package com.zavrab.stringproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatch {

    private static HashMap<Character, String> map;

    public static boolean match(String pattern, String str) {
        map = new HashMap<Character, String>();
        boolean res = matchInt(pattern, str);
        return res;
    }

    private static boolean matchInt(String pattern, String str) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }

        char pch = pattern.charAt(0);

        for (int i = 0; i < str.length(); ++i) {

            if (!map.containsKey(pch)) {
                String val = str.substring(0, i + 1);
                map.put(pch, val);

                if (matchInt(pattern.substring(1), str.substring(val.length()))) {
                    return true;
                } else {
                    map.remove(pch);
                }

            } else {
                String val = map.get(pch);

                if (!str.startsWith(val)) {
                    return false;
                }

                return matchInt(pattern.substring(1), str.substring(val.length()));
            }
        }
        return false;
    }


    // USE OF REGEX
    public static byte checkPattern(String patternString, String input) {
        StringBuffer patternBuffer = new StringBuffer();
  
        // check input and pattern strings
        if (patternString == null || input == null) {
            throw new IllegalArgumentException();
        }
  
        // pattern character array
        List<Character> chars = new ArrayList<Character>();
        for (char c : patternString.toCharArray()) {

            if (!chars.contains(c)) {
                // new character found, append new group
                patternBuffer.append("(.+)");
                chars.add(c);
            } else {
                // looking for unique sequence by number
                patternBuffer.append("\\")
                        .append(chars.indexOf(c)+1);
            }
        }
  
        // compiling pattern and checking input string
        Pattern pattern = Pattern.compile(patternBuffer.toString());
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return 1;
        }

        return 0;
    }
}