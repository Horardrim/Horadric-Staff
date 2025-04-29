package com.horadrim.staff.alg.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuickSortTest {

    @Test
    public void normalSortTest() {
        int[] testArray = {11, 33, 55, 22, 20, 44, 32, 16, 8};
        QuickSort testInstance = new QuickSort();
        testInstance.sort(testArray);
        Assertions.assertTrue(testArray[0] == 8);
    }

    @Test
    public void dupElementSortTest() {
        int[] testArray = {11, 33, 55, 22, 20, 44, 32, 11, 8};
        QuickSort testInstance = new QuickSort();
        testInstance.sort(testArray);
        Assertions.assertTrue(testArray[1] == 11);
        Assertions.assertTrue(testArray[2] == 11);
    }

    @Test
    public void twoElementSortTest() {
        int[] testArray = {11, 11};
        QuickSort testInstance = new QuickSort();
        testInstance.sort(testArray);
        Assertions.assertTrue(testArray[1] == 11);
        Assertions.assertTrue(testArray[0] == 11);
    }

    @Test
    public void emptyElementSortTest() {
        int[] testArray = {};
        QuickSort testInstance = new QuickSort();
        testInstance.sort(testArray);
        Assertions.assertTrue(testArray.length == 0);
    }
}
