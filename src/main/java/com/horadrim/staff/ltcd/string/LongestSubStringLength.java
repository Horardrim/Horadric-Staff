package com.horadrim.staff.ltcd.string;

import java.util.HashSet;
import java.util.Set;
/*
 * 无重复字符的最长子串
 * 
 * Tag: 快慢指针
 */
public class LongestSubStringLength {
    public int wrongSolution(String str) {
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

    public int solution(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
