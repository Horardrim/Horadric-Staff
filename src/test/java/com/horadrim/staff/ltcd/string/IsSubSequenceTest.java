package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsSubSequenceTest {
    @Test
    void test() {
        IsSubSequence isSubSequence = new IsSubSequence();
        boolean solution = isSubSequence.solution("abc", "ahbgdc");
        Assertions.assertTrue(solution);
        log.info("solution: {}", solution);
    }

    @Test
    void duplicate() {
        IsSubSequence isSubSequence = new IsSubSequence();
        boolean solution = isSubSequence.solution("adc", "ahbagdc");
        Assertions.assertTrue(solution);
        log.info("solution: {}", solution);
    }

    @Test
    void negative() {
        IsSubSequence isSubSequence = new IsSubSequence();
        boolean solution = isSubSequence.solution("axc", "ahbagdc");
        Assertions.assertFalse(solution);
        log.info("solution: {}", solution);
    }
}
