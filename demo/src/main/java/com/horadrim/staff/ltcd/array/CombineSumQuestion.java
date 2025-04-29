package com.horadrim.staff.ltcd.array;

import java.util.ArrayList;
import java.util.List;

public class CombineSumQuestion {
    public List<List<Integer>> solutionI(int array[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> comb = new ArrayList<>();
        _dfs(array, ans, comb, target, 0);
        return ans;
    }

    private void _dfs(int array[], List<List<Integer>> ans, List<Integer> comb, int target, int index) {
        // index抵达数组尾部说明comb组合的和达不到target值 
        if (index == array.length) {
            return;
        }
        // comb组合的值恰好等于target值，添加comb后返回
        if (target == 0) {
            ans.add(new ArrayList<>(comb));
            return;
        }

        // 跳过当前的数组元素
        _dfs(array, ans, comb, target, index + 1);

        // 选取当前元素进行计算
        if (target - array[index] >= 0) {
            comb.add(array[index]);
            _dfs(array, ans, comb, target - array[index], index);
            // 无论组合的和是否等于target都要删除最后一个元素
            comb.remove(comb.size() - 1);
        }

        // comb组合的值大于target，直接返回
    }
}
