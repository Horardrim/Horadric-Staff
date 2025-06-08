package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstMissingPositiveTest {
    @Test
    public void normalTest() {
        int [] nums = new int [] {1, 2, 3, 4, 5, -1, 12, -8};
        int result = new FirstMissingPositive().solution(nums);
        Assertions.assertEquals(6, result);
    }

    @Test
    public void normalTestII() {
        int [] nums = new int [] {2, 3, 4, 5, -1, 12, -8};
        int result = new FirstMissingPositive().solution(nums);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void normalTestIII() {
        int [] nums = new int [] {1, 2, 4, 5, -1, 12, -8};
        int result = new FirstMissingPositive().solution(nums);
        Assertions.assertEquals(3, result);
    }
}
