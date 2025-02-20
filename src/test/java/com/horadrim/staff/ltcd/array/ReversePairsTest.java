package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReversePairsTest {
    @Test
    public void normalTest() {
        ReversePairs testInc = new ReversePairs();
        testInc.solution(new int []{5, 4, 3, 2, 1});
        int [] src = {1, 2, 3, 4, 5};
        int [] t = {0, 0, 0, 0, 0};
        System.arraycopy(src, 2, t, 0, 3);
        log.info("t[0] = {}", t[0]);
        log.info("t[1] = {}", t[1]);
    }
}
