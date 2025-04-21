package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestCommonSubstringTest {
    @Test
    public void normalTest() {
        LongestCommonSubstring testInc = new LongestCommonSubstring();
        String common = testInc.solution("acdada", "bdad");
        Assertions.assertEquals("dad", common);
    }

    @Test
    public void noCommonSubstringTest() {
        LongestCommonSubstring testInc = new LongestCommonSubstring();
        String common = testInc.solution("acdada", "bt168t");
        Assertions.assertEquals("", common);
    }

    @Test
    public void multiCommonSubstringTest() {
        LongestCommonSubstring testInc = new LongestCommonSubstring();
        String common = testInc.solution("cbdad", "t168ca");
        Assertions.assertEquals("c", common);
    }
}
