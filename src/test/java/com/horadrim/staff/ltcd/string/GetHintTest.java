package com.horadrim.staff.ltcd.string;

import java.util.Objects;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GetHintTest {
    @Test
    public void normalTest() {
        String result = new GetHint().solution("1807", "7810");
        Assertions.assertTrue(result.equals("1A3B"));
    }

    @Test
    public void illegalTest() {
        String result = new GetHint().solution("1807", "7810121");
        Assertions.assertTrue(Objects.isNull(result));
    }

    @Test
    public void duplicatedCharSecretTest() {
        String result = new GetHint().solution("1817", "1211");
        Assertions.assertTrue(result.equals("2A0B"));
    }

    @Test
    public void duplicatedCharSecretTestII() {
        String result = new GetHint().solution("1817", "1131");
        Assertions.assertTrue(result.equals("1A1B"));
    }
}
