package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IsSubSequenceTest {
    @Test
    void test() {
        IsSubSequence isSubSequence = new IsSubSequence();
        boolean solution = isSubSequence.solution("abc", "ahbgdc");
        log.info("solution: {}", solution);
    }
}
