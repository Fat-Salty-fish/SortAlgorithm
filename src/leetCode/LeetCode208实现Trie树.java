package leetCode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/5/17
 */
public class LeetCode208实现Trie树 {

    /**
     *
     */
    class Trie {

        /**
         * 前缀树树节点
         */
        public class TrieNode {
            /**
             * 维护此节点下的子节点
             */
            public Map<Character, TrieNode> children;

            /**
             * 是否为结尾节点
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
         * 前缀树前缀查询
         */
        public boolean startsWith(String prefix) {
            TrieNode current = root;
            for (int i = 0;i<prefix.length();i++){
                current = current.children.get(prefix.charAt(i));
                if (current == null){
                    return false;
                }
            }
            return true;
        }

    }

}
