package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/15
 */
public class LeetCode265粉刷房子II {

    /**
     * 动态规划特训
     * 这道题相比LeetCode256 主要问题在于k值不再确定 除了for循环还有更好的办法么？
     *
     * @param costs
     * @return
     */
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length + 1][costs[0].length];
        for (int i = 0; i < costs[0].length; i++) {
            dp[1][i] = costs[0][i];
        }
        for (int i = 2; i <= costs.length; i++) {
            int sum = 0;
            for (int k = 0; k < costs[0].length; k++) {
                sum += dp[i - 1][k];
            }
            for (int j = 0; j < costs[0].length; j++) {
                int minValue = Integer.MAX_VALUE;
                for (int k = 0; k < costs[0].length; k++) {
                    if (k == j) {
                        continue;
                    }
                    minValue = Math.min(minValue, dp[i - 1][k]);
                }
                dp[i][j] = minValue + costs[i - 1][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < costs[0].length; i++) {
            result = Math.min(result,dp[costs.length][i]);
        }
        return result;
    }
}
