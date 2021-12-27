package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/28
 */
public class LeetCode139单词拆分 {

    /**
     * 动态规划特训
     * 单词拆分 如何用到动态规划的方法？
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        wordDictSet.add("");
        // 定义dp[i] 表示s(0,i)的字符串是否能被空格分隔后在wordDict存在
        // 如果dp[j]合法 则只需要证明s(j,i)字符串是否合法 即可证明s(0,i)是否合法
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            // 分隔点
            for (int j = 0; j <= i; j++) {
                if (dp[i - 1] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("cat");
        boolean result = new LeetCode139单词拆分().wordBreak(s, wordDict);
    }
}
