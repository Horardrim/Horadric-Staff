package com.horadrim.staff.alg.tree;


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

    public void addRight(BinaryTreeNode child) {
        
    }

    public boolean isBSTree() {
        return isBSTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /*
     * 可以分别通过深度搜索和广度搜索以及判断入度来分析一颗二叉树是否有连通
     */
    public boolean validate() {
        return false;
    }

    public boolean hasPathSum(int targetSum) {
        return hasPathSum(root, targetSum);
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
