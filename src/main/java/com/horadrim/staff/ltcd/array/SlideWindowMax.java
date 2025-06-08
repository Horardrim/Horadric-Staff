package com.horadrim.staff.ltcd.array;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Tag: 单调栈
 */
public class SlideWindowMax {
    public int [] solution(int [] nums, int k) {
        if (k > nums.length || k == 0) {
            return null;
        }

        int [] output = new int [nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            // 从队列头部移除过期元素
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            // 从队尾移除较小元素
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 添加当前元素到队尾，一般大的元素会放在头部
            deque.offer(i);
            // 获取最大值
            if (i >= k - 1) {
                output[i - k + 1] = nums[deque.peek()];
            }
        }

        return output;
    }

    public int [] solutionII(int [] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
