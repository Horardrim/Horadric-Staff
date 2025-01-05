package com.horadrim.staff.alg.tree;


/*
 * This class current does not handle some exception like left index is greater than right index
 * Left index or right index is beyond the boundary. I only tested happy cases for the implement of segment tree.
 */
public class SegmentTree {

    private static final int BASE = 1;

    private int size;

    private int[] tree;

    private int[] mark;

    public SegmentTree(int[] nums) {
        this.size = nums.length;
        if (this.size <= 0) {
            return;
        }
        
        tree = new int[4 * size];
        mark = new int[4 * size];
        build(nums, 0, size - 1, BASE);
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public int getFromTreeWithIndex(int i) {
        return tree[i];
    }

    public int[] getTree() {
        return tree;
    }

    private void build(int[] nums, int start, int end, int base) {
        if (start == end) {
            tree[base] = nums[start];
            return;
        }

        int mid = (end - start) / 2 + start;
        build(nums, start, mid, 2 * base);
        build(nums, mid + 1, end, 2 * base + 1);
        pushUp(base);
    }

    public void singleUpdate(int index, int value) {
        if (index < 0 || index > this.size - 1) {
            return;
        }
        singleUpdate(index, value, 0, this.size - 1, BASE);
    }

    public void updateByInterval(int leftIndex, int rightIndex, int leftBoundary, int rightBoundary, int value) {
        updateByInterval(BASE, leftIndex, rightIndex, leftBoundary, rightBoundary, value);
    }

    public int query(int leftBoundary, int rightBoundary, int leftIndex, int rightIndex) {
        return query( leftBoundary, rightBoundary, leftIndex, rightIndex, BASE);
    }

    public int query(int leftBoundary, int rightBoundary, int index) {
        return query( leftBoundary, rightBoundary, index, index, BASE);
    }

    private int query(int leftBoundary, int rightBoundary, int leftIndex, int rightIndex, int base) {
        if (leftBoundary >= leftIndex && rightIndex >= rightBoundary) {
            return tree[base];
        }

        int m = (rightBoundary - leftBoundary) / 2 + leftBoundary;
        int ret = 0;
        if (leftIndex <= m) {
            ret += query(leftBoundary, m, leftIndex, rightIndex, base << 1);
        }

        if (rightIndex > m) {
            ret += query(m + 1, rightBoundary, leftIndex, rightIndex, base << 1 | 1);
        }

        return ret;
    }

    private void updateByInterval(int base, int leftIndex, int rightIndex, int leftBoundary, int rightBoundary, int value) {
        if (leftIndex <= leftBoundary && rightIndex >= rightBoundary) {
            mark[base] += value;
            tree[base] += value * (rightBoundary - leftBoundary + 1);
            return;
        }

        pushDown(base, rightBoundary - leftBoundary + 1);
        int m = (rightBoundary - leftBoundary) / 2 + leftBoundary;
        if (leftIndex <= m) {
            updateByInterval(base << 1, leftIndex, rightIndex, leftBoundary, m, value);
        }
        if (m < rightIndex) {
            updateByInterval(base << 1 | 1, leftIndex, rightIndex, m + 1, rightBoundary, value);
        }
        pushUp(base);
    }

    private void singleUpdate(int index, int value, int start, int end, int base) {
        if (start == end) {
            tree[base] = value;
            return;
        }

        int mid = (end - start) / 2 + start;
        if (index <= mid) {
            singleUpdate(index, value, start, mid, base << 1);
        } else {
            singleUpdate(index, value, mid + 1, end, base << 1 | 1);
        }

        pushUp(base);
    }

    private void pushDown(int base, int m) {
        if (mark[base] != 0) {
            mark[base << 1] += mark[base];
            mark[base << 1 | 1] += mark[base];
            tree[base << 1] += mark[base] * (m - (m >> 1));
            tree[base << 1 | 1] += mark[base] * (m >> 1);
            mark[base] = 0;
        }
    }

    private void pushUp(int base) {
        tree[base] = tree[base << 1] + tree[base << 1 | 1];
    }
}
