package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SprialArrayTest {
    @Test
    public void smallArrayTest() {
        int[][] array = {{0, 1}, {1, 0}};

        int [] result = new SprialArray().solution(array);
        Assertions.assertEquals(4, result.length);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(0, result[2]);
        result = new SprialArray().solutionII(array);
        Assertions.assertEquals(4, result.length);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(0, result[2]);
    }
}
