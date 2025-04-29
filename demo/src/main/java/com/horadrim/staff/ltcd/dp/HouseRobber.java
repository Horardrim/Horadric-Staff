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

        // 初始化first和second
        int first = houses[0], second = Math.max(houses[0], houses[1]);
        for (int i = 2; i < len; ++i) {
            // 记录当前最大的收益
            int temp = second;
            /*
             * 如果house[0] > house[1],此时first和second都等于house[0], second等于house[0](first) + house[2](i = 2) 与house[0]之间较大的
             * 毫无疑问house[0] + house[2]是要大于house[0]的，下一轮则是house[0] + house[3]与house[0] + house[2]比较
             * 
             * 如果house[1] > house[0],此时first = house[0], second = house[1],则比较house[0] + house[2]与house[1]取较大的
             * 如果house[1]较大则下一轮比较house[1] + house[3]与house[1]，反之则比较house[1] + house[3]与house[0] + house[2]的大小
             */
            second = Math.max(first + houses[i], second);
            // 将当前最大收益赋给first
            first = temp;
        }

        return second;
    }
}
