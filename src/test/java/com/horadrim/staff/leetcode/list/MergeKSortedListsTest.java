package com.horadrim.staff.leetcode.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MergeKSortedListsTest {

    @Test
    void normalTest() {
        MergeKSortedLists testInstance = new MergeKSortedLists();
        MergeKSortedLists.ListNode[] lists = generateSortedLists(testInstance);
        MergeKSortedLists.ListNode node1 = testInstance.getReversedKthNode(lists[0], 2);
        MergeKSortedLists.ListNode node2 = testInstance.getReversedKthNode(lists[0], 1);
        Assertions.assertEquals(node1.getData(), 15);
        Assertions.assertEquals(node2.getData(), 16);
        MergeKSortedLists.ListNode result = testInstance.resolution(lists);
        Assertions.assertEquals(result.getData(), 2);
        Assertions.assertEquals(result.next.getData(), 3);
        Assertions.assertEquals(testInstance.getReversedKthNode(result, 1).getData(), 42);
        Assertions.assertEquals(testInstance.getReversedKthNode(result, 2).getData(), 42);
        Assertions.assertEquals(testInstance.getReversedKthNode(result, 3).getData(), 41);
    }

    private MergeKSortedLists.ListNode[] generateSortedLists(MergeKSortedLists instance) {

        MergeKSortedLists.ListNode[] lists = {null, null, null, null, null, null};
        lists[0] = generateSortedList(instance, 2, 4, 6, 12, 15, 16);
        lists[1] = generateSortedList(instance, 4, 6, 15, 16);
        lists[2] = generateSortedList(instance, 8, 14, 16, 22, 25, 26, 34, 36, 41, 42);
        lists[3] = generateSortedList(instance, 3, 4, 6, 12, 16, 16, 24, 26);
        lists[4] = generateSortedList(instance, 5, 7, 12, 12);
        lists[5] = generateSortedList(instance, 8, 14, 14, 17, 22, 25, 25, 26, 41, 42);

        return lists;
    }

    private MergeKSortedLists.ListNode generateSortedList(MergeKSortedLists instance, int... listElements) {
        MergeKSortedLists.ListNode dummyHead = instance.new ListNode();
        MergeKSortedLists.ListNode head = dummyHead;
        for (int i : listElements) {
            MergeKSortedLists.ListNode node = instance.new ListNode(i);
            head.next = node;
            head = head.next;
        }

        return dummyHead.next;
    }
}
