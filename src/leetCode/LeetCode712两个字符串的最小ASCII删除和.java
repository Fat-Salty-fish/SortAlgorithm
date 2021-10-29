package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/20
 */
public class LeetCode712两个字符串的最小ASCII删除和 {

    /**
     * 动态规划特训
     * 有点最长公共子序列的感觉了
     * 也有点
     *
     * @param s1
     * @param s2
     * @return
     */
    public int minimumDeleteSum(String s1, String s2) {
        // 定义dp 表示s1的前i位和s2的前j位下 最小删除总和
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // base case
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // 两字符相同时 无需计算
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i][j - 1] + s2.charAt(j - 1), dp[i - 1][j] + s1.charAt(i - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
