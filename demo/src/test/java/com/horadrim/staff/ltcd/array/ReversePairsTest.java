package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReversePairsTest {
    @Test
    public void reversedRecordTest() {
        ReversePairs testInc = new ReversePairs();
        int result = testInc.solution(new int []{5, 4, 3, 2, 1});
        Assertions.assertEquals(10, result);
    }

    @Test
    public void orderedRecordTest() {
        ReversePairs testInc = new ReversePairs();
        int result = testInc.solution(new int []{1, 2, 3, 4, 5});
        Assertions.assertEquals(0, result);
    }

    @Test
    public void unorderedRecordTest() {
        ReversePairs testInc = new ReversePairs();
        int result = testInc.solution(new int []{1, 2, 3, 5, 4});
        Assertions.assertEquals(1, result);
    }

    @Test
    public void unorderedRecordTestII() {
        ReversePairs testInc = new ReversePairs();
        int result = testInc.solution(new int []{1, 2, 3, 5, 6, 4});
        Assertions.assertEquals(2, result);
    }
}
