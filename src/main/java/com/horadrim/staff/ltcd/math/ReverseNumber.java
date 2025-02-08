package com.horadrim.staff.ltcd.math;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseNumber {
    public int solution(int num) {
        return num == 0 ? 0 : reverse(num);
    }

    private int reverse(int num) {
        int result = 0;
        while (num != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }

            result = result * 10 + (num % 10);
            num = num / 10;
        }

        return result;
    }
}
