package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MinimumSumSubarrayTest {
    @Test
    public void normalTest() {
        int [] array = new int[] {1, 2, 3, 4, 5};
        int result = new MinimumSumSubarray().solution(array, 2, 3);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void noResultTest() {
        int [] array = new int[] {1, -2, -3, -4, -5};
        int result = new MinimumSumSubarray().solution(array, 2, 3);
        Assertions.assertEquals(-1, result);
    }
}
