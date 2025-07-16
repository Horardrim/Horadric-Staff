package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubArraySumDivByKTest {
    @Test
    public void normalTest() {
        int nums [] = new int[] {4, 5, 0, -2, -3, 1};
        int result = new SubArraySumDivByK().solution(nums, 5);
        Assertions.assertEquals(7, result);
    }

    @Test
    public void noResultTest() {
        int nums [] = new int[] {5};
        int result = new SubArraySumDivByK().solution(nums, 9);
        Assertions.assertEquals(0, result);
    }
}
