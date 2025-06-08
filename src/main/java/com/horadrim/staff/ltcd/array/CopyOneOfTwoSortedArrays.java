package com.horadrim.staff.ltcd.array;

/*
 * 有两个已排序数组A和B，将A中存在B中不存在元素放入新数组并返回
 * 算法与MergeTwoSortedArrays类似
 */
public class CopyOneOfTwoSortedArrays {
    int [] solution(int [] arrayI, int [] arrayII) {
        if (arrayII.length == 0 || arrayI.length == 0) {
            return arrayI;
        }

        if (arrayI[0] > arrayII[arrayII.length - 1] ||
            arrayI[arrayI.length - 1] < arrayII[0]) {
            return arrayI;
        }

        int pI = 0, pII = 0, cur = 0;
        int [] result = new int[arrayI.length];

        while (pI < arrayI.length) {
            if (pII == arrayII.length) {
                result[cur++] = arrayI[pI++];
            } else if (arrayI[pI] == arrayII[pII]) {
                ++pI;
                ++pII;
            } else if (arrayI[pI] < arrayII[pII]) {
                result[cur++] = arrayI[pI++];
            } else if (arrayI[pI] > arrayII[pII]) {
                ++pII;
            }

        }
        return result;
    }
}
