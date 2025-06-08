package com.horadrim.staff.ltcd.dp;

import java.util.Deque;
import java.util.LinkedList;

/*
 * Tag: 单调栈
 */
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


    /*
     * 维护一个类似一下图形的单调栈
     * |__
     * |  |__
     * |  |  |__
     * |  |  |  |
     * |__|__|__|___________
     * 
     * 当出现一个高度大于其左边高度
     * |__       __
     * |  |__   |  |
     * |  |  |__|  |
     * |  |  |  |  |
     * |__|__|__|__|_________
     * 
     * 计算该高度最左边的可储水的高度如'**'
     * |__       __
     * |  |__   |  |
     * |  |  |**|  |
     * |  |  |  |  |
     * |__|__|__|__|_________
     * 
     * 因为当前高度也大于次最左边高度边缘，同时也要计算该高度次最左边可储水的高度如'//'
     * |__       __
     * |  |// //|  |
     * |  |  |**|  |
     * |  |  |  |  |
     * |__|__|__|__|_________
     */
    public int solutionII(int [] height) {
        int rain = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            // 当当前高度大于栈中的高度且栈不为空时
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 从队列的头部获取当前高度左边的高度，也就是底部的
                int top = stack.pop();

                if (stack.isEmpty()) {
                    break;
                }

                // 从队列的头部获取底部左边的高度，也就是左边的边缘高度
                int left = stack.peek();
                // 计算极端宽度
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                rain += currWidth * currHeight;
            }

            // 将当前高度的index插入栈的头部，每当高度小于栈中的高度时
            stack.push(i);
        }

        return rain;
    }
}
