package com.horadrim.staff.ltcd.array;

public class SingleNumberII {
    int solution(int [] nums) {
        int ans = 0;
        // int型32位
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            // 每个数取第i为的值(0或者1)，并且累加给total变量
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            // 如果total对3求余不为0，则这个唯一的数在第i为上为1，1左移i为后与ans做或运算，知道32位全部算完
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
