package com.horadrim.staff.ltcd.dp;

public class HouseRobber {
    public int solution(int[] houses) {
        if (houses.length == 0) {
            return 0;
        }
        
        int len = houses.length;
        if (len == 1) {
            return houses[0];
        }

        int first = houses[0], second = Math.max(houses[0], houses[1]);
        for (int i = 2; i < len; ++i) {
            int temp = second;
            second = Math.max(first + houses[i], second);
            first = temp;
        }

        return second;
    }
}
