package com.horadrim.staff.ltcd.math;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseNumber {
    public int solution(int num) {
        return num == 0 ? 0 : reverse(num);
    }

    private int reverse(int num) {
        int result = 0;
        while (num / 10 != 0) {
            result = result * 10 + (num % 10);
            num = num / 10;
        }

        return result * 10 + num;
    }
}
