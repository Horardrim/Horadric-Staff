package com.horadrim.staff.ltcd.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.alg.tree.BinaryTree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LowerCommonAcestorTest {
    @Test
    public void normalTest() {
        BinaryTree testTree = new BinaryTree(1);
        BinaryTree.BinaryTreeNode leftChild = testTree.new BinaryTreeNode(2);
        BinaryTree.BinaryTreeNode rightChild = testTree.new BinaryTreeNode(3);
        BinaryTree.BinaryTreeNode grandLeftChildForLeft = testTree.new BinaryTreeNode(4);
        BinaryTree.BinaryTreeNode grandRightChildForRight = testTree.new BinaryTreeNode(5);
        BinaryTree.BinaryTreeNode grandIILeftChildForRightForGrandLeft = testTree.new BinaryTreeNode(6);
        BinaryTree.BinaryTreeNode grandIIRightChildForRightForGrandLeft = testTree.new BinaryTreeNode(7);
        testTree.root().insertLeft(leftChild);
        testTree.root().insertRight(rightChild);
        leftChild.insertLeft(grandLeftChildForLeft);
        rightChild.insertRight(grandRightChildForRight);
        grandLeftChildForLeft.insertLeft(grandIILeftChildForRightForGrandLeft);
        grandLeftChildForLeft.insertRight(grandIIRightChildForRightForGrandLeft);

        BinaryTree.BinaryTreeNode lowerCommonAcestor = testTree.lowestCommonAncestor(grandIILeftChildForRightForGrandLeft, grandRightChildForRight);
        Assertions.assertEquals(testTree.root().data(), lowerCommonAcestor.data());
    }
}
