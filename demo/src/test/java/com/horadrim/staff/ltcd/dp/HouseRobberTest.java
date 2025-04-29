package com.horadrim.staff.ltcd.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HouseRobberTest {
    @Test
    public void normalTest() {
        HouseRobber testInstance = new HouseRobber();
        int [] houses = {1, 2, 3, 1};
        int money = testInstance.solution(houses);
        Assertions.assertEquals(money, 4);
    }

    @Test
    public void moreHousesTest() {
        HouseRobber testInstance = new HouseRobber();
        int [] houses = {2, 7, 9, 3, 1};
        int money = testInstance.solution(houses);
        Assertions.assertEquals(money, 12);
    }

    @Test
    public void threeHouseRobTest() {
        HouseRobber testInstance = new HouseRobber();
        int [] houses1 = {2, 7, 9};
        int money1 = testInstance.solution(houses1);
        Assertions.assertEquals(money1, 11);

        int [] houses2 = {2, 12, 9};
        int money2 = testInstance.solution(houses2);
        Assertions.assertEquals(money2, 12);
    }

    @Test
    public void longHousesTest() {
        HouseRobber testInstance = new HouseRobber();
        int [] houses = {3, 1, 5, 9, 2, 1};
        int money = testInstance.solution(houses);
        Assertions.assertEquals(money, 13);
    }
}
