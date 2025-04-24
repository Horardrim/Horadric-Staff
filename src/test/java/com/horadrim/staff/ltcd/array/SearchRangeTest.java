package com.horadrim.staff.ltcd.array;

import java.util.Map.Entry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchRangeTest {
    @Test
    public void normalTest() {
        int [] array = new int[] {1, 3, 3, 3, 4, 5};
        Entry<Integer, Integer> result = new SearchRange().solution(array, 3);
        Assertions.assertEquals(1, result.getKey());
        Assertions.assertEquals(3, result.getValue());
    }

    @Test
    public void noResultTest() {
        int [] array = new int[] {1, 3, 3, 3, 4, 5};
        Entry<Integer, Integer> result = new SearchRange().solution(array, 7);
        Assertions.assertEquals(-1, result.getKey());
        Assertions.assertEquals(-1, result.getValue());
    }

    @Test
    public void otherTest() {
        int [] array = new int[] {3, 3, 3, 3, 3, 3};
        Entry<Integer, Integer> result = new SearchRange().solution(array, 3);
        Assertions.assertEquals(0, result.getKey());
        Assertions.assertEquals(5, result.getValue());
    }
}
