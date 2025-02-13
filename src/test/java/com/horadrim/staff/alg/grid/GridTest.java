package com.horadrim.staff.alg.grid;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GridTest {
    @Test
    public void normalTest() {
        Grid testGrid = new Grid(0, 0);
        Assertions.assertEquals(2, testGrid.getX());
        Assertions.assertEquals(2, testGrid.getY());

        Grid testGridII = new Grid();
        Assertions.assertEquals(2, testGridII.getX());
        Assertions.assertEquals(2, testGridII.getY());
    }

    @Test
    public void setGridValueTest() {
        Grid testGrid = new Grid(4, 3);
        testGrid.setGridValue(0, 2, 5);
        Assertions.assertEquals(5, testGrid.getGridValue(0, 2));
    }

    @Test
    public void setGridValueExceptionTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Grid testGrid = new Grid(4, 3);
            testGrid.setGridValue(4, 3, -1);
        });
    }

    @Test
    public void getGridValueExceptionTest() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            Grid testGrid = new Grid(4, 3);
            testGrid.getGridValue(4, 3);
        });
    }
}
