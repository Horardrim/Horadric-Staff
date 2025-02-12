package com.horadrim.staff.ltcd.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.alg.tree.BinaryTree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PathSumTest {
    @Test
    public void normalTest() {
        PathSum solution = new PathSum();
        BinaryTree tree = new BinaryTree(1);
        tree.root().insertLeft(tree.new BinaryTreeNode(2));
        tree.root().insertRight(tree.new BinaryTreeNode(3));
        Assertions.assertEquals(solution.solution(tree, 6), false);
        Assertions.assertEquals(solution.solution(tree, 3), true);
        Assertions.assertEquals(solution.solution(tree, 4), true);
        Assertions.assertEquals(solution.solution(tree, 2), false);
        Assertions.assertEquals(solution.solution(tree, 1), true);
    }
}
