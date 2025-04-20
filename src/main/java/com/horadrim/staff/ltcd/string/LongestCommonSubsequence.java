package com.horadrim.staff.ltcd.string;

import java.util.Objects;

public class LongestCommonSubsequence {
    public String solution(String s1, String s2) {
        if (Objects.isNull(s1) || Objects.isNull(s2)) {
            return null;
        }

        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        // 填充 dp 表
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 提取最长公共子序列
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString();
    }
}
