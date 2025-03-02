package com.horadrim.staff.ltcd.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SlideWindowMaxTest {

    @Test
    public void normalTest() {
        SlideWindowMax testInc = new SlideWindowMax();
        int [] sample = new int [] {1, 3, -1, -3, 5, 3, 6, 7};
        int sampleK = 3;
        int [] output = testInc.solution(sample, sampleK);
        Assertions.assertEquals(sample.length - sampleK + 1, output.length);
    }
}
