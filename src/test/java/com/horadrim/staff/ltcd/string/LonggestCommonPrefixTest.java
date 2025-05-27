package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LonggestCommonPrefixTest {
    @Test
    public void noCommonPrefixTest() {
        String [] testStrings = new String[] {"ab", "cd", "ef"};
        String result = new LonggestCommonPrefix().solution(testStrings);
        Assertions.assertTrue(result.isEmpty());
        Assertions.assertTrue(result.isBlank());
    }

    @Test
    public void hasCommonPrefixTest() {
        String [] testStrings = new String[] {"ab", "abcd", "abef"};
        String result = new LonggestCommonPrefix().solution(testStrings);
        Assertions.assertTrue(result.equals("ab"));
    }
}
