package com.horadrim.staff.ltcd.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringLength {
    public int solution(String str) {
        int globalMaxLen = 0;
        int curMaxLen = 0;
        Set<Character> buff = new HashSet<>();
        for (int i = 0; i < str.length(); ++i) {
            if (!buff.contains(str.charAt(i))) {
                curMaxLen += 1;
                buff.add(str.charAt(i));
            } else {
                if (curMaxLen > globalMaxLen) {
                    globalMaxLen = curMaxLen;
                }
                buff.clear();
                buff.add(str.charAt(i));
                curMaxLen = 1;
            }
        }
        return globalMaxLen;
    }
}
