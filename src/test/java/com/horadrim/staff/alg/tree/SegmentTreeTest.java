package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SegmentTreeTest {

    @Test
    public void happyCase() {
        int[] testArray = {1, 2, 3, 4, 5};
        SegmentTree testSegTree = new SegmentTree(testArray);
        Assertions.assertTrue(!testSegTree.isEmpty());
    }
}
