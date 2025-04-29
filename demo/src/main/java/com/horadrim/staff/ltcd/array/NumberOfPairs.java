package com.horadrim.staff.ltcd.array;

import java.util.HashMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;

public class NumberOfPairs {
    /*
     * 通过哈希表记录数组元素的个数
     */
    public Entry<Integer, Integer> solution(int [] nums) {
        Entry<Integer, Integer> result = null; 
        Map<Integer, Integer> pairs = new HashMap<>();
        int pairNum = 0;
        int restNum = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (pairs.containsKey(nums[i])) {
                int count = pairs.get(nums[i]);
                // 当前个数为奇数，则可以成对
                if (count % 2 == 1) {
                    // 数组成对的对数+1，剩余不成对的数组元素个数则要-1
                    ++pairNum;
                    --restNum;
                } else {
                    // 剩余不成对数组元素的个数+1
                    ++restNum;
                }
                // 更新元素的个数
                pairs.put(nums[i], count + 1);
            } else {
                pairs.put(nums[i], 1);
                ++restNum;
            }
        }

        result = new SimpleEntry<>(pairNum, restNum);

        return result;
    }

    /*
     * 同样使用哈希表，但是用true或false表示数组元素是否成对
     */
    public Entry<Integer, Integer> solutionII(int [] nums) {
        Map<Integer, Boolean> pairs = new HashMap<>();
        int pairNum = 0;
        for (int i = 0; i < nums.length; ++i) {
            /*
             * 数组元素在哈希表中不存在时，设置元素在哈希表中为true
             * 否则将数组元素的当前布尔值置为该值的取反
             */
            pairs.put(nums[i], (Objects.isNull(pairs.get(nums[i])) ? true : !pairs.get(nums[i])));
            // 每当元素在哈希表中的布尔值为false，pairNum + 1，数组中元素可能有4，6，8个，每次为false都可以算作成对
            if (!pairs.get(nums[i])) {
                ++pairNum;
            }
        }

        // 数组元素的总数减去对数 * 2则为属于不成对的数的数量
        return new SimpleEntry<Integer, Integer>(pairNum, nums.length - 2 * pairNum);
    }
}
