package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestSubStringLengthTest {
    @Test
    public void normalTest() {
        LongestSubStringLength testInc = new LongestSubStringLength();
        Assertions.assertEquals(3, testInc.solution("abcabcbb"));
    }

    @Test
    public void normalTestII() {
        LongestSubStringLength testInc = new LongestSubStringLength();
        Assertions.assertEquals(3, testInc.solution("pwwkew"));
    }

    @Test
    public void normalTestIII() {
        LongestSubStringLength testInc = new LongestSubStringLength();
        Assertions.assertEquals(4, testInc.solution("awake"));
    }
}
