package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseWordsTest {
    @Test
    public void normalTest() {
        String result = new ReverseWords().solution("a   b  c   d e ");
        Assertions.assertTrue(result.equals("e d c b a"));
    }
}
