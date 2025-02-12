package com.horadrim.staff.alg.list;

public class SimpleList {
    public SimpleList() {
        count = 0;
        head = null;
        tail = null;
    }

    public SimpleListNode getNext() {
        return head.getNext();
    }

    public SimpleListNode head() {
        return head;
    }

    public void push(SimpleListNode node) {
        if (count == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        ++count;
    }

    public SimpleList batchPush(SimpleListNode node) {
        if (count == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        ++count;
        return this;
    }

    public SimpleListNode getNodeByIndex(int index) {
        if (index <= 0) {
            return null;
        }

        SimpleListNode n = head;
        for (int i = 1; i < index; ++i) {
            if (n == null) {
                return null;
            }
            n = n.next;
        }

        return n;
    }

    private SimpleListNode[] reverse(SimpleListNode head, SimpleListNode tail) {
        SimpleListNode prev = tail.next, p = head;
        while(prev != tail) {
            SimpleListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }

        return new SimpleListNode[]{tail, head};
    }

    public void reverseInKGroup(int group) {
        if (count == 0) {
            return;
        }

        SimpleListNode dummyHead = new SimpleListNode(head.getData());
        dummyHead.next = head;
        SimpleListNode prev = head;
        SimpleListNode slow = dummyHead;

        while (prev != null) {
            SimpleListNode fast = slow;
            for (int i = 0; i < group; ++i) {
                fast = fast.next;
                if (fast == null) {
                    head = dummyHead.next;
                    return;
                }
            }

            SimpleListNode tail = fast.next;
            SimpleListNode start = slow;
            SimpleListNode[] reversedNodes = reverse(prev, fast);
            start.next = reversedNodes[0];
            reversedNodes[1].next = tail;
            prev = tail;
            slow = reversedNodes[1];
        }

        head = dummyHead.next;
    }

    public SimpleListNode middleNode() {
        SimpleListNode slow = this.head;
        SimpleListNode fast = this.head;

        while (fast != null && fast.next != null) {
            // slow point move forward by one step.
            slow = slow.next;
            // fast point move forward by two steps.
            fast = fast.next.next;
        }

        return slow;
    }

    private SimpleListNode head;

    private SimpleListNode tail;

    private int count;

    public class SimpleListNode {
        public SimpleListNode() {
            next = null;
            data = -1;
        }

        public SimpleListNode(int data) {
            this.data = data;
            next = null;
        }

        public SimpleListNode getNext() {
            return next;
        }

        public int getData() {
            return data;
        }

        private int data;

        private SimpleListNode next;
    }
}
