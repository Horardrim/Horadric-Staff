package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JumpGameTest {
    @Test
    public void normalTest() {
        int [] nums = new int[] {2, 2, 1, 0, 2};
        boolean result = new JumpGame().solution(nums);
        Assertions.assertTrue(!result);
    }

    @Test
    public void trueTest() {
        int [] nums = new int[] {4, 2, 1, 0};
        boolean result = new JumpGame().solution(nums);
        Assertions.assertTrue(result);
    }

    @Test
    public void longArrayTest() {
        int [] nums = new int[] {3, 0, 2, 0, 3, 4, 1, 1, 0};
        boolean result = new JumpGame().solution(nums);
        Assertions.assertTrue(result);
    }
}
