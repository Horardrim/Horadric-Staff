package com.horadrim.staff.ltcd.array;

public class MinimumSumSubarray {
    /**
     * 通过滑动窗口 + 前缀和实现
     */
    int solution(int [] nums, int left, int right) {
        int result = Integer.MAX_VALUE;
        int [] preSum = new int[nums.length + 1];
        // 计算前缀和
        // [1, 2, 3, 4, 5]的前缀和数组为[0, 1, 3, 6, 10, 15]
        for (int i = 1; i < preSum.length; ++i) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int len = left; len <= right; ++len) {
            int l = 0, r = 0, sum = 0;
            while (r++ < nums.length) {
                // 判断区间是否满足窗口
                if (r - l == len) {
                    // 通过前缀和相减计算l到r的和
                    sum = preSum[r] - preSum[l];
                    if (sum > 0 && sum < result) {
                        result = sum;
                    }
                    // 移动左边界
                    ++l;
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
