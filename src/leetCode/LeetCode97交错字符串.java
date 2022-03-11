package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/1
 */
public class LeetCode97交错字符串 {

    /**
     * 三指针？ 试试吧 看评论不太行
     * 动态规划
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] check = new boolean[s1.length() + 1][s2.length() + 1];
        check[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int position = i + j - 1;
                if (i >= 1) {
                    char s1Char = s1.charAt(i - 1);
                    check[i][j] = check[i][j] || (check[i - 1][j] && (s3.charAt(position) == s1Char));
                }
                if (j >= 1) {
                    char s2Char = s2.charAt(j - 1);
                    check[i][j] = check[i][j] || (check[i][j - 1] && (s3.charAt(position) == s2Char));
                }
            }
        }
        return check[s1.length()][s2.length()];
    }

    /**
     * 微软模拟面试 三指针想了想就不太行 因为可能有s1和s2同时符合的情况 此时就没办法处理了 只能动态规划
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                int s3Index = i + j - 1;
                if (i >= 1) {
                    dp[i][j] = dp[i][j] || (dp[i - 1][j] && s3.charAt(s3Index) == s1.charAt(i - 1));
                }
                if (j >= 1) {
                    dp[i][j] = dp[i][j] || (dp[i][j - 1] && s3.charAt(s3Index) == s2.charAt(j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 交错字符串
     * s3里的字符必须存在于s1或s2中
     * 是否需要三维dp？
     * 不需要 因为s3内的字符全部来自于s1和s2 所以只需要看前i个s1的字符和前j个s2的字符能否组成前i+j个s3的字符
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave3(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int s1Length = s1.length();
        int s2Length = s2.length();
        boolean[][] dp = new boolean[s1Length + 1][s2Length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1Length; i++) {
            dp[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= s2.length(); i++) {
            dp[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= s1Length; i++) {
            for (int j = 1; j <= s2Length; j++) {
                int s3Index = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && (s1.charAt(i - 1) == s3.charAt(s3Index))) || (dp[i][j - 1] && (s2.charAt(j - 1) == s3.charAt(s3Index)));
            }
        }
        return dp[s1Length][s2Length];
    }
}
