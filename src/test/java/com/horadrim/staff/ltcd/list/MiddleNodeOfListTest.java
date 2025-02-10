package com.horadrim.staff.ltcd.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.utils.SimpleList;
import com.horadrim.staff.utils.SimpleList.SimpleListNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MiddleNodeOfListTest {

    @Test
    public void emptyNodeListTest() {
        SimpleList testList = new SimpleList();
        Assertions.assertEquals(null, testList.middleNode());
    }

    @Test
    public void oneNodeListTest() {
        SimpleList testList = new SimpleList();
        SimpleListNode head = testList.new SimpleListNode(1);
        testList.push(head);
        SimpleListNode middleNode = testList.middleNode();
        Assertions.assertEquals(head, middleNode);
        Assertions.assertEquals(head.getData(), middleNode.getData());
    }

    @Test
    public void twoNodesListTest() {
        SimpleList testList = new SimpleList();
        SimpleListNode head = testList.new SimpleListNode(1);
        SimpleListNode second = testList.new SimpleListNode(2);
        testList.push(head);
        testList.push(second);
        SimpleListNode middleNode = testList.middleNode();
        Assertions.assertEquals(second, middleNode);
        Assertions.assertEquals(second.getData(), middleNode.getData());
    }

    @Test
    public void threeNodesListTest() {
        SimpleList testList = new SimpleList();
        SimpleListNode head = testList.new SimpleListNode(1);
        SimpleListNode second = testList.new SimpleListNode(2);
        SimpleListNode third = testList.new SimpleListNode(3);
        testList.push(head);
        testList.push(second);
        testList.push(third);
        SimpleListNode middleNode = testList.middleNode();
        Assertions.assertEquals(second, middleNode);
        Assertions.assertEquals(second.getData(), middleNode.getData());
    }

    @Test
    public void fourNodesListTest() {
        SimpleList testList = new SimpleList();
        SimpleListNode head = testList.new SimpleListNode(1);
        SimpleListNode second = testList.new SimpleListNode(2);
        SimpleListNode third = testList.new SimpleListNode(3);
        SimpleListNode fourth = testList.new SimpleListNode(4);
        testList.push(head);
        testList.push(second);
        testList.push(third);
        testList.push(fourth);
        SimpleListNode middleNode = testList.middleNode();
        Assertions.assertEquals(third, middleNode);
        Assertions.assertEquals(third.getData(), middleNode.getData());
    }
}
