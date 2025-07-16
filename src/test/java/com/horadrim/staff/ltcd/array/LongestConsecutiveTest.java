package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestConsecutiveTest {
    @Test
    public void nonContinousArrayTest() {
        int nums [] = new int[] {9, 5, 16, 7, 11, 44, 32};
        int result = new LongestConsecutive().solution(nums);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void duplicateNumArrayTest() {
        int nums [] = new int[] {9, 5, 6, 7, 5, 7, 32};
        int result = new LongestConsecutive().solution(nums);
        Assertions.assertEquals(3, result);
    }
}
