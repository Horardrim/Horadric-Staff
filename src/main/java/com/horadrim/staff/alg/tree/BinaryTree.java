package com.horadrim.staff.alg.tree;

import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int rootNum) {
        root = new BinaryTreeNode(rootNum);
    }

    public BinaryTreeNode root() {
        return root;
    }

    /*
     * 可以分别通过深度搜索和广度搜索以及判断入度来分析一颗二叉树是否有连通
     */
    public boolean validate() {
        return false;
    }

    /*
     * 是否有路径其所有节点的和等于target
     */
    public boolean hasPathSum(int targetSum) {
        return hasPathSum(root, targetSum);
    }

    /*
     * 两个节点的最低公共祖先节点
     */
    public BinaryTreeNode lowestCommonAncestor(BinaryTreeNode p, BinaryTreeNode q) {
        return lowestCommonAncestor(root, p, q);
    }

    private BinaryTreeNode lowestCommonAncestor(BinaryTreeNode root, BinaryTreeNode p, BinaryTreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        // 递归地在左子树和右子树中查找 p 和 q
        BinaryTreeNode left = lowestCommonAncestor(root.left, p, q);
        BinaryTreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左子树和右子树的递归调用都返回了非空节点
        if (left != null && right != null) {
            // 当前节点就是最近公共祖先
            return root;
        }

        // 如果只有一个子树返回了非空节点，返回该子树的返回值
        return left != null ? left : right;
    }

    /*
     * 递归判断二叉树是否有路径上所有节点的和等于targetSum
     */
    private boolean hasPathSum(BinaryTreeNode node, int targetSum) {
        if (node == null || targetSum - node.data < 0) {
            return false;
        }

        if (targetSum - node.data == 0) {
            return true;
        }

        targetSum -= node.data;

        return hasPathSum(node.left, targetSum) || hasPathSum(node.right, targetSum);
    }

    /*
     * 判断二叉树是否连通
     */
    public boolean isConnected() {
        Set<BinaryTreeNode> visited = new HashSet<>();
        return DFSConnected(root, visited);
    }

    /*
     * 通过深度搜索判断二叉树连通性
     */
    private boolean DFSConnected(BinaryTreeNode node, Set<BinaryTreeNode> visited) {
        if (node == null) {
            return false;
        }

        if (visited.contains(node)) {
            return true;
        }

        visited.add(node);
        return DFSConnected(node.left, visited) || DFSConnected(node.right, visited);
    }

    /*
     * 通过广度搜索判断二叉树连通性
     */
    public boolean BFSConnected() {
        if (root == null) {
            return false;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Set<BinaryTreeNode> visited = new HashSet<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (visited.contains(node)) {
                return true;
            }

            visited.add(node);

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return false;
    }

    /*
     * 判断该二叉树是否为二叉搜索树
     */
    public boolean isBSTree() {
        return isBSTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBSTree(BinaryTreeNode node, int lower, int upper) {
        if (node == null) {
            return true;
        }

        if (node.data <= lower || node.data >= upper) {
            return false;
        }

        return isBSTree(node.left, lower, node.data) && isBSTree(node.right, node.data, upper);
    }
    /*
     * 通过中序遍历比较节点的值，此处用stack来模拟，一下是伪代码
     */
    // bool isValidBST(TreeNode* root) {
    //     stack<TreeNode*> stack;
    //     long long inorder = (long long)INT_MIN - 1;

    //     while (!stack.empty() || root != nullptr) {
    //         while (root != nullptr) {
    //             stack.push(root);
    //             root = root -> left;
    //         }
    //         root = stack.top();
    //         stack.pop();
    //         // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
    //         if (root -> val <= inorder) {
    //             return false;
    //         }
    //         inorder = root -> val;
    //         root = root -> right;
    //     }
    //     return true;
    // }

    /*
     * definiation of BinrayTreeNode
     */
    public class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;

        public BinaryTreeNode() {
            left = null;
            right = null;
            data = 0;
        }

        public BinaryTreeNode(int value) {
            left = null;
            right = null;
            data = value;
        }

        public void insertLeft(BinaryTreeNode child) {
            this.left = child;
        }

        public void insertRight(BinaryTreeNode child) {
            this.right = child;
        }
    }
}
