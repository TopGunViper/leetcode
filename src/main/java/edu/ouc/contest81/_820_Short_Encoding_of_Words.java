package edu.ouc.contest81;

public class _820_Short_Encoding_of_Words {

    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        Trie root = new Trie('/');
        for (int i = 0; i < words.length; i++) {

        }
        return res;
    }

    static class Trie {
        Character c;
        Trie[] subTree;

        public Trie(Character c) {
            this.c = c;
            this.subTree = new Trie[0];
        }

        @Override
        public String toString() {
            return "c:" + c;
        }

        public void put(String str, int index) {
            Character c = str.charAt(index);
            int i = 0;
            Trie tree = null;
            for (; i < subTree.length && (c < subTree[i].c); i++) {
                // do nothing
            }
            int subTreeSize = subTree.length;
            System.out.println("i=" + i + ",subTreeSize:" + subTreeSize + ",c:" + c);
            if (i < subTreeSize && c == subTree[i].c) {
                tree = subTree[i];
            } else {
                tree = new Trie(c);
                Trie[] newSubTree = new Trie[subTreeSize + 1];
                if (i == subTreeSize) {
                    newSubTree[i] = tree;
                } else { // x z y
                    System.arraycopy(subTree, 0, newSubTree, 0, i);
                    newSubTree[i] = tree;
                    if (i < subTreeSize) {
                        System.arraycopy(subTree, i, newSubTree, i + 1, subTreeSize - i);
                    }
                }
                subTree = newSubTree;
            }
            if (index + 1 < str.length()) {
                tree.put(str, index + 1);
            }
        }

        public boolean exists(String str) {
            int index = 0;


            Trie[] curSubTree = subTree;
            while (true) {
                Character cur = str.charAt(index);
                boolean find = false;
                for (int i = 0; i < curSubTree.length; i++) {
                    if (curSubTree[i].c == cur) {
                        find = true;
                        curSubTree = curSubTree[i].subTree;
                        break;
                    }
                }
                if (find) {
                    if (index < str.length() - 1) {
                        index++;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            }
        }
    }

    public static void main(String args[]) {
        _820_Short_Encoding_of_Words
                tester = new _820_Short_Encoding_of_Words();
        String[] words = {"time", "me", "bell"};
        Trie trie = new Trie('/');
        for(String word: words){
            System.out.println("word:" + word);
            trie.put(word, 0);
        }

        for(String word: words){
            trie.exists(word);
        }
    }
}
