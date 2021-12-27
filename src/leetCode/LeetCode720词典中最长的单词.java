package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/24
 */
public class LeetCode720词典中最长的单词 {


    /**
     * 前缀树节点
     */
    class TrieNode {

        Map<Character, TrieNode> children;

        boolean isEnd;

        int deepth;

        int index;

        public TrieNode() {
            children = new HashMap<>();
            isEnd = false;
            deepth = 0;
            index = 0;
        }

    }

    /**
     * 前缀树
     */
    class TrieTree {
        TrieNode root;

        public TrieTree() {
            root = new TrieNode();
        }

        /**
         * 向前缀树中
         *
         * @param word
         */
        public void add(String word, int index) {
            TrieNode currentHead = root;
            for (int i = 0; i < word.length(); i++) {
                Character currentChar = word.charAt(i);
                TrieNode search = currentHead.children.get(currentChar);
                if (search == null) {
                    search = new TrieNode();
                    search.deepth = i + 1;
                    currentHead.children.put(currentChar, search);
                }
                currentHead = search;
            }
            currentHead.isEnd = true;
            currentHead.index = index;
        }

    }


    /**
     * 使用前缀树解决
     * 前缀树是怎么解决的？
     * 将单词全部插入前缀树后 如何判断
     *
     * @param words
     * @return
     */
    public String longestWord(String[] words) {
        TrieTree trieTree = new TrieTree();
        for (int i = 0; i < words.length; i++) {
            trieTree.add(words[i], i);
        }
        return dfsFromTrie(trieTree,words);
    }

    /**
     * dfs寻找符合条件的字符串
     *
     * @param trieTree
     * @param array
     * @return
     */
    public String dfsFromTrie(TrieTree trieTree, String[] array) {
        String result = "";
        Stack<TrieNode> trieNodeStack = new Stack<>();
        trieNodeStack.push(trieTree.root);
        // 用栈来遍历整个前缀树
        while (!trieNodeStack.isEmpty()) {
            TrieNode currentNode = trieNodeStack.pop();
            // 只有是end的节点或者是根节点才处理
            if (currentNode.isEnd || currentNode == trieTree.root) {
                if (currentNode != trieTree.root) {
                    int currentIndex = currentNode.index;
                    String indexStr = array[currentIndex];
                    if (indexStr.length() > result.length() || (indexStr.length() == result.length() && indexStr.compareTo(result) < 0)) {
                        result = indexStr;
                    }
                }
                for (TrieNode node : currentNode.children.values()) {
                    trieNodeStack.push(node);
                }
            }
        }
        return result;
    }

    /**
     * 尝试Set解决
     *
     * @param words
     * @return
     */
    public String longestWord2(String[] words) {
        String result = "";
        Set<String> stringSet = new HashSet<>();
        for (String a : words) {
            stringSet.add(a);
        }
        Arrays.sort(words);
        for (String a : words) {
            boolean check = true;
            for (int i = 1; i < a.length(); i++) {
                if (!stringSet.contains(a.substring(0, i))) {
                    check = false;
                    break;
                }
            }
            if (check) {
                result = a.length() > result.length() ? a : result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
//        String[] array = new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
//        String sub = "moch".substring(0, "moch".length());
//        System.out.println(sub);

        int compare = "apple".compareTo("apply");
        System.out.println(compare);
    }
}
