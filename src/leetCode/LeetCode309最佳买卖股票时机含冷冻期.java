package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/16
 */
public class LeetCode309最佳买卖股票时机含冷冻期 {

    /**
     * 动态规划特训
     * 和leetcode714差不多其实
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        // j = 0时 手里没有股票 j = 1时 手里有股票 j = 2时 处于冷静期
        int[][] dp = new int[prices.length + 1][3];
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            // 手里没有股票并且不处于封禁期 可能是因为之前就没有股票 或者是因为前一天是封禁期 今天已经不是封禁期了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2]);
            // 手里有股票 可能是之前一直有股票 也可能是今天刚买了
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
            // 今天处于封禁期 那必然是昨天就有股票 并且昨天卖掉了
            dp[i][2] = dp[i-1][1] + prices[i-1];
        }
        return Math.max(dp[prices.length][0],dp[prices.length][2]);
    }
}
