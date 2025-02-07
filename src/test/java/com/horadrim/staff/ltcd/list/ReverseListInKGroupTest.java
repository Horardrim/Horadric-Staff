package com.horadrim.staff.ltcd.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.utils.SimpleList;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReverseListInKGroupTest {
    @Test
    public void normalTest() {
        ReverseListInKGroup testInstance = new ReverseListInKGroup();
        SimpleList list = constructSimpleTestList();
        testInstance.solution(list, 2);
        Assertions.assertEquals(list.getNodeByIndex(1).getData(), 4);
    }

    @Test
    public void normalTestII() {
        ReverseListInKGroup testInstance = new ReverseListInKGroup();
        SimpleList list = constructIVElementsTestList();
        testInstance.solution(list, 3);
        Assertions.assertEquals(list.getNodeByIndex(1).getData(), 5);
    }

    @Test
    public void reverseFullListTest() {
        ReverseListInKGroup testInstance = new ReverseListInKGroup();
        SimpleList list = constructSimpleTestList();
        testInstance.solution(list, 3);
        Assertions.assertEquals(list.getNodeByIndex(1).getData(), 5);
        Assertions.assertEquals(list.getNodeByIndex(3).getData(), 3);
    }

    @Test
    public void kIsGTListCount() {
        ReverseListInKGroup testInstance = new ReverseListInKGroup();
        SimpleList list = constructSimpleTestList();
        testInstance.solution(list, 4);
        Assertions.assertEquals(list.getNodeByIndex(1).getData(), 3);
        Assertions.assertEquals(list.getNodeByIndex(3).getData(), 5);
    }

    @Test
    public void reverseByMultipleTurnsTest() {
        ReverseListInKGroup testInstance = new ReverseListInKGroup();
        SimpleList list = constructVElementsTestList();
        testInstance.solution(list, 2);
        Assertions.assertEquals(list.getNodeByIndex(1).getData(), 4);
        Assertions.assertEquals(list.getNodeByIndex(2).getData(), 3);
        Assertions.assertEquals(list.getNodeByIndex(3).getData(), 6);
    }

    private SimpleList constructSimpleTestList() {
        SimpleList list = new SimpleList();
        list.batchPush(list.new SimpleListNode(3))
            .batchPush(list.new SimpleListNode(4))
            .batchPush(list.new SimpleListNode(5));

        return list;
    }

    private SimpleList constructIVElementsTestList() {
        SimpleList list = new SimpleList();
        list.batchPush(list.new SimpleListNode(3))
            .batchPush(list.new SimpleListNode(4))
            .batchPush(list.new SimpleListNode(5))
            .batchPush(list.new SimpleListNode(6));

        return list;
    }

    private SimpleList constructVElementsTestList() {
        SimpleList list = new SimpleList();
        list.batchPush(list.new SimpleListNode(3))
            .batchPush(list.new SimpleListNode(4))
            .batchPush(list.new SimpleListNode(5))
            .batchPush(list.new SimpleListNode(6))
            .batchPush(list.new SimpleListNode(7));

        return list;
    }
}
