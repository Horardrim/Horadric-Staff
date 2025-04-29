package com.horadrim.staff.ltcd.array;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KthMaxQuestionTest {
    @Test
    public void normalTest() {
        int[] testArray = {11, 33, 55, 22, 20, 44, 32, 16, 8};
        KthMaxQuestion testInstance = new KthMaxQuestion();
        int result = testInstance.solution(testArray, 2);
        Assertions.assertTrue(result == 44);
    }

    @Test
    public void emptyArrayTest() {
        int[] testArray = {};
        KthMaxQuestion testInstance = new KthMaxQuestion();
        Integer result = testInstance.solution(testArray, 2);
        Assertions.assertTrue(Objects.isNull(result));
    }
}
