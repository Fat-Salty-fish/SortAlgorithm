package leetCode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/8/10
 */
public class LeetCode212单词搜索II {

    public class TrieNode {
        /**
         * 子节点
         */
        public Map<Character, TrieNode> children;

        /**
         * 是否为单词的最后一个节点
         */
        public boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    public class Trie {
        public TrieNode root;


        public Trie() {
            root = new TrieNode();
        }

        /**
         * 插入单词
         *
         * @param word
         */
        public void insert(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode temp = currentNode.children.get(word.charAt(i));
                if (temp == null) {
                    temp = new TrieNode();
                    currentNode.children.put(word.charAt(i), temp);
                }
                currentNode = temp;
            }
            currentNode.isEndOfWord = true;
        }

        /**
         * 全匹配查询单词
         *
         * @param word
         * @return
         */
        public boolean search(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode temp = currentNode.children.get(word.charAt(i));
                if (temp == null) {
                    return false;
                }
                currentNode = temp;
            }
            return currentNode.isEndOfWord;
        }

        /**
         * 前缀匹配单词
         *
         * @param word
         * @return
         */
        public boolean startWith(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode temp = currentNode.children.get(word.charAt(i));
                if (temp == null) {
                    return false;
                }
                currentNode = temp;
            }
            return true;
        }
    }

    public List<String> result = new ArrayList<>();


    /**
     * 单词搜索
     * 用前缀树来解决单词是否符合的问题
     * 用回溯来解决单词匹配
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }
        // 用前缀树来维护所有单词 便于查询
        Trie wordsTrie = new Trie();
        for (String word : words) {
            wordsTrie.insert(word);
        }
        boolean[][] marks = new boolean[board.length][board[0].length];
        // 回溯验证
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                checkWord(board, wordsTrie, new StringBuilder(), i, j, marks);
            }
        }
        return result;
    }

    /**
     * 递归验证是否有符合条件的单词
     * 结果更新在result数组中
     *
     * @param board       边界数组
     * @param trieTree    前缀树
     * @param currentPath 当前path
     * @param x           当前x索引位置
     * @param y           当前y索引位置
     */
    public void checkWord(char[][] board, Trie trieTree, StringBuilder currentPath, Integer x, Integer y, boolean[][] marks) {
        // 如果此位置字符已经被处理过 则不再处理
        if (marks[x][y]) {
            return;
        }
        currentPath.append(board[x][y]);
        // 没有以此为开头的字符串 直接结束
        if (!trieTree.startWith(currentPath.toString())) {
            currentPath.deleteCharAt(currentPath.length() - 1);
            return;
        }
        // 有以此为开头的字符串 先做标记
        marks[x][y] = true;
        // 向下回溯 如果有符合的单词 则向结果集里添加
        if (trieTree.search(currentPath.toString())) {
            // 去重
            if (!result.contains(currentPath.toString())) {
                result.add(currentPath.toString());
            }
        }
        int left = y - 1;
        int right = y + 1;
        int up = x - 1;
        int down = x + 1;
        if (left >= 0) {
            checkWord(board, trieTree, currentPath, x, left, marks);
        }
        if (right < board[0].length) {
            checkWord(board, trieTree, currentPath, x, right, marks);
        }
        if (up >= 0) {
            checkWord(board, trieTree, currentPath, up, y, marks);
        }
        if (down < board.length) {
            checkWord(board, trieTree, currentPath, down, y, marks);
        }

        currentPath.deleteCharAt(currentPath.length() - 1);
        marks[x][y] = false;
    }

    public static void main(String[] args) {
        char[][] board = {{'a'},{'a'}};
        String[] words = {"a"};
        List<String> result = new LeetCode212单词搜索II().findWords(board,words);
        System.out.printf("a");
    }
}
