package com.horadrim.staff.ltcd.array;

public class SecondGreatestInArray {
    
    /*
     * 通过遍历数组比较初始的最大值和第二大值
     */
    int solution(int[] array) {
        if (array.length <= 1) {
            System.out.println("length is less than 2. return");
            return Integer.MIN_VALUE;
        }
        int greatest = array[0];
        int second = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > second && array[i] <= greatest) {
                second = array[i];
            } else if (array[i] > greatest) {
                second = greatest;
                greatest = array[i];
            }
        }

        if (second == greatest) {
            System.out.println("There is no second greatest number, return " + second);
        }

        return second;
    }

    /*
     * 通过两次冒泡排序得出数组中第二大数
     */
    int solutionII(int[] array) {
        if (array.length <= 1) {
            System.out.println("length is less than 2. return");
            return Integer.MIN_VALUE;
        }
        int result = Integer.MIN_VALUE;

        for (int i = 1; i < array.length; ++i) {
            int tmp = array[i - 1];
            if (tmp > array[i]) {
                array[i - 1] = array[i];
                array[i] = tmp;
            }
        }

        for (int i = 1; i < array.length - 1; ++i) {
            int tmp = array[i - 1];
            if (tmp > array[i]) {
                array[i - 1] = array[i];
                array[i] = tmp;
            }
        }

        result = array[array.length - 2];
        if (result == array[array.length - 1]) {
            System.out.println("There is no second greatest number, return " + result);
        }

        return result;
    }
}
