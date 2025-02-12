package com.horadrim.staff.ltcd.tree;

import com.horadrim.staff.alg.tree.BinaryTree;

public class PathSum {
    public boolean solution(BinaryTree tree, int targetSum) {
        return tree.hasPathSum(targetSum);
    }
}
