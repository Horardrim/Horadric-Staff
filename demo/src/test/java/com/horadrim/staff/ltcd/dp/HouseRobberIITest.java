package com.horadrim.staff.ltcd.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HouseRobberIITest {
    @Test
    public void threeHouseRobTest() {
        HouseRobberII testInstance = new HouseRobberII();
        int [] houses1 = {2, 7, 9};
        int money = testInstance.solution(houses1);
        Assertions.assertEquals(money, 9);
    }

    @Test
    public void twoHouseRobTest() {
        HouseRobberII testInstance = new HouseRobberII();
        int [] houses1 = {7, 9};
        int money = testInstance.solution(houses1);
        Assertions.assertEquals(money, 9);
    }

    @Test
    public void normalRobTest() {
        HouseRobberII testInstance = new HouseRobberII();
        int [] houses1 = {2, 1, 2, 3, 1};
        int money = testInstance.solution(houses1);
        Assertions.assertEquals(money, 5);
    }
}
