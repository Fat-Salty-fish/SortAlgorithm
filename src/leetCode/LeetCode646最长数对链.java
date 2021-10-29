package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/20
 */
public class LeetCode646最长数对链 {

    /**
     * 动态规划特训
     * 类似最长递增子序列
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < pairs.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[][] pairs = {{-6, 9}, {1, 6}, {8, 10}, {-1, 4}, {-6, -2}, {-9, 8}, {-5, 3}, {0, 3}};
        int result = new LeetCode646最长数对链().findLongestChain(pairs);
        System.out.println("结果" + result);
    }
}
