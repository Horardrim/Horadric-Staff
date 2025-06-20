package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeTest {
    @Test
    public void buildTreeWithPreoderAndInorderTest() {
        int [] preorder = new int[] {3, 9, 20, 15, 7};
        int [] inorder = new int[] {9, 3, 15, 20, 7};
        BinaryTree tree = BinaryTree.buildTreeByPreorderAndInorder(preorder, inorder);
        Assertions.assertEquals(9, tree.root().getLeft().data());
    }

    @Test
    public void buildTreeWithPreoderAndInorderTest_OnlyOneNode() {
        int [] preorder = new int[] {3};
        int [] inorder = new int[] {3};
        BinaryTree tree = BinaryTree.buildTreeByPreorderAndInorder(preorder, inorder);
        Assertions.assertEquals(3, tree.root().data());
    }
}
