package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/8
 */
public class LeetCode516最长回文子序列 {


    /**
     * 最长回文子序列
     * 动态规划
     * 如何寻找状态转移方程？
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int stringLength = s.length();
        //定义dp dp[i][j]表示s[i,j]字符串下 最长回文子序列的长度
        int[][] dp = new int[stringLength][stringLength];
        // 只有一个字符的时候 一定是一个回文序列
        for (int i = 0; i < stringLength; i++) {
            dp[i][i] = 1;
        }
        // 必须知道dp[i+1][j-1] dp[i+1][j] 和dp[i][j-1] 才能知道答案
        // 需要从右下角开始 往上遍历
        for (int i = stringLength - 2; i >= 0; i--) {
            for (int j = i + 1; j < stringLength; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        // 要返回的是什么？要返回的是dp[0][stringLength-1]
        // 即dp数组右上角的数
        return dp[0][stringLength - 1];
    }

    /**
     * 动态规划特训
     * 这个是回文子序列 不是回文子串 所以dp[i][j] = dp[i+1][j-1] +2 (当s.charAt(i)==s.charAt(j))时
     * 如果是回文子串 则需要定义booleanDp[i][j] 表示(i,j)下的子串是否为回文子串
     *
     * @param s
     * @return
     */
    public int longestPalindromeSubseq2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int stringLength = s.length();
        int[][] dp = new int[stringLength][stringLength];
        for (int i = 0; i < stringLength; i++) {
            dp[i][i] = 1;
        }
        for (int i = stringLength - 1; i >= 0; i--) {
            for (int j = i + 1; j < stringLength; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][stringLength - 1];
    }

}
