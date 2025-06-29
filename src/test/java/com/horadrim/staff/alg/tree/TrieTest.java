package com.horadrim.staff.alg.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TrieTest {
    @Test
    public void normalTest() {
        Trie t = new Trie();
        t.insert("leetcode");
        boolean found = t.search("leet");
        boolean isProfix = t.startsWith("leet");

        Assertions.assertTrue(!found);
        Assertions.assertTrue(isProfix);

        t.insert("let");
        isProfix = t.startsWith("let");
        found = t.search("leetcode");
        Assertions.assertTrue(isProfix);
        Assertions.assertTrue(found);
    }
}
