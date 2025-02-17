package com.horadrim.staff.ltcd.tree;

import com.horadrim.staff.alg.tree.BinaryTree;

public class CheckSubtree {
    public boolean solution(BinaryTree t1, BinaryTree t2) {
        return t1.isSubTree(t2);
    }
}
