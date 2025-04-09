package com.horadrim.staff.ltcd.array;

public class RotateArray {
    public void solution(int[] nums, int k) {
        int n = nums.length;
        // 取模得到旋转所要经过的步长
        k = k % n;
        // 步长和数组长度的最大公约数为旋转交换需要进行的次数
        int count = gcd(k, n);
        // 以长度为8，k为2为例
        // 第一轮交换为0 -> 2, 2 -> 4, 4 -> 6, 6 -> 0
        // 第二轮交换为1 -> 3, 3 -> 5, 5 -> 7, 7 -> 1
        //  |- swap k  -|-- swap k -|
        // [0,    1,    2,    3,    4,    5,    6,    7]
        //  |-- count --|
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                prev = swap(nums, next, prev);
                current = next;
            } while (start != current); //start等于current时表示已经轮询了一圈，结束循环
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
