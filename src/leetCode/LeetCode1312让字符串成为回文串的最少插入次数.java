package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/8
 */
public class LeetCode1312让字符串成为回文串的最少插入次数 {

    /**
     * 动态规划
     * 尝试一下
     *
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int stringLength = s.length();
        // dp数组 表示s[i][j]串变为回文串时的最少插入次数
        int[][] dp = new int[stringLength][stringLength];
        for (int i = stringLength - 2; i >= 0; i--) {
            for (int j = i + 1; j < stringLength; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][stringLength - 1];
    }

    /**
     * 二刷
     *
     * @param s
     * @return
     */
    public int minInsertions2(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 2; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        return dp[0][s.length() - 1];
    }
}
