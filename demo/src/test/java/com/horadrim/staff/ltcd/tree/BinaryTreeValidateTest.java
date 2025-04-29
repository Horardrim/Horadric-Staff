package com.horadrim.staff.ltcd.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.alg.tree.BinaryTree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinaryTreeValidateTest {
    @Test
    public void normalTest() {
        BinaryTree testTree = new BinaryTree(1);
        BinaryTree.BinaryTreeNode left = testTree.new BinaryTreeNode(1);
        BinaryTree.BinaryTreeNode right = testTree.new BinaryTreeNode(1);
        BinaryTree.BinaryTreeNode grandChild = testTree.new BinaryTreeNode(1);
        testTree.root().insertLeft(left);
        testTree.root().insertRight(right);
        left.insertRight(grandChild);
        right.insertLeft(grandChild);
        Assertions.assertEquals(true, testTree.isConnected());
        Assertions.assertEquals(true, testTree.BFSConnected());
    }

    @Test
    public void nonConnectedTreeTest() {
        BinaryTree testTree = new BinaryTree(1);
        BinaryTree.BinaryTreeNode left = testTree.new BinaryTreeNode(1);
        BinaryTree.BinaryTreeNode right = testTree.new BinaryTreeNode(1);
        testTree.root().insertLeft(left);
        testTree.root().insertRight(right);
        Assertions.assertEquals(false, testTree.isConnected());
        Assertions.assertEquals(false, testTree.BFSConnected());
    }

    @Test
    public void BinaryTreeLevelTest() {
        BinaryTree testTree = new BinaryTree(1);
        BinaryTree.BinaryTreeNode left = testTree.new BinaryTreeNode(1);
        BinaryTree.BinaryTreeNode right = testTree.new BinaryTreeNode(1);
        testTree.root().insertLeft(left);
        testTree.root().insertRight(right);

        Assertions.assertEquals(2, testTree.level());

        BinaryTree emptyTree = new BinaryTree();
        Assertions.assertEquals(0, emptyTree.level());

        testTree.root().getLeft().insertLeft(testTree.new BinaryTreeNode(5));
        Assertions.assertEquals(3, testTree.level());
    }
}
