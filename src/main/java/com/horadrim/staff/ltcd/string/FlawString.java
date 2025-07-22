package com.horadrim.staff.ltcd.string;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 题目描述
 * 开头和结尾都是元音字母（aeiouAEIOU）的字符串为元音字符串，其中混杂的非元音字母数量为其瑕疵度。比如:
 *
 * "a" 、 "aa"是元音字符串，其瑕疵度都为0
 * "aiur"不是元音字符串（结尾不是元音字符）
 * "abira"是元音字符串，其瑕疵度为2
 * 给定一个字符串，请找出指定瑕疵度的最长元音字符子串，并输出其长度，如果找不到满足条件的元音字符子串，输出0。
 * 
 * 子串：字符串中任意个连续的字符组成的子序列称为该字符串的子串。
 * 
 * 示例 1：
 * 输入：s = "abira", k = 2
 * 输出：3
 * 解释："abira"中包含2个非元音字符，最长元音字符子串为"ira"，长度为3。
 * 
 */
public class FlawString {
    boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    // public int solution(String s, int k) {
    //     int n = s.length();
    //     int ans = 0;
    //     for (int i = 0; i < n; i++) {
    //         int cnt = 0;
    //         for (int j = i; j < n; j++) {
    //             if (!isVowel(s.charAt(j))) {
    //                 cnt++;
    //             }
    //             if (cnt > k) {
    //                 break;
    //             }
    //             ans = Math.max(ans, j - i + 1);
    //         }
    //     }
    //     return ans;
    // }

    public int solution(String s, int flaw) {
        char[] vowelLetters = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        HashSet<Character> vowelSet = new HashSet<>();
        for (char c : vowelLetters) vowelSet.add(c);

        ArrayList<Integer> idxs = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (vowelSet.contains(s.charAt(i))) idxs.add(i);
        }

        int ans = 0;
        int n = idxs.size();

        int l = 0;
        int r = 0;

        while (r < n) {
            // 瑕疵度计算
            int diff = idxs.get(r) - idxs.get(l) - (r - l);

            if (diff > flaw) {
                l++;
            } else if (diff < flaw) {
                r++;
            } else {
                // 处理类似"abgeace"这样的字符串'g'之后的元音字母也会被计算在内

                ans = Math.max(ans, idxs.get(r) - idxs.get(l) + 1);
                r++;
            }
        }

        return ans;
  }
}
