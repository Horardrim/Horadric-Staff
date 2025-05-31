package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrefixStringTest {
    @Test
    public void normalTest() {
        String str = new String("iloveleetcode");
        String [] words = new String [] {"i","love","leetcode","apples"};
        Assertions.assertTrue(new PrefixString().solution(str, words));
    }

    @Test
    public void sadTest() {
        String str = new String("idonotloveleetcode");
        String [] words = new String [] {"i","love","leetcode","apples"};
        Assertions.assertTrue(!new PrefixString().solution(str, words));
    }
}
