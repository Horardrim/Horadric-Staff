package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SecondGreatestInArrayTest {
    @Test
    public void normalTest() {
        SecondGreatestInArray testInc = new SecondGreatestInArray();
        int[] array = new int[] {3, 2, 1, 4, 5};
        int result = testInc.solution(array);
        Assertions.assertEquals(4, result);
        result = testInc.solutionII(array);
        Assertions.assertEquals(4, result);
    }

    @Test
    public void noSecondGreatestTest() {
        SecondGreatestInArray testInc = new SecondGreatestInArray();
        int[] array = new int[] {3, 3, 3, 3, 3};
        int result = testInc.solution(array);
        Assertions.assertEquals(3, result);
        result = testInc.solutionII(array);
        Assertions.assertEquals(3, result);
    }

    @Test
    public void otherTest() {
        SecondGreatestInArray testInc = new SecondGreatestInArray();
        int[] array = new int[] {3, 6, 3, 3, 3};
        int result = testInc.solution(array);
        Assertions.assertEquals(3, result);
        result = testInc.solutionII(array);
        Assertions.assertEquals(3, result);
    }
}
