package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BPTreeTest {

    @Test
    public void normalTest() {
        BPTree testTree = new BPTree(3);
        Assertions.assertTrue(testTree.getRoot().isLeaf());
        testTree.insertOrUpdate(12, "feafeafea");
        Assertions.assertTrue(testTree.getRoot().isLeaf());
    }
}
