package com.horadrim.staff.alg.tree;

import java.util.ArrayList;
import java.util.List;

public class BPTree {
    private BPTreeNode root;

    public BPTree() {
        root = new BPTreeNode();
    }

    public void insert(int k) {

    }

    

    private class BPTreeNode {

        public BPTreeNode() {
            isLeaf = false;
            children = new ArrayList<>();
            keys = new ArrayList<>();
        }

        private Boolean isLeaf;

        private List<BPTreeNode> children;

        private List<Integer> keys;
    }
}
