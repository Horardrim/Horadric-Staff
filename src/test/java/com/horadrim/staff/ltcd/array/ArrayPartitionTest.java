package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArrayPartitionTest {
    @Test
    public void normalTest() {
        ArrayPartition testInc = new ArrayPartition();
        int [] array = {7, 12, 5, 7, 8, 3, 1, 4, 2};
        int [] output = testInc.solution(7, array);
        Assertions.assertEquals(2, output[0]);
        Assertions.assertEquals(5, output[1]);
        Assertions.assertEquals(4, output[2]);
        Assertions.assertEquals(3, output[3]);
        Assertions.assertEquals(1, output[4]);
        Assertions.assertEquals(7, output[5]);
        Assertions.assertEquals(7, output[6]);
        Assertions.assertEquals(8, output[7]);
        Assertions.assertEquals(12, output[8]);
    }

    @Test
    public void targetNotIncludedInArray() {
        int [] array = {7, 12, 5, 7, 8, 3, 1, 4, 2};
        int [] output = new ArrayPartition().solution(6, array);
        Assertions.assertEquals(2, output[0]);
        Assertions.assertEquals(4, output[1]);
        Assertions.assertEquals(5, output[2]);
        Assertions.assertEquals(1, output[3]);
        Assertions.assertEquals(3, output[4]);
        Assertions.assertEquals(8, output[5]);
        Assertions.assertEquals(7, output[6]);
        Assertions.assertEquals(12, output[7]);
        Assertions.assertEquals(7, output[8]);
    }
}
