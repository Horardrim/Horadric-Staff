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
    }
}
