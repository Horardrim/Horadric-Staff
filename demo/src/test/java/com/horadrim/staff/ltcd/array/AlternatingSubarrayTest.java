package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AlternatingSubarrayTest {
    @Test
    public void normalTest() {
        AlternatingSubarray testInc = new AlternatingSubarray();
        int [] array = new int [] {2, 3, 2, 3};
        int result = testInc.solutionII(array);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void shortArrayTest() {
        AlternatingSubarray testInc = new AlternatingSubarray();
        int [] array = new int [] {2, 3};
        int result = testInc.solutionII(array);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void longArrayTest() {
        AlternatingSubarray testInc = new AlternatingSubarray();
        int [] array = new int [] {2, 3, 4, 5, 4, 5, 4, 5};
        int result = testInc.solutionII(array);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void otherTest() {
        AlternatingSubarray testInc = new AlternatingSubarray();
        int [] array = new int [] {2, 3, 4};
        int result = testInc.solutionII(array);
        Assertions.assertEquals(2, result);
    }

    @Test
    public void sadTest() {
        AlternatingSubarray testInc = new AlternatingSubarray();
        int [] array = new int [] {2, 4};
        int result = testInc.solutionII(array);
        Assertions.assertEquals(0, result);
    }
}
