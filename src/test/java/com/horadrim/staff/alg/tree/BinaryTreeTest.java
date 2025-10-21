package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.features.java.reflection.TestAnnotation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeTest {
    //+-------------------------------------------------------+
    //|     Build a tree with preoder and inorder             |
    //|     and with postorder and in order Test Cases        |
    //+-------------------------------------------------------+
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

    //+---------------------------------+
    //|     Min Depth Test Cases        |
    //+---------------------------------+
    @Test
    public void depthTest_normalTest() {
        int [] postorder = new int[] {9, 15, 7, 20, 3};
        int [] inorder = new int[] {9, 3, 15, 20, 7};
        BinaryTree tree = BinaryTree.buildTreeByPostorderAndInorder(postorder, inorder);
        Assertions.assertEquals(1, tree.minDepth());

        Assertions.assertEquals(1, tree.root().minDepth());
        Assertions.assertEquals(0, tree.root().getLeft().minDepth());
        Assertions.assertEquals(1, tree.root().getRight().minDepth());

        Assertions.assertEquals(3, tree.level());

        BinaryTree emptyTree = new BinaryTree();
        Assertions.assertEquals(0, emptyTree.minDepth());
    }

    @Test
    public void minDepth_singlePathTest() {
        int [] preorder = new int[] {1, 2, 3, 4, 5};
        int [] inorder = new int[] {5, 4, 3, 2, 1};
        BinaryTree tree = BinaryTree.buildTreeByPreorderAndInorder(preorder, inorder);
        Assertions.assertEquals(4, tree.minDepth());
    }

    //+---------------------------------------------------+
    //|     lowest common ancestor(LCA) Test Cases        |
    //+---------------------------------------------------+
    @Test
    public void lowestCommonAncestor_normalTest() {
        int [] preorder = new int[] {3, 9, 20, 15, 7};
        int [] inorder = new int[] {9, 3, 15, 20, 7};
        BinaryTree tree = BinaryTree.buildTreeByPreorderAndInorder(preorder, inorder);
        BinaryTree.BinaryTreeNode left = tree.root().getRight().getLeft();
        BinaryTree.BinaryTreeNode right = tree.root().getRight().getRight();
        BinaryTree.BinaryTreeNode expectAncestor = tree.root().getRight();
        BinaryTree.BinaryTreeNode trueAncestor = tree.lowestCommonAncestor(left, right);
        Assertions.assertEquals(expectAncestor, trueAncestor);
        Assertions.assertEquals(20, trueAncestor.data());
    }

    @Test
    public void lowestCommonAncestor_parentNodesTest() {
        int [] preorder = new int[] {3, 9, 20, 15, 7};
        int [] inorder = new int[] {9, 3, 15, 20, 7};
        BinaryTree tree = BinaryTree.buildTreeByPreorderAndInorder(preorder, inorder);
        BinaryTree.BinaryTreeNode left = tree.root().getRight().getLeft();
        BinaryTree.BinaryTreeNode right = tree.root().getRight();
        BinaryTree.BinaryTreeNode expectAncestor = tree.root().getRight();
        BinaryTree.BinaryTreeNode trueAncestor = tree.lowestCommonAncestor(right, left);
        Assertions.assertEquals(expectAncestor, trueAncestor);
        Assertions.assertEquals(20, trueAncestor.data());
    }
}
