package com.horadrim.staff.ltcd.array;

public class SearchInsert {
    public int solution(int [] nums, int target) {
        int result = -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = (r - l) / 2 + l;
            if (nums[m] > target) {
                r = m - 1;
            } else if (nums[m] <= target) {
                l = m + 1;
                result = m;
            }
        }

        return result;
    }
}
