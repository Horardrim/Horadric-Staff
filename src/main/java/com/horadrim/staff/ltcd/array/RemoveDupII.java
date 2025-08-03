package com.horadrim.staff.ltcd.array;

/*
 * 给定一个有序数组 nums，删除重复出现的元素，使得出现次数超过两次的元素只出现两次，返回删除后数组的新长度。
 * Tag: 快慢指针，荷兰国旗问题
 */
public class RemoveDupII {
    /*
     * 通过快慢指针查找出现次数超过2次以上的元素，然后通过交换删除多余元素
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
