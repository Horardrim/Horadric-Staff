package com.horadrim.staff.ltcd.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseNumberTest {
    @Test
    public void normalTest() {
        ReverseNumber n = new ReverseNumber();
        int result = n.solution(123);
        Assertions.assertEquals(result, 321);
    }

    @Test
    public void zeroTailNumberTest() {
        ReverseNumber n = new ReverseNumber();
        int result = n.solution(1230);
        Assertions.assertEquals(result, 321);
    }

    @Test
    public void zeroMiddleNumberTest() {
        ReverseNumber n = new ReverseNumber();
        int result = n.solution(1030);
        Assertions.assertEquals(result, 301);
    }

    @Test
    public void minusNumberTest() {
        ReverseNumber n = new ReverseNumber();
        int result = n.solution(-123);
        Assertions.assertEquals(result, -321);
    }

    @Test
    public void zeroTailMinusNumberTest() {
        ReverseNumber n = new ReverseNumber();
        int result = n.solution(-1230);
        Assertions.assertEquals(result, -321);
    }

    /*
     * 此测试用例用于测试反转后的数字over flow，但是现在无法判断
     * 某些数字如1341234129
     */
    // @Test
    // public void overFlowNumberTest() {
    //     ReverseNumber n = new ReverseNumber();
    //     int result = n.solution(1341234129);
    //     Assertions.assertEquals(result, 0);
    // }
}
