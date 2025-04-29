package com.horadrim.staff.ltcd.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumQuestion {
    List<List<Integer>> solution(int [] array) {
        int length = array.length;
        Arrays.sort(array);
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < length; ++first) {
            if (first > 0 && array[first] == array[first - 1]) {
                continue;
            }

            int target = - array[first];
            int third = length - 1;
            for (int second = first + 1; second < length; ++second) {
                if (second > first + 1 && array[second] == array[second - 1]) {
                    continue;
                }

                while (second < third && array[second] + array[third] > target) {
                    --third;
                }

                if (second == third) {
                    break;
                }

                if (array[second] + array[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(array[first]);
                    list.add(array[second]);
                    list.add(array[third]);
                    ans.add(list);
                }
            }
        }


        return ans;
    }
}
