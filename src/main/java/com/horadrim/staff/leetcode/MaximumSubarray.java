package com.horadrim.staff.leetcode;

import java.util.List;

public class MaximumSubarray {
    public Integer solution(List<Integer> nums) {
        int pre = 0;
        int maxAns = nums.get(0);
        for (int i : nums) {
            pre = Math.max(pre + i, i);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }
}
