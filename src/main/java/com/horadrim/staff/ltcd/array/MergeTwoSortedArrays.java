package com.horadrim.staff.ltcd.array;

public class MergeTwoSortedArrays {
    int [] solution(int [] array1, int [] array2) {
        int [] result = new int[array1.length + array2.length];

        int p1 = 0;
        int p2 = 0;
        while (p1 < array1.length || p2 <  array2.length) {
            int cur = Integer.MIN_VALUE;

            if (p1 == array1.length) {
                cur = array2[p2++];
            } else if (p2 == array2.length) {
                cur = array1[p1++];
            } else if (array1[p1] > array2[p2]) {
                cur = array2[p2];
                ++p2;
            } else if (array1[p1] <= array2[p2]) {
                cur = array1[p1];
                ++p1;
            }

            result[p1 + p2 - 1] = cur;
        }
        return result;
    }
    
}
