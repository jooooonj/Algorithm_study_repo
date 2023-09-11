package com.ll.topInterview.leetcode100;

class Main {

    private final Trie trie = new Trie();

    public Main() {
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return trie.search(word);
    }

    class Trie {

        private static final int COUNT_OF_LETTERS = 26;
        private static final char START_LETTER = 'a';
        private static final char ALL_LETTER = '.';

        private final Trie[] children;
        private boolean isEnd;

        public Trie() {
            children = new Trie[COUNT_OF_LETTERS];
            isEnd = false;
        }

        public void insert(String word) {
            if (word.length() == 0) {
                isEnd = true;
                return;
            }

            Trie child = getChild(word);
            if (child == null) {
                child = putNewChild(word);
            }
            child.insert(word.substring(1));
        }

        public boolean search(String word) {
            if (word.length() == 0) {
                return isEnd;
            }

            if (word.charAt(0) != ALL_LETTER) {
                Trie child = getChild(word);
                return child != null && child.search(word.substring(1));
            }

            for (Trie child : children) {
                if (child != null && child.search(word.substring(1))) {
                    return true;
                }
            }
            return false;
        }

        private Trie getChild(String word) {
            char key = word.charAt(0);
            return children[key - START_LETTER];
        }

        private Trie putNewChild(String word) {
            char key = word.charAt(0);
            Trie child = new Trie();
            children[key - START_LETTER] = child;
            return child;
        }
    }
}
