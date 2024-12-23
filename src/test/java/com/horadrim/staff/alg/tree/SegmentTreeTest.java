package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SegmentTreeTest {

    private final int[] happyCaseArray = {1, 2, 3, 4, 5};

    private final int[] oneElementArray = {1};

    private final int[] emptyArray = {};

    private final int[] updateByIntervalArray = {1, 2, 3, 4, 5, 6};

    private final int[] longArray = {-1, 23, -32, 21, 65, 28, -131, 42, 84, 67, 95, 532, 74, 32, 19, 1312, 63, 454, 25};

    @Test
    public void happyCase() {
        SegmentTree testSegTree = new SegmentTree(happyCaseArray);
        Assertions.assertTrue(!testSegTree.isEmpty());
    }

    @Test
    public void emptyArrayCase() {
        SegmentTree testSegTree = new SegmentTree(emptyArray);
        Assertions.assertTrue(testSegTree.isEmpty());
    }

    @Test
    public void oneElementArrayTest() {
        SegmentTree testSegTree = new SegmentTree(oneElementArray);
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

    @Test
    public void updateByInterval_happy_case() {
        SegmentTree testSegTree = new SegmentTree(updateByIntervalArray);
        int base = 3;
        testSegTree.updateByInterval(1, 3, 0, 5, 1);
        Assertions.assertTrue(testSegTree.getFromTreeWithIndex(base) ==
            testSegTree.getFromTreeWithIndex(base << 1) + testSegTree.getFromTreeWithIndex((base << 1) + 1));
        Assertions.assertTrue(testSegTree.getFromTreeWithIndex(9) == 3);
    }
}
