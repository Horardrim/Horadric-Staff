package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeTest {
    @Test
    public void buildTreeWithPreoderAndInorderTest_normalTest() {
        int [] preorder = new int[] {3, 9, 20, 15, 7};
        int [] inorder = new int[] {9, 3, 15, 20, 7};
        BinaryTree tree = BinaryTree.buildTreeByPreorderAndInorder(preorder, inorder);
        Assertions.assertEquals(3, tree.root().data());
        Assertions.assertEquals(9, tree.root().getLeft().data());
    }

    @Test
    public void buildTreeWithPreoderAndInorderTest_OnlyOneNode() {
        int [] preorder = new int[] {3};
        int [] inorder = new int[] {3};
        BinaryTree tree = BinaryTree.buildTreeByPreorderAndInorder(preorder, inorder);
        Assertions.assertEquals(3, tree.root().data());
    }

    @Test
    public void buildTreeWithPostoderAndInorderTest_normalTest() {
        int [] postorder = new int[] {9, 15, 7, 20, 3};
        int [] inorder = new int[] {9, 3, 15, 20, 7};
        BinaryTree tree = BinaryTree.buildTreeByPostorderAndInorder(postorder, inorder);
        Assertions.assertEquals(3, tree.root().data());
        Assertions.assertEquals(9, tree.root().getLeft().data());
        Assertions.assertEquals(20, tree.root().getRight().data());
    }

    @Test
    public void buildTreeWithPostoderAndInorderTest_OnlyOneNode() {
        int [] postorder = new int[] {9};
        int [] inorder = new int[] {9};
        BinaryTree tree = BinaryTree.buildTreeByPostorderAndInorder(postorder, inorder);
        Assertions.assertEquals(9, tree.root().data());
    }

    @Test
    public void depthTest_normalTest() {
        int [] postorder = new int[] {9, 15, 7, 20, 3};
        int [] inorder = new int[] {9, 3, 15, 20, 7};
        BinaryTree tree = BinaryTree.buildTreeByPostorderAndInorder(postorder, inorder);
        Assertions.assertEquals(2, tree.minDepth());

        Assertions.assertEquals(2, tree.root().minDepth());
        Assertions.assertEquals(1, tree.root().getLeft().minDepth());

        Assertions.assertEquals(3, tree.level());

        BinaryTree emptyTree = new BinaryTree();
        Assertions.assertEquals(0, emptyTree.minDepth());
    }
}
