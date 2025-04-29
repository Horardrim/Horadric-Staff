package com.horadrim.staff.ltcd.list;

public class MergeKSortedLists {
    
    public ListNode resolution(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode dummyHead = result;
        int listCount = lists.length;

        while(true) {
            // 用于标记哪个链表的头节点的值最小
            int mark = 0;
            // 用于计算链表数组中节点都被遍历的链表个数有几个
            int nullCounter = 0;
            ListNode nodeToInsert = lists[0];

            // 对每个链表的第一个节点的值进行比较
            for (int i = 0; i < listCount; ++i) {
                ListNode head = lists[i];
                // 从每个链表中找到值最小的节点并且赋给nodeToInsert
                // 并且将mark的指向该链表的索引
                if (head != null && nodeToInsert != null
                    && nodeToInsert.getData() > head.getData()) {
                    nodeToInsert = head;
                    mark = i;
                }

                // nullCounter加1来计算有几个链表其所有的节点都被遍历
                if (head == null) {
                    ++nullCounter;
                }

                // 链表中的节点已经都遍历了，指向下一个链表的头节点
                if (nodeToInsert == null) {
                    mark = (i + 1) % listCount;
                    nodeToInsert = lists[mark];
                    
                }
            }

            // 如果nullCounter == listCount则所有链表均已经遍历
            if (nullCounter == listCount) {
                break;
            }

            dummyHead.next = new ListNode(lists[mark].getData());
            dummyHead = dummyHead.next;
            // 将链表的头指向下一个节点
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
