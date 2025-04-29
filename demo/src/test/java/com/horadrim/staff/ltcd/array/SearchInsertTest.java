package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SearchInsertTest {
    @Test
    public void normalTest() {
        int [] nums = new int[] {2, 4, 6, 8, 10};
        int result = new SearchInsert().solution(nums, 2);
        Assertions.assertEquals(0, result);
        result = new SearchInsert().solution(nums, 1);
        Assertions.assertEquals(-1, result);

        result = new SearchInsert().solution(nums, 10);
        Assertions.assertEquals(4, result);

        result = new SearchInsert().solution(nums, 11);
        Assertions.assertEquals(4, result);

        result = new SearchInsert().solution(nums, 9);
        Assertions.assertEquals(3, result);
    }
}
