package com.horadrim.staff.leetcode.list;

public class MergeKSortedLists {
    
    public ListNode resolution(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode dummyHead = result;
        int listCount = lists.length;
        int nullCounter = 0;

        while(true) {
            int mark = 0;
            nullCounter = 0;
            ListNode nodeToInsert = lists[0];
            for (int i = 0; i < listCount; ++i) {
                ListNode head = lists[i];
                if (head != null && nodeToInsert != null
                    && nodeToInsert.getData() > head.getData()) {
                    nodeToInsert = head;
                    mark = i;
                }

                if (head == null) {
                    ++nullCounter;
                }

                if (nodeToInsert == null) {
                    mark = (i + 1) % listCount;
                    nodeToInsert = lists[mark];
                    
                }
            }

            if (nullCounter == listCount) {
                break;
            }

            dummyHead.next = new ListNode(lists[mark].getData());
            dummyHead = dummyHead.next;
            lists[mark] = lists[mark].next;
        }

        return result.next;
    }

    public ListNode getReversedKthNode(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        int offset = 0;
        for (int i = 0; i < k; ++i) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }

        while(fast.next != null) {
            offset = 0;
            for (int i = 0; i < k; ++i) {
                if (fast.next != null) {
                    fast = fast.next;
                    ++offset;
                } else {
                    break;
                }
            }
    
            for (int i = 0; i < offset; ++i) {
                slow = slow.next;
            }
        }

        return slow.next;
    }

    public class ListNode {
        public ListNode() {
            this.next = null;
        }

        public ListNode(int data) {
            this.next = null;
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public ListNode next;

        private int data;
    }
}
