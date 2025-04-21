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
        int maxLength = 0;
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
