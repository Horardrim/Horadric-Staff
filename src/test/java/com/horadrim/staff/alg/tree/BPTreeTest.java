package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BPTreeTest {

    @Test
    public void normalTest() {
        BPTree testTree = new BPTree(3);
        Assertions.assertTrue(testTree.getRoot().isLeaf());
        testTree.insertOrUpdate(12, "feafeafea");
        testTree.insertOrUpdate(13, "feafeafbbbb");
        testTree.insertOrUpdate(14, "eafbbbb");
        testTree.insertOrUpdate(15, "eafbbbbfeafe");
        Assertions.assertEquals(testTree.get(15), "eafbbbbfeafe");
        Assertions.assertEquals(testTree.get(14), "eafbbbb");
        Assertions.assertTrue(!testTree.getRoot().isLeaf());
    }

    @Test
    public void rangeSearchTest() {
        BPTree testTree = new BPTree(3);
        testTree.insertOrUpdate(12, "ab");
        testTree.insertOrUpdate(13, "cd");
        testTree.insertOrUpdate(14, "ef");
        testTree.insertOrUpdate(15, "gh");
        testTree.insertOrUpdate(16, "ij");
        testTree.insertOrUpdate(17, "kl");
        testTree.insertOrUpdate(18, "mn");
        testTree.insertOrUpdate(19, "op");
        testTree.insertOrUpdate(20, "qr");
        testTree.insertOrUpdate(21, "st");
        testTree.insertOrUpdate(22, "uv");

        List<Object> result = testTree.rangeSearch(13, 15);
        Assertions.assertEquals(3, result.size());

        result = testTree.rangeSearch(99, 100);
        Assertions.assertEquals(0, result.size());

        result = testTree.rangeSearch(4, 13);
        Assertions.assertEquals(2, result.size());
    }
}
