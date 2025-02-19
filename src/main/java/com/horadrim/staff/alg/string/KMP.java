package com.horadrim.staff.alg.string;

import java.util.ArrayList;
import java.util.List;

public class KMP {
    public Object [] match(String text, String pattern) {
        int [] matchPattern = buildPartialMatchTable(pattern);
        int m = text.length();
        int n = pattern.length();
        int j = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; ++i) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = matchPattern[j - 1];
            }

            if (text.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }

            if (j == n) {
                result.add(i - n + 1);
                j = matchPattern[j - 1];
            }
        }

        return result.toArray();
    }

    public int [] buildPartialMatchTable(String pattern) {
        int strLen = pattern.length();
        int [] matchTable = new int [strLen];
        int j = 0;
        for (int i = 1; i < strLen; ++i) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = matchTable[j - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(j)) {
                j += 1;
            }

            matchTable[i] = j;
        }
        return matchTable;
    }
}
