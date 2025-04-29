package com.horadrim.staff.alg.sort;


public class QuickSort {
    public void sort(int[] a) {
        int left = 0;
        int right = a.length - 1;
        sort(a, left, right);
    }

    private void sort(int[] a, int left, int right) {
        if (right <= left) {
            return;
        }

        int base = a[left];
        int rightPos = right;
        int leftPos = left;
        while(rightPos > leftPos) {
            while(a[rightPos] >= base && rightPos > leftPos) {
                --rightPos;
            }

            a[leftPos] = a[rightPos];

            while(a[leftPos] <= base && leftPos < rightPos) {
                ++leftPos;
            }
            a[rightPos] = a[leftPos];
        }

        a[leftPos] = base;
        sort(a, left, leftPos - 1);
        sort(a, rightPos + 1, right);
    }

    public void oneTurnSort(int[] a, int left, int right) {
        if (right <= left) {
            return;
        }

        int base = a[left];
        int rightPos = right;
        int leftPos = left;
        while(rightPos > leftPos) {
            while(a[rightPos] >= base && rightPos > leftPos) {
                --rightPos;
            }

            a[leftPos] = a[rightPos];

            while(a[leftPos] <= base && leftPos < rightPos) {
                ++leftPos;
            }
            a[rightPos] = a[leftPos];
        }

        a[leftPos] = base;
    }
}
