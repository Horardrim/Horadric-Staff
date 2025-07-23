package com.horadrim.staff.ltcd.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestBitNumberTest {
    @Test
    public void test() {
        LongestBitNumber longestBitNumber = new LongestBitNumber();
        int solution = longestBitNumber.solution(1024);
        Assertions.assertEquals(1, solution);
        log.info("solution: {}", solution);
    }

    @Test
    public void test2() {
        LongestBitNumber longestBitNumber = new LongestBitNumber();
        int solution = longestBitNumber.solution(0);
        Assertions.assertEquals(0, solution);
        log.info("solution: {}", solution);
    }

    @Test
    public void test3() {
        LongestBitNumber longestBitNumber = new LongestBitNumber();
        int solution = longestBitNumber.solution(7);
        Assertions.assertEquals(3, solution);
        log.info("solution: {}", solution);
    }
}
