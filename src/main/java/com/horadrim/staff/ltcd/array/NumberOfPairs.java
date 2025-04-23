package com.horadrim.staff.ltcd.array;

import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;

public class NumberOfPairs {
    public Entry<Integer, Integer> solution(int [] nums) {
        Entry<Integer, Integer> result = null; 
        Map<Integer, Integer> pairs = new HashMap<>();
        int pairNum = 0;
        int restNum = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (pairs.containsKey(nums[i])) {
                int count = pairs.get(nums[i]);
                if (count % 2 == 1) {
                    ++pairNum;
                    --restNum;
                } else {
                    ++restNum;
                }
                pairs.put(nums[i], count + 1);
            } else {
                pairs.put(nums[i], 1);
                ++restNum;
            }
        }

        result = new SimpleEntry<>(pairNum, restNum);

        return result;
    }

    public Entry<Integer, Integer> solutionII(int [] nums) {
        Map<Integer, Boolean> pairs = new HashMap<>();
        int pairNum = 0;
        for (int i = 0; i < nums.length; ++i) {
            pairs.put(nums[i], (Objects.isNull(pairs.get(nums[i])) ? true : !pairs.get(nums[i])));
            if (!pairs.get(nums[i])) {
                ++pairNum;
            }
        }

        return new SimpleEntry<Integer, Integer>(pairNum, nums.length - 2 * pairNum);
    }
}
