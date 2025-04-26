package com.horadrim.staff.ltcd.array;

public class RemoveDupII {
    /*
     * 通过快慢指针
     */
    public int solution(int [] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        // 初始化快慢指针slow和fast
        int slow = 2, fast = 2;
        while (fast < n) {
            // 与slow - 2数组元素比较是否相同，不相同则将nums[fast]的值覆盖nums[slow]
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            // 相同时则快指针fast向前移动来跳过相等的数组元素个数大于2的部分
            ++fast;
        }
        return slow;
    }
}
