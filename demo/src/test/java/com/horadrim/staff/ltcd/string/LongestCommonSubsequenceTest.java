package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestCommonSubsequenceTest {
    @Test
    public void normalTest() {
        LongestCommonSubsequence testInc = new LongestCommonSubsequence();
        String common = testInc.solution("teafheahtkabcdef", "poeudmzabcf");
        Assertions.assertEquals("eabcf", common);
    }

    @Test
    public void shortStringTest() {
        LongestCommonSubsequence testInc = new LongestCommonSubsequence();
        String common = testInc.solution("abcdef", "zabcf");
        Assertions.assertEquals("abcf", common);
    }
}
