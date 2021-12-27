package others;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author lizhongjie
 * @desc 前缀树
 * @create_time 2021/8/10
 */
public class Trie {

    /**
     * 前缀树树节点
     */
    public static class TrieNode {
        /**
         * 维护此节点下的子节点
         */
        public Map<Character, TrieNode> children;

        /**
         * 用来标记此节点是否为一个单词的结尾
         */
        public boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    /**
     * 前缀树的根节点
     */
    public TrieNode root;

    /**
     * 构造函数
     */
    public Trie() {
        root = new TrieNode();
    }


    /**
     * 前缀树插入
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
        currentNode.endOfWord = true;
    }


    /**
     * 递归插入前缀树
     *
     * @param word
     */
    public void insertRecursive(String word) {
        insertRecursive(root, word, 0);
    }

    /**
     * 递归插入前缀树
     *
     * @param currentNode
     * @param word
     * @param index
     */
    public void insertRecursive(TrieNode currentNode, String word, Integer index) {
        if (index == word.length()) {
            currentNode.endOfWord = true;
            return;
        }
        TrieNode temp = currentNode.children.get(word.charAt(index));
        if (temp == null) {
            temp = new TrieNode();
            currentNode.children.put(word.charAt(index), temp);
        }
        insertRecursive(temp, word, index + 1);
    }


    /**
     * 前缀树全匹配查询
     */
    public boolean search(String word) {
        TrieNode current = root;
        // 查询匹配的单词
        for (int i = 0; i < word.length(); i++) {
            current = current.children.get(word.charAt(i));
            if (current == null) {
                return false;
            }
        }
        // 单词结尾标识需要为true
        return current.endOfWord;
    }

    /**
     * 递归全匹配查询
     *
     * @param word
     * @return
     */
    public boolean searchRecursive(String word) {
        return searchRecursive(root, word, 0);
    }

    public boolean searchRecursive(TrieNode currentNode, String word, Integer index) {
        if (index == word.length()) {
            return currentNode.endOfWord;
        }
        TrieNode temp = currentNode.children.get(word.charAt(index));
        if (temp == null) {
            return false;
        }
        return searchRecursive(temp, word, index + 1);
    }

    /**
     * 前缀树前缀查询
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            current = current.children.get(prefix.charAt(i));
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 删除前缀树中的某个单词
     *
     * @param word
     */
    public boolean deleteRecursive(String word) {
        return deleteRecursive(root, word, 0);
    }

    /**
     * 递归删除前缀树中的某个单词
     *
     * @param currentNode
     * @param word
     * @param index
     */
    public boolean deleteRecursive(TrieNode currentNode, String word, Integer index) {
        if (index == word.length()) {
            // 如果当前节点不是此单词的结尾 则删除失败
            if (!currentNode.endOfWord) {
                return false;
            }
            currentNode.endOfWord = false;
            return true;
        }
        TrieNode trieNode = currentNode.children.get(word.charAt(index));
        if (trieNode == null) {
            return false;
        }
        // 先删除下一个字母 删除成功了之后才删除当前字母
        if (deleteRecursive(trieNode, word, index + 1)) {
            currentNode.children.remove(word.charAt(index));
            return true;
        }
        return false;
    }

}
