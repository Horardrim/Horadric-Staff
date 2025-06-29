package com.horadrim.staff.alg.tree;

import java.util.Deque;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

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
        if (p == null || q == null) {
            return null;
        }
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
     * 广度搜索与通过入度判断连通性有相似
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
     * 通过深度搜索判断childTree是不是子树
     */
    public boolean isSubTree(BinaryTree childTree) {
        BinaryTree.BinaryTreeNode parentTreeRoot = this.root;
        BinaryTree.BinaryTreeNode childTreeRoot = childTree.root;

        return checkSubTree(parentTreeRoot, childTreeRoot);
    }

    /*
     * 获取二叉树的层数，通过每层加入seperator来分开树的每一层
     */
    public int level() {
        if (root == null) {
            return 0;
        }

        int level = 1;
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        queue.offerLast(null);

        while (!queue.isEmpty()) {
            BinaryTreeNode n = queue.pollFirst();
            if (Objects.isNull(n)) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.addLast(n);
                    level += 1;
                    continue;
                }
            }

            if (n.getLeft() != null) {
                queue.addLast(n.getLeft());
            }

            if (n.getRight() != null) {
                queue.addLast(n.getRight());
            }
        }

        return level;

    }

    /*
     * 获取二叉树的层数，通过队列中所有节点都是null，则当前层数-1
     */
    public final int level(int overload) {
        if (root == null) {
            return 0;
        }

        int level = 1;
        Deque<BinaryTreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        while (!queue.isEmpty()) {
            int nodeCount = queue.size();
            int nullNodeCount = 0;
            for (int i = 0; i < nodeCount; ++i) {
                BinaryTreeNode node = queue.poll();
                if (Objects.isNull(node)) {
                    ++nullNodeCount;
                    continue;
                }

                queue.addLast(node.getLeft());
                queue.addLast(node.getRight());
            }

            if (nullNodeCount == nodeCount) {
                return level - 1;
            }
            ++level;
        }

        return level;
    }

    static public BinaryTree buildTreeByPreorderAndInorder(
        int [] preorder, int [] inorder) {

        if (preorder.length == inorder.length) {
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; ++i) {
                indexMap.put(inorder[i], i);
            }

            BinaryTree tree = new BinaryTree();
            tree.root = BinaryTreeNode.buildTreeByPreorderAndInorder(
                tree,
                preorder, inorder,
                indexMap,
                0, preorder.length - 1,
                0, inorder.length - 1
            );

            return tree;
        }

        return null;
    }

    static public BinaryTree buildTreeByPostorderAndInorder(
        int [] postorder, int [] inorder) {

        if (postorder.length == inorder.length) {
            Map<Integer, Integer> indexMap = new HashMap<>();
            for (int i = 0; i < inorder.length; ++i) {
                indexMap.put(inorder[i], i);
            }

            BinaryTree tree = new BinaryTree();
            tree.root = BinaryTreeNode.buildTreeByPostorderAndInorder(
                tree,
                postorder, inorder,
                indexMap,
                0, postorder.length - 1,
                0, inorder.length - 1
            );

            return tree;
        }
        return null;
    }

    private boolean checkSubTree(BinaryTreeNode parentTreeNode, BinaryTreeNode childTreeNode) {
        // parent树的节点多于child树的节点，故若childTreeNode为null则返回true，反之则返回false
        if (childTreeNode == null) {
            return true;
        }

        if (parentTreeNode == null) {
            return false;
        }

        return checkSameTree(parentTreeNode, childTreeNode) ||
            checkSubTree(parentTreeNode.left, childTreeNode) ||
            checkSubTree(parentTreeNode.right, childTreeNode);
    }

    private boolean checkSameTree(BinaryTreeNode parentTreeNode, BinaryTreeNode childTreeNode) {
        if (parentTreeNode == null && childTreeNode == null) {
            return true;
        }

        if (parentTreeNode == null ||
            childTreeNode == null ||
            (parentTreeNode.data != childTreeNode.data)) {
                return false;
        }

        return checkSameTree(parentTreeNode.left, childTreeNode.left) && checkSameTree(parentTreeNode.right, childTreeNode.right);
    }

    /*
     * definiation of BinrayTreeNode
     */
    public class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        private int data;

        public int data() {
            return data;
        }

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

        static private BinaryTreeNode buildTreeByPreorderAndInorder(
            BinaryTree tree,
            int [] preorder, int [] inorder,
            Map<Integer, Integer> indexMap,
            int preoderLeft, int preoderRight,
            int inorderLeft, int inorderRight) {

            if (preoderLeft > preoderRight) {
                return null;
            }

            int preorderRoot = preoderLeft;
            int inorder_root = indexMap.get(preorder[preorderRoot]);
            BinaryTreeNode root = tree.new BinaryTreeNode(preorder[preorderRoot]);

            int leftSubtreeSize = inorder_root - inorderLeft;
            root.left = buildTreeByPreorderAndInorder(
                tree, preorder, inorder, 
                indexMap,
                preoderLeft + 1, preoderLeft + leftSubtreeSize, 
                inorderLeft, inorder_root - 1);

            root.right = buildTreeByPreorderAndInorder(
                tree, preorder, inorder,
                indexMap,
                preoderLeft + leftSubtreeSize + 1, preoderRight,
                inorder_root + 1, inorderRight);
            return root;
        }

        static private BinaryTreeNode buildTreeByPostorderAndInorder(
            BinaryTree tree,
            int [] postorder, int [] inorder,
            Map<Integer, Integer> indexMap,
            int postoderLeft, int postoderRight,
            int inorderLeft, int inorderRight) {

            if (inorderLeft > inorderRight) {
                return null;
            }

            int inorder_root = indexMap.get(postorder[postoderRight]);
            int leftSubtreeSize = inorder_root - inorderLeft;
            BinaryTreeNode root = tree.new BinaryTreeNode(postorder[postoderRight]);

            root.left = buildTreeByPostorderAndInorder(
                tree,
                postorder, inorder,
                indexMap,
                postoderLeft, postoderLeft + leftSubtreeSize - 1,
                inorderLeft, inorder_root - 1);

            root.right = buildTreeByPostorderAndInorder(
                tree,
                postorder, inorder,
                indexMap,
                postoderLeft + leftSubtreeSize, postoderRight - 1,
                inorder_root + 1, inorderRight);

            return root;

        }

        public void insertLeft(BinaryTreeNode child) {
            this.left = child;
        }

        public void insertRight(BinaryTreeNode child) {
            this.right = child;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }
    }
}
