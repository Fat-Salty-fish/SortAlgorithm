package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/8
 */
public class LeetCode1804实现Trie前缀树2 {

    /**
     * 实现前缀
     */
    class Trie {

        TrieNode head;

        public Trie() {
            head = new TrieNode();
        }

        /**
         * 插入单词 并且可以重复插入 并且需要计数 真有你的
         *
         * @param word
         */
        public void insert(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = head;
            for (int i = 0; i < chars.length; i++) {
                TrieNode temp = node.getNodeMap().get(chars[i]);
                if (temp == null) {
                    temp = new TrieNode();
                    node.getNodeMap().put(chars[i], temp);
                }
                node.setPathNum(node.getPathNum() + 1);
                node = temp;
            }
            node.setEndNum(node.getEndNum() + 1);
            node.setPathNum(node.getPathNum() + 1);
            node.setEnd(true);
        }

        public int countWordsEqualTo(String word) {
            if (word == null || word.isEmpty()) {
                return 0;
            }
            char[] chars = word.toCharArray();
            TrieNode node = head;
            for (int i = 0; i < chars.length; i++) {
                TrieNode next = node.getNodeMap().get(chars[i]);
                if (next == null) {
                    return 0;
                }
                node = next;
            }
            return node.isEnd() ? node.endNum : 0;
        }

        public int countWordsStartingWith(String prefix) {
            if (prefix == null || prefix.isEmpty()) {
                return 0;
            }
            char[] chars = prefix.toCharArray();
            TrieNode node = head;
            for (int i = 0; i < chars.length; i++) {
                TrieNode next = node.getNodeMap().get(chars[i]);
                if (next == null) {
                    return 0;
                }
                node = next;
            }
            return node.pathNum;
        }

        public void erase(String word) {
            if (word == null || word.isEmpty()) {
                return;
            }
            char[] chars = word.toCharArray();
            TrieNode node = head;
            for (int i = 0; i < word.length(); i++) {
                TrieNode temp = node.getNodeMap().get(chars[i]);
                if (temp == null) {
                    return;
                }
                node.setPathNum(node.getPathNum() - 1);
                node = temp;
            }
            node.setPathNum(node.getPathNum() - 1);
            node.setEndNum(node.getEndNum() - 1);
            if (node.getEndNum() == 0) {
                node.setEnd(false);
            }
        }
    }

    /**
     * 前缀树节点
     */
    class TrieNode {

        /**
         * 子节点map
         */
        private Map<Character, TrieNode> nodeMap;

        /**
         * 当前节点是否为结束节点
         */
        private boolean end;

        /**
         * 以当前节点为结束节点的单词有多少个
         */
        private int endNum;

        /**
         * 以当前节点为路径的单词有多少个
         */
        private int pathNum;

        public TrieNode() {
            nodeMap = new HashMap<>();
        }

        public Map<Character, TrieNode> getNodeMap() {
            return nodeMap;
        }

        public void setNodeMap(Map<Character, TrieNode> nodeMap) {
            this.nodeMap = nodeMap;
        }

        public boolean isEnd() {
            return end;
        }

        public void setEnd(boolean end) {
            this.end = end;
        }

        public int getEndNum() {
            return endNum;
        }

        public void setEndNum(int endNum) {
            this.endNum = endNum;
        }

        public int getPathNum() {
            return pathNum;
        }

        public void setPathNum(int pathNum) {
            this.pathNum = pathNum;
        }
    }
}
