package com.horadrim.staff.ltcd.array;

import java.util.HashMap;
import java.util.Map;

/*
 * 给你一个整数数组 nums 和一个整数k，请你统计并返回 该数组中和为 k 的子数组的个数。
 * 子数组是数组中元素的连续非空序列。
 * 示例 1：

 *  输入：nums = [1,1,1], k = 2
 *  输出：2
 *  示例 2：

 *  输入：nums = [1,2,3], k = 3
 *  输出：2
 * 
 * Tag: 前缀和
 */
public class SubarraySumEqualsK {
    int solution(int [] nums, int k) {
        int result = 0;
        int pre = 0;
        Map<Integer, Integer> presumMap = new HashMap<>();
        presumMap.put(0, 1);
        for (int i : nums) {
            pre += i;
            if (presumMap.containsKey(pre - k)) {
                result += presumMap.get(pre - k);
            }

            presumMap.put(pre, presumMap.getOrDefault(pre, 0) + 1);
        }


        return result;
    }
}
