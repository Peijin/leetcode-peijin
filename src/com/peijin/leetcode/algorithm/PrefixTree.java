package com.peijin.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

public class PrefixTree {

    // TODO
    class Trie {

        Node root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new Node();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return true;
        }
    }

    class Node{
        char ch;
        Node[] children = new Node[26];

        public Node(){}
        public Node(char ch){ this.ch = ch; }

    }
}
