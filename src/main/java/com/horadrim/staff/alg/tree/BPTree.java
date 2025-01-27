package com.horadrim.staff.alg.tree;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

public class BPTree {
    private BPTreeNode root;

    private final int MAX_NODE_COUNT_PER_NODE;                        // 每个节点的最大子节点数量

    private final int MIN_KEY_COUNT_PER_NON_ROOT_NODE;                // 非根节点中的最小键数量

    public BPTree() {
        root = new BPTreeNode();
        MAX_NODE_COUNT_PER_NODE = 5;
        MIN_KEY_COUNT_PER_NON_ROOT_NODE = (MAX_NODE_COUNT_PER_NODE + 1) / 2;
    }

    public BPTree(int maxNodeCount) {
        root = new BPTreeNode(true);
        MAX_NODE_COUNT_PER_NODE = maxNodeCount;
        MIN_KEY_COUNT_PER_NON_ROOT_NODE = (MAX_NODE_COUNT_PER_NODE + 1) / 2;
    }

    public void insert(int k) {

    }

    
    @Data
    private class BPTreeNode {

        public BPTreeNode() {
            isLeaf = false;
            children = new ArrayList<>();
            keys = new ArrayList<>();
        }

        public BPTreeNode(Boolean isLeaf) {
            this.isLeaf = isLeaf;
            children = new ArrayList<>();
            keys = new ArrayList<>();
        }

        private Boolean isLeaf;

        private List<BPTreeNode> children;

        private List<Integer> keys;
    }
}
