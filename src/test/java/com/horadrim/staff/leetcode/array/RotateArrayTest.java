package com.horadrim.staff.leetcode.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RotateArrayTest {
    @Test
    public void normalTest() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        RotateArray test = new RotateArray();
        test.solution(a, 3);
        Assertions.assertEquals(a[0], 5);
    }

    @Test
    public void testMultiLoop() {
        int[] a = {1, 2, 3};
        RotateArray test = new RotateArray();
        test.solution(a, 6);
        Assertions.assertEquals(a[0], 1);
    }
}
