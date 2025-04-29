package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecodeStringTest {
    @Test
    public void normalTest() {
        DecodeString testInc = new DecodeString();
        String decodeString = testInc.solution("2[abc]");
        Assertions.assertTrue(decodeString.equals("abcabc"));
    }

    @Test
    public void complicatedTest() {
        DecodeString testInc = new DecodeString();
        String decodeString = testInc.solution("2[ab10[dd]c]");
        Assertions.assertTrue(decodeString.equals("abddddddddddddddddddddcabddddddddddddddddddddc"));
    }
}
