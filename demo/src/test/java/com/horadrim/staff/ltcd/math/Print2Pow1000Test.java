package com.horadrim.staff.ltcd.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Print2Pow1000Test {
    @Test
    public void normalTest() {
        Print2Pow1000 testInc = new Print2Pow1000();
        int [] result = testInc.solution(5);
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals(2, result[0]);
        Assertions.assertEquals(3, result[1]);
    }
}
