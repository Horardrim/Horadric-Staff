package com.horadrim.staff.ltcd.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxProfitStockIITest {
    @Test
    public void normalTest() {
        int[] testPrices = {7, 1 ,5 ,3 ,6 ,4};
        MaxProfitStockII testSolution = new MaxProfitStockII();
        int result = testSolution.solution(testPrices);
        Assertions.assertEquals(result, 7);
    }

    @Test
    public void zeroProfitTest() {
        int[] testPrices = {7, 6, 5, 4, 2, 1};
        MaxProfitStockII testSolution = new MaxProfitStockII();
        int result = testSolution.solution(testPrices);
        Assertions.assertEquals(result, 0);
    }
}
