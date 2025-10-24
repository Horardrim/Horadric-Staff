package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubArraySumEqualsKTest {

    @Test
    public void normalTest() {
        int nums [] = new int[] {1, 1, 1};
        int result = new SubArraySumEqualsK().solution(nums, 2);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void normalTestII() {
        int nums [] = new int[] {3, 4, 7, 2, -3, 1, 4, 2};
        int result = new SubArraySumEqualsK().solution(nums, 7);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void normalTestIII() {
        int nums [] = new int[] {4, -4, 4};
        int result = new SubArraySumEqualsK().solution(nums, 4);
        Assertions.assertEquals(3, result);
        /*
         * 结果为 {4}， {4}（最后一个4），{4， -4， 4}
         */
    }
}
