package com.horadrim.staff.ltcd.string;

import java.util.LinkedList;
import java.util.Queue;

public class StreamChecker {

    private static final int ALPHABET_COUNT = 26;

    public boolean solution(String[] words) {
        TrieNode root = new TrieNode();
        TrieNode temp = null;

        for (String word : words) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (cur.getChild(index) == null) {
                    cur.setChild(index, new TrieNode());
                }
                cur = cur.getChild(index);
            }
            cur.setIsEnd(true);
        }

        root.setFail(root);
        Queue<TrieNode> q = new LinkedList<>();
        for (int i = 0; i < ALPHABET_COUNT; ++i) {
            if (root.getChild(i) != null) {
                q.add(root.getChild(i));
            } else {
                root.setChild(i, root);
            }
        }

        while(!q.isEmpty()) {
            TrieNode node = q.poll();
            node.setIsEnd(node.getIsEnd() || node.getFail().getIsEnd());
            for (int i = 0; i < ALPHABET_COUNT; ++i) {
                if(node.getChild(i) != null) {
                    node.getChild(i).setFail(node.getFail().getChild(i));
                    q.offer(node.getChild(i));
                } else {
                    node.setChild(i, node.getFail().getChild(i));
                }
            }
        }

        temp = root;
        return false;
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode fail;
        
    
        public TrieNode() {
            children = new TrieNode[ALPHABET_COUNT];
        }
    
        public TrieNode getChild(int index) {
            return children[index];
        }
    
        public void setChild(int index, TrieNode node) {
            children[index] = node;
        }
    
        public boolean getIsEnd() {
            return isEnd;
        }
    
        public void setIsEnd(boolean b) {
            isEnd = b;
        }
    
        public TrieNode getFail() {
            return fail;
        }
    
        public void setFail(TrieNode node) {
            fail = node;
        }
    }
}
