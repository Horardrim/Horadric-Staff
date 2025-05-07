package com.horadrim.staff.ltcd.string;

import java.util.Objects;

public class LongestCommonSubstring {
    public String solution(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2)) {
            return null;
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 公共子字符串的最大长度
        int maxLength = 0;
        /*
         * s1字符串的下标索引，用于记录公共子字符串的最后一个字符所在的索引
         * 当然也可以用s2字符串的下标，一下endIndex = i就应该改成endIndex = j
         * return s1.substring(endIndex - maxLength, endIndex); 应该改成
         * s2.substring(endIndex - maxLength, endIndex);
         */
        int endIndex = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 相等时说明有子串
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLength) {
                        // 更新最大长度和起始的index
                        maxLength = dp[i][j];
                        endIndex = i;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return s1.substring(endIndex - maxLength, endIndex);
    }
}
