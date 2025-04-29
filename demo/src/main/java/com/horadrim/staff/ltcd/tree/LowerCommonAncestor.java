package com.horadrim.staff.ltcd.tree;

import com.horadrim.staff.alg.tree.BinaryTree;

public class LowerCommonAncestor {
    public BinaryTree.BinaryTreeNode solution(BinaryTree tree, BinaryTree.BinaryTreeNode p, BinaryTree.BinaryTreeNode q) {
        return tree.lowestCommonAncestor(p, q);
    }
}
