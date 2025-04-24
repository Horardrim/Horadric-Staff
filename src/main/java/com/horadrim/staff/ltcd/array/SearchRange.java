package com.horadrim.staff.ltcd.array;

import java.util.Map.Entry;
import java.util.AbstractMap.SimpleEntry;

public class SearchRange {
    public Entry<Integer, Integer> solution(int nums[], int target) {
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return new SimpleEntry<>(-1, -1);
        }

        int l = 0;
        int r = nums.length - 1;
        int leftIndex = -1;
        int rightIndex = -1;
        // 二分查找搜索左边界
        while(l <= r) {
            int m = (r - l) / 2 + l;
            // 寻找左边界所以中间值等于target时也搜索左半边
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        leftIndex = l;
        l = 0;
        r = nums.length - 1;
        // 二分查找搜索右边界
        while (l <= r) {
            int m = (r - l) / 2 + l;
            // 寻找左边界所以中间值必须大于target时才搜索左半边
            if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        rightIndex = r;
        return new SimpleEntry<>(leftIndex, rightIndex);
    }
}
