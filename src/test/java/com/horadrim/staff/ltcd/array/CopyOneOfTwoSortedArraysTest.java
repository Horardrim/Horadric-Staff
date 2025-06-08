package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CopyOneOfTwoSortedArraysTest {
    @Test
    public void normalTestI() {
        int [] a = new int [] {1, 2, 3, 4, 5, 6};
        int [] b = new int [] {3, 4};
        int [] result = new CopyOneOfTwoSortedArrays().solution(a, b);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
        Assertions.assertEquals(5, result[2]);
        Assertions.assertEquals(6, result[3]);
        Assertions.assertEquals(a.length, result.length);
    }

    @Test
    public void normalTestII() {
        int [] a = new int [] {1, 2, 3, 4, 5};
        int [] b = new int [] {4, 5, 6, 7};
        int [] result = new CopyOneOfTwoSortedArrays().solution(a, b);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
        Assertions.assertEquals(3, result[2]);
        Assertions.assertEquals(a.length, result.length);
    }

    @Test
    public void normalTestIII() {
        int [] a = new int [] {1, 2, 3, 4, 5};
        int [] b = new int [] {6, 7};
        int [] result = new CopyOneOfTwoSortedArrays().solution(a, b);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
        Assertions.assertEquals(3, result[2]);
        Assertions.assertEquals(4, result[3]);
        Assertions.assertEquals(5, result[4]);
        Assertions.assertEquals(a.length, result.length);
    }

    @Test
    public void normalTestIV() {
        int [] a = new int [] {1, 2, 3, 4, 5};
        int [] b = new int [] {-2, -1};
        int [] result = new CopyOneOfTwoSortedArrays().solution(a, b);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(2, result[1]);
        Assertions.assertEquals(3, result[2]);
        Assertions.assertEquals(4, result[3]);
        Assertions.assertEquals(5, result[4]);
        Assertions.assertEquals(a.length, result.length);
    }
}
