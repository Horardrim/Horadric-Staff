package com.horadrim.staff.ltcd.dp;

public class HouseRobberII {
    public int solution(int [] houses) {
        int len = houses.length;
        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return houses[0];
        } else if (len == 2) {
            return Math.max(houses[0], houses[1]);
        }

        // 计算从第一家开始偷和从第二家偷所得值得最大值
        return Math.max(rob(houses, 0, len - 1), rob(houses, 1, len));
    }

    int rob(int [] houses, int start, int end) {
        int first = houses[start], second = Math.max(first, houses[start + 1]);
        for (int i = start + 2; i < end; ++i)  {
            int temp = second;
            second = Math.max(first + houses[i], second);
            first = temp;
        }
        return second;
    }
}
