package com.horadrim.staff.ltcd.array;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreeSumTest {
    @Test
    public void normalTest() {
        ThreeSumQuestion testInc = new ThreeSumQuestion();
        int [] input = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = testInc.solution(input);
        Assertions.assertTrue(ans.size() == 2);

        List<Integer> ansI = ans.get(0);
        List<Integer> ansII = ans.get(1);

        Assertions.assertTrue(ansI.size() == 3);
        Assertions.assertTrue(ansII.size() == 3);

        Assertions.assertTrue(ansI.get(0) == -1);
        Assertions.assertTrue(ansII.get(0) == -1);

        Assertions.assertTrue(ansI.get(1) == -1);
        Assertions.assertTrue(ansII.get(1) == 0);

        Assertions.assertTrue(ansI.get(2) == 2);
        Assertions.assertTrue(ansII.get(2) == 1);
    }
}
