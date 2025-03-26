package com.horadrim.staff.ltcd.array;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CombineSumQuestionTest {
    @Test
    public void normalTest() {
        CombineSumQuestion testInc = new CombineSumQuestion();
        int [] testArray = {2, 3, 6, 7};

        List<List<Integer>> result = testInc.solutionI(testArray, 7);
        Assertions.assertTrue(result.size() == 2);

        List<Integer> combI = result.get(0);
        List<Integer> combII = result.get(1);
        Assertions.assertTrue(combI.size() == 1);
        Assertions.assertTrue(combII.size() == 3);
        Assertions.assertTrue(combI.get(0) == 7);

        Assertions.assertTrue(combII.get(0) == 2);
        Assertions.assertTrue(combII.get(1) == 2);
        Assertions.assertTrue(combII.get(2) == 3);
    }
}
