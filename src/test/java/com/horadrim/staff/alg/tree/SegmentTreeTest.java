package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SegmentTreeTest {

    private final int[] happyCaseArray = {1, 2, 3, 4, 5};

    private final int[] longArray = {-1, 23, -32, 21, 65, 28, -131, 42, 84, 67, 95, 532, 74, 32, 19, 1312, 63, 454, 25};

    @Test
    public void happyCase() {
        SegmentTree testSegTree = new SegmentTree(happyCaseArray);
        Assertions.assertTrue(!testSegTree.isEmpty());
    }

    @Test
    public void longArrayTest() {
        SegmentTree testSegTree = new SegmentTree(longArray);
        Assertions.assertTrue(!testSegTree.isEmpty());
    }

    @Test
    public void singleUpdateTest_happy_case() {
        SegmentTree testSegTree = new SegmentTree(happyCaseArray);
        testSegTree.singleUpdate(0, 16);
    }
}
