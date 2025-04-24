package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

import java.util.Map.Entry;

@Slf4j
public class NumberOfPairsTest {
    @Test
    public void normalTest() {
        int [] nums = new int[] {1, 2, 3, 4, 5, 6};
        Entry<Integer, Integer> result = new NumberOfPairs().solution(nums);
        Assertions.assertEquals(0, result.getKey());
        Assertions.assertEquals(6, result.getValue());

        result = new NumberOfPairs().solutionII(nums);
        Assertions.assertEquals(0, result.getKey());
        Assertions.assertEquals(6, result.getValue());
    }

    @Test
    public void secondTest() {
        int [] nums = new int[] {1, 2, 4, 2, 3, 4, 3, 5, 4, 6, 3, 4};
        Entry<Integer, Integer> result = new NumberOfPairs().solution(nums);
        Assertions.assertEquals(4, result.getKey());
        Assertions.assertEquals(4, result.getValue());

        result = new NumberOfPairs().solutionII(nums);
        Assertions.assertEquals(4, result.getKey());
        Assertions.assertEquals(4, result.getValue());
    }
}
