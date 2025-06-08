package com.horadrim.staff.ltcd.array;

import java.util.HashSet;
import java.util.Set;


/*
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 */
public class LongestConsecutive {
    int solution(int [] nums) {
        Set<Integer> num_set = new HashSet<>();
        int longestConsecutive = 0;
        for (int i : nums) {
            num_set.add(i);
        }

        for (int i : num_set) {
            if (!num_set.contains(i - 1)) {
                int result = 1;
                int current_num = i;
                while(num_set.contains(current_num + 1)) {
                    current_num += 1;
                    result += 1;
                }

                longestConsecutive = Math.max(result, longestConsecutive);
            }
        }

        return longestConsecutive;
    }
}
