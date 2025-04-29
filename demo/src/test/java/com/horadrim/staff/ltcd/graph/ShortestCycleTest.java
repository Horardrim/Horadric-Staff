package com.horadrim.staff.ltcd.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShortestCycleTest {
    @Test
    public void normalTest() {
        ShortestCycle testIns = new ShortestCycle();

        int shortestCycle = testIns.solution(6);
        Assertions.assertEquals(3, shortestCycle);
    }
}
