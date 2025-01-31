package com.horadrim.staff.leetcode.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClimbingStairsTest {
    @Test
    public void normalTest() {
        ClimbingStairs testInstance = new ClimbingStairs();
        Integer methods = testInstance.solution(2);
        Assertions.assertEquals(methods, 2);
    }

    @Test
    public void bigStepsTest() {
        ClimbingStairs testInstance = new ClimbingStairs();
        Integer methodsSolution2 = testInstance.solution2(5);
        Assertions.assertEquals(methodsSolution2, 8);

        Integer methodsSolution1 = testInstance.solution(5);
        Assertions.assertEquals(methodsSolution2, methodsSolution1);
    }
}
