package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JumpGameIITest {
    @Test
    public void neverReachTest() {
        int [] nums = new int[] {2, 2, 1, 0, 2};
        int result = new JumpGameII().solution(nums);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void normalTest() {
        int [] nums = new int[] {2, 3, 1, 1, 4};
        int result = new JumpGameII().solution(nums);
        Assertions.assertEquals(2, result);
    }
}
