package com.horadrim.staff.ltcd.array;

/*
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且使用常数级空间来解决此问题。

 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 */

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
