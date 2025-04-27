package com.horadrim.staff.ltcd.grid;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.alg.grid.Grid;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrangeRottingTest {
    @Test
    public void normalTest() {
        OrangeRotting testInstance = new OrangeRotting();
        Grid oranges = new Grid(3, 4);
        oranges.setGridValue(0, 0, 2);
        oranges.setGridValue(0, 1, 1);
        oranges.setGridValue(2, 2, 1);
        Assertions.assertEquals(-1, testInstance.solution(oranges));
    }

    @Test
    public void allOrangeRottenTest() {
        OrangeRotting testInstance = new OrangeRotting();
        Grid oranges = new Grid(3, 4);
        oranges.setGridValue(0, 0, 2);
        oranges.setGridValue(0, 1, 1);
        oranges.setGridValue(1, 1, 1);
        oranges.setGridValue(1, 2, 1);
        oranges.setGridValue(1, 3, 1);
        oranges.setGridValue(2, 2, 1);
        oranges.setGridValue(2, 3, 1);
        Assertions.assertEquals(5, testInstance.solution(oranges));
    }

    @Test
    public void emptyOrangeGridTest() {
        OrangeRotting testInstance = new OrangeRotting();
        Grid oranges = new Grid(3, 4);
        Assertions.assertEquals(0, testInstance.solution(oranges));
    }
}
