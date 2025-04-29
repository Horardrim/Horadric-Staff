package com.horadrim.staff.ltcd.array;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaximumSubarrayTest {

    @Test
    public void happyCase() {
        MaximumSubarray solution = new MaximumSubarray();
        List<Integer> testNums = List.of(-2, 1, -3, 4, -1, 2, 1, -5, 4);
        int result = solution.solution(testNums);
        Assertions.assertEquals(result, 6);
    }

    @Test
    public void oneElementArrayCase() {
        MaximumSubarray solution = new MaximumSubarray();
        List<Integer> testNums = List.of(-1);
        int result = solution.solution(testNums);
        Assertions.assertEquals(result, -1);
    }
}
