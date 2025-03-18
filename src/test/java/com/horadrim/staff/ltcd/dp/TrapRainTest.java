package com.horadrim.staff.ltcd.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrapRainTest {
    @Test
    public void normalTest() {
        TrapRain testRain = new TrapRain();
        int height [] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int rain = testRain.solutionI(height);
        int rainII = testRain.solutionII(height);
        Assertions.assertEquals(6, rain);
        Assertions.assertEquals(6, rainII);
    }

    @Test
    public void wideNormalTest() {
        TrapRain testRain = new TrapRain();
        int height [] = {4, 2, 0, 3, 2, 5};
        int rain = testRain.solutionI(height);
        int rainII = testRain.solutionII(height);
        Assertions.assertEquals(9, rain);
        Assertions.assertEquals(9, rainII);
    }
}
