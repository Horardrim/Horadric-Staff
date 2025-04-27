package com.horadrim.staff.ltcd.array;

public class JumpGameII {
    /*
     * 贪心算法，不断更新maxPosition，i每次移动maxPosition保持最大值
     */
    int solution(int [] nums) {
        // 初始化最小步数为0，结束点end为0，最大位移maxPosition为0
        int steps = 0;
        int end = 0;
        int maxPosition = 0; 
        for (int i = 0; i < nums.length - 1; ++i) {
            // i每移动一次更新maxPosition
            maxPosition = Math.max(maxPosition, i + nums[i]);
            // i抵达第一个end时，将maxPosition赋给end，作为第二个end并且steps + 1
            if (i == end) {
                end = maxPosition;
                ++steps;
            }
        }

        return steps;
    }
}
