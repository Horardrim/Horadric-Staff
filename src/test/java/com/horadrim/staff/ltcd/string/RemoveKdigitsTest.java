package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RemoveKdigitsTest {
    @Test
    public void normalTest() {
        String num = new String("12345264");
        String result = new RemoveKdigits().solution(num, 4);
        Assertions.assertTrue(result.equals("1224"));
    }
}
