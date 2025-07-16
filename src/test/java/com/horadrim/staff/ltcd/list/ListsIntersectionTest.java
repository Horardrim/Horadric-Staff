package com.horadrim.staff.ltcd.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.alg.list.SimpleList;
import com.horadrim.staff.alg.list.SimpleList.SimpleListNode;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ListsIntersectionTest {
    @Test
    public void test_twoEmptyListTest() {
        SimpleList a = new SimpleList();
        SimpleList b = new SimpleList();
        Assertions.assertTrue(!a.intersectsWith(b));
    }

    @Test
    public void test_twoListsIntersects() {
        SimpleList a = new SimpleList();
        SimpleList b = new SimpleList();

        SimpleListNode intersectPoint = a.new SimpleListNode(4);

        a.push(a.new SimpleListNode(1));
        a.push(a.new SimpleListNode(2));
        a.push(intersectPoint);

        b.push(b.new SimpleListNode(1));
        b.push(b.new SimpleListNode(2));
        b.push(b.new SimpleListNode(3));
        b.push(intersectPoint);
        Assertions.assertTrue(a.intersectsWith(b));
    }

    @Test
    public void test_twoListsIntersectsAndHaveSameLength() {
        SimpleList a = new SimpleList();
        SimpleList b = new SimpleList();

        SimpleListNode intersectPoint = a.new SimpleListNode(4);

        a.push(a.new SimpleListNode(1));
        a.push(a.new SimpleListNode(2));
        a.push(intersectPoint);

        b.push(b.new SimpleListNode(1));
        b.push(b.new SimpleListNode(2));
        b.push(intersectPoint);
        Assertions.assertTrue(a.intersectsWith(b));
    }

    @Test
    public void test_twoListsDoNotIntersect() {
        SimpleList a = new SimpleList();
        SimpleList b = new SimpleList();

        SimpleListNode intersectPoint = a.new SimpleListNode(4);

        a.push(a.new SimpleListNode(1));
        a.push(a.new SimpleListNode(2));
        a.push(intersectPoint);

        b.push(b.new SimpleListNode(1));
        b.push(b.new SimpleListNode(2));
        Assertions.assertTrue(!a.intersectsWith(b));
    }
}
