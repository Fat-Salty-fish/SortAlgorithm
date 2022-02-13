package leetCode;

import java.util.*;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/6
 */
public class LeetCode140单词拆分II {

    /**
     * 保存单词的Set
     */
    Set<String> wordSet;

    /**
     * 最终返回的结果
     */
    List<String> result = new ArrayList<>();

    /**
     * 尝试DFS
     *
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        wordSet = new HashSet<>(wordDict);
        dfs(s,new ArrayList<>());
        return result;
    }

    public void dfs(String currentStr, List<String> stringList) {
        if (currentStr.isEmpty()) {
            result.add(String.join(" ", stringList).trim());
            return;
        }
        for (int i = 1; i <= currentStr.length(); i++) {
            String subString = currentStr.substring(0, i);
            if (wordSet.contains(subString)) {
                stringList.add(subString);
                dfs(currentStr.substring(i),stringList);
                stringList.remove(stringList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String test = "catsanddog";
        List<String> wordList = Arrays.asList("cat","cats","and","sand","dog");
        List<String> result = new LeetCode140单词拆分II().wordBreak(test,wordList);
    }

}
