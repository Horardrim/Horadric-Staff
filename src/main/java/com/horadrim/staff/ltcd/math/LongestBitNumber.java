package com.horadrim.staff.ltcd.math;

/*
 * 对于给定的十进制整数 n，求解其二进制表示中，最长连续 1 段的长度。
 */
public class LongestBitNumber {
    int solution(int N) {
        int max = 0;
        int current = 0;
        while (N > 0) {
            if (N % 2 == 0) {
                current = 0;
            } else {
                current++;
                max = Math.max(max, current);
            }
            N /= 2;
        }
        return max;
    }
}
