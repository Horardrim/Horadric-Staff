package com.horadrim.staff.ltcd.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.horadrim.staff.alg.tree.BinaryTree;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckSubtreeTest {

    @Test
    public void normalTest() {
        BinaryTree parentTree = new BinaryTree(1); 
        BinaryTree.BinaryTreeNode left = parentTree.new BinaryTreeNode(2);
        BinaryTree.BinaryTreeNode right = parentTree.new BinaryTreeNode(3);
        BinaryTree.BinaryTreeNode grandChild = parentTree.new BinaryTreeNode(4);
        parentTree.root().insertLeft(left);
        parentTree.root().insertRight(right);
        left.insertRight(grandChild);

        BinaryTree childTree = new BinaryTree(2);
        childTree.root().insertRight(grandChild);
        Assertions.assertEquals(true, parentTree.isSubTree(childTree));

        BinaryTree childTreeII = new BinaryTree(2);
        childTreeII.root().insertLeft(right);
        Assertions.assertEquals(false, parentTree.isSubTree(childTreeII));
    }
}
