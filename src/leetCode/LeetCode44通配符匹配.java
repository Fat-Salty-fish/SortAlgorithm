package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/3
 */
public class LeetCode44通配符匹配 {


    /**
     * 动态规划
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 初始化
        dp[0][0] = true;
        // p.length == 0时 s长度不为0则一定无法匹配
        // s.length == 0时 p有可能可以匹配
        char[] sCharArray = s.toCharArray();
        char[] pCharArray = p.toCharArray();
        for (int i = 1; i <= pLength; i++) {
            if (pCharArray[i - 1] == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        // 处理dp
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (pCharArray[j - 1] == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pCharArray[j - 1] == '*') {
                    dp[i][j] = dp[i - 1][j - 1] || dp[i - 1][j] || dp[i][j - 1];
                } else {
                    if (sCharArray[i - 1] == pCharArray[j - 1]) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }

    public static void main(String[] args) {
        String s = "cb";
        String p = "?a";
        boolean result = new LeetCode44通配符匹配().isMatch(s,p);
    }
}
