package com.horadrim.staff.ltcd.string;

public class LonggestCommonPrefix {
    String solution(String [] strings) {
        int minStrLength = Integer.MAX_VALUE;
        int minStrIndex = 0;
        for (int i = 0; i < strings.length; ++i) {
            if (strings[i].length() < minStrLength) {
                minStrLength = strings[i].length();
                minStrIndex = i;
            }
        }

        String minLengthStr = strings[minStrIndex];
        for (int i = 0; i < minStrLength; ++i) {
            for (int j = 0; j < strings.length; ++j) {
                if (strings[j].charAt(i) != minLengthStr.charAt(i)) {
                    return new StringBuilder(minLengthStr).substring(0, i);
                }
            }
        }
        
        return minLengthStr;
    }
}
