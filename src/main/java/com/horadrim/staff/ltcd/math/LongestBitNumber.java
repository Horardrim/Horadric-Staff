package com.horadrim.staff.ltcd.math;

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
