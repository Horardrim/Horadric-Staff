package com.horadrim.staff.ltcd.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LargestNumberTest {
    @Test
    public void normalTest() {
        int [] sample = new int[] {3, 30, 34, 5, 9};
        String result = new LargestNumber().solution(sample);
        Assertions.assertTrue(result.equals("9534330"));
    }

    @Test
    public void allZeroCase() {
        int [] sample = new int[] {0, 0, 0, 0, 0};
        String result = new LargestNumber().solution(sample);
        Assertions.assertTrue(result.equals("0"));
    }
}
