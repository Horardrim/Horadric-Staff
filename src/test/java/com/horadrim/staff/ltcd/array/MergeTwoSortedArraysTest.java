package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeTwoSortedArraysTest {
    @Test
    public void normalTest() {
        MergeTwoSortedArrays testInc = new MergeTwoSortedArrays();
        int [] array1 = new int[] {1, 2, 3, 5, 7, 13, 14, 16};
        int [] array2 = new int[] {3, 4 ,5, 6, 8, 12};
        int [] result = testInc.solution(array1, array2);
        Assertions.assertEquals(array1.length + array2.length, result.length);
        Assertions.assertEquals(1, result[0]);
        Assertions.assertEquals(3, result[3]);
        Assertions.assertEquals(4, result[4]);
        Assertions.assertEquals(5, result[5]);
        Assertions.assertEquals(5, result[6]);
        Assertions.assertEquals(16, result[13]);
    }

    @Test
    public void cornerTest() {
        MergeTwoSortedArrays testInc = new MergeTwoSortedArrays();
        int [] array1 = new int[] {0, 1, 2};
        int [] array2 = new int[] {3, 4 ,5};
        int [] result = testInc.solution(array1, array2);
        Assertions.assertEquals(array1.length + array2.length, result.length);
        Assertions.assertEquals(0, result[0]);
        Assertions.assertEquals(3, result[3]);
        Assertions.assertEquals(5, result[5]);
    }
}
