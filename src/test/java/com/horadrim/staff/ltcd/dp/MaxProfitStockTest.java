package com.horadrim.staff.ltcd.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MaxProfitStockTest {
    @Test
    public void normalTest() {
        int[] testPrices = {1, 2, 3, 4, 5};
        MaxProfitStock testSolution = new MaxProfitStock();
        int result = testSolution.solution(testPrices);
        Assertions.assertEquals(result, 4);
    }

    @Test
    public void zeroProfitTest() {
        int[] testPrices = {5, 4, 3, 2, 1};
        MaxProfitStock testSolution = new MaxProfitStock();
        int result = testSolution.solution(testPrices);
        Assertions.assertEquals(result, 0);
    }

    @Test
    public void happyTestSolutionII() {
        int[] testPrices = {1, 2, 3, 4, 5};
        MaxProfitStock testSolution = new MaxProfitStock();
        int result = testSolution.solutionII(testPrices);
        Assertions.assertEquals(result, 4);
    }

    @Test
    public void normalTestSolutionII() {
        int[] testPrices = {2, 6, 1, 3, 1};
        MaxProfitStock testSolution = new MaxProfitStock();
        int result = testSolution.solutionII(testPrices);
        Assertions.assertEquals(result, 4);
    }

    @Test
    public void zeroProfitForSolutionIITest() {
        int[] testPrices = {5, 4, 3, 2, 1};
        MaxProfitStock testSolution = new MaxProfitStock();
        int result = testSolution.solutionII(testPrices);
        Assertions.assertEquals(result, 0);
    }
}
