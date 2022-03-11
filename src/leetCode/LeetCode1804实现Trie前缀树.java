package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/7
 */
public class LeetCode1804实现Trie前缀树 {

    static class Trie {

        /**
         * 根节点
         */
        TrieNode head;

        /**
         * 构造函数
         */
        public Trie() {
            head = new TrieNode();
            head.setEnd(false);
        }

        /**
         * 向字典树中添加单词
         *
         * @param word
         */
        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            char[] wordSymbol = word.toCharArray();
            insert(wordSymbol, 0, head);
        }

        /**
         * 插入字符
         *
         * @param word
         * @return
         */
        private boolean insert(char[] word, int index, TrieNode node) {
            TrieNode next = node.getMap().get(word[index]);
            if (next == null) {
                next = new TrieNode();
                node.setNum(node.getNum() + 1);
                node.getMap().put(word[index], next);
                if (index == word.length - 1) {
                    next.end = true;
                    next.setNum(1);
                    return true;
                } else {
                    return insert(word, index + 1, next);
                }
            } else if (index == word.length - 1) {
                // 如果存在 并且当前字符是最后一个字符 并且是end 那么就不应该插入
                if (next.end) {
                    return false;
                } else {
                    next.setEnd(true);
                    node.setNum(node.getNum() + 1);
                    next.setNum(next.getNum() + 1);
                    return true;
                }
            } else {
                boolean insertResult = insert(word, index + 1, next);
                if (insertResult) {
                    node.setNum(node.getNum() + 1);
                    return true;
                } else {
                    return false;
                }
            }
        }

        /**
         * 这个的返回值应该只有0或者1
         *
         * @param word
         * @return
         */
        public int countWordsEqualTo(String word) {
            if (word == null || word.isEmpty()) {
                return 0;
            }
            TrieNode pre = head;
            char[] wordChar = word.toCharArray();
            for (int i = 0; i < wordChar.length; i++) {
                TrieNode next = pre.getMap().get(wordChar[i]);
                if (next == null) {
                    return 0;
                }
                pre = next;
            }
            return pre.end ? pre.getNum() : 0;
        }

        /**
         * 统计以这个前缀为开头的单词数量
         *
         * @param prefix
         * @return
         */
        public int countWordsStartingWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) {
                return 0;
            }
            TrieNode pre = head;
            char[] wordChar = prefix.toCharArray();
            for (int i = 0; i < wordChar.length; i++) {
                TrieNode next = pre.getMap().get(wordChar[i]);
                if (next == null) {
                    return 0;
                }
                pre = next;
            }
            return pre.getNum();
        }

        /**
         * 删除某个单词
         *
         * @param word
         */
        public void erase(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            char[] wordChar = word.toCharArray();
            erase(wordChar,0,head);
        }

        public boolean erase(char[] word, int index, TrieNode node) {
            TrieNode next = node.getMap().get(word[index]);
            if (next == null) {
                return false;
            } else if (!next.isEnd()) {
                return false;
            } else if (next.getMap().isEmpty()) {
                node.setNum(node.getNum() - 1);
                return true;
            } else {
                boolean eraseNext = erase(word, index + 1, next);
                if (eraseNext) {
                    node.setNum(node.getNum() - 1);
                }
                return eraseNext;
            }
        }
    }

    /**
     * 前缀树Node
     */
    static class TrieNode {
        /**
         * 以当前节点为头的树包含了多少个单词
         */
        private int num;

        /**
         * 到此节点是否结束
         */
        private boolean end;

        /**
         * 下属前缀树
         */
        private Map<Character, TrieNode> map;

        /**
         * 构造函数
         */
        TrieNode() {
            num = 0;
            end = false;
            map = new HashMap<>();
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        public Map<Character, TrieNode> getMap() {
            return map;
        }

        public void setMap(Map<Character, TrieNode> map) {
            this.map = map;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("ap");
        System.out.println("a");
    }
}
