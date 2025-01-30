package com.horadrim.staff.leetcode.array;

public class RotateArray {
    public void solution(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                prev = swap(nums, next, prev);
                current = next;
            } while (start != current);
        }
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        else
        {
            return gcd(b, a % b);
        }
    }

    int swap(int[] a, int index, int prev) {
        a[index] = a[index] ^ prev;
        prev = a[index] ^ prev;
        a[index] = a[index] ^ prev;
        return prev;
    }
}
