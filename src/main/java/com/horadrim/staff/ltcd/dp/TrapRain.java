package com.horadrim.staff.ltcd.dp;

import java.util.Deque;
import java.util.LinkedList;

public class TrapRain {
    public int solutionI(int [] height) {
        int rain = 0;
        int length = height.length;
        int [] leftMaxHeight = new int[length];
        leftMaxHeight[0] = height[0];
        int [] rightMaxHeight = new int[length];
        rightMaxHeight[length - 1] = height[length - 1];

        for (int i = 1; i < length; ++i) {
            leftMaxHeight[i] = Math.max(leftMaxHeight[i - 1], height[i]);
        }

        for (int i = length - 2; i > -1; --i) {
            rightMaxHeight[i] = Math.max(rightMaxHeight[i + 1], height[i]);
        }

        for (int i = 0; i < length; ++i) {
            rain += Math.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        }
        return rain;
    }

    public int solutionII(int [] height) {
        int rain = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                rain += currWidth * currHeight;
            }
            stack.push(i);
        }

        return rain;
    }
}
