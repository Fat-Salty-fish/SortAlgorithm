package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/6
 */
public class LeetCode132分割回文串II {

    /**
     * 最少回文分割
     * dp即可
     * 最优可以用一维dp即可
     * 先用二维dp
     *
     * @param s
     * @return
     */
    public int minCut(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return 0;
        }
        // dp[i][j] 表示从字符串从i-j是否为一个回文字符串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = i + 1 > j - 1 || dp[i + 1][j - 1];
                }
            }
        }
        // 表示从0-i的字符串最少切割多少次 子串即全部为回文串
        int[] cutDp = new int[s.length()];
        Arrays.fill(cutDp, Integer.MAX_VALUE);
        for (int i = 0; i < s.length(); i++) {
            if (dp[0][i]) {
                cutDp[i] = 0;
            } else {
                // 每个位置都可以作为一个切割点
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cutDp[i] = Math.min(cutDp[i], cutDp[j] + 1);
                    }
                }
            }
        }
        return cutDp[s.length() - 1];
    }

    public static void main(String[] args) {
        String a = "abcdef";
        int result = new LeetCode132分割回文串II().minCut(a);
        System.out.println(result);
    }
}
