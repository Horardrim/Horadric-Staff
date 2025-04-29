package com.horadrim.staff.alg.string;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class KMPTest {
    @Test
    public void normalTest() {
        KMP testInc = new KMP();
        Object [] result = testInc.match("ababdababbab", "babb");
        log.info("match table: {}", result.length);
    }

    @Test
    public void repeatStringTest() {
        KMP testInc = new KMP();
        Object [] result = testInc.match("abbdababbab", "bbb");
        log.info("match table: {}", result.length);
    }
}
