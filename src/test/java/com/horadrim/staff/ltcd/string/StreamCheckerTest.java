package com.horadrim.staff.ltcd.string;


import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamCheckerTest {
    @Test
    public void normalTest() {
        StreamChecker checker = new StreamChecker();
        checker.solution(new String [] {"apply", "apple"});
    }
}
