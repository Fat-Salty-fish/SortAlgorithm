package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/16
 */
public class LeetCode714买卖股票的最佳时机含手续费 {

    /**
     * 动态规划特训
     * 一开始没想到如何进行状态转移
     * dp[i][j] 表示第i天之后 手中有/无股票时的利润
     * 状态：i 第i天之后
     * j j=0时 表示手里无股票 j=1时 表示手里有股票
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[][] dp = new int[prices.length + 1][2];
        // i == 0时 没有股票可以买卖
        // i == 1时 只有一支股票可以买卖
        dp[1][0] = 0;
        dp[1][1] = -prices[0];
        for (int i = 2; i <= prices.length; i++) {
            // 当前手里没有股票 可能之前就已经没了 或者今天卖掉了
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
            // 当前手里有股票 可能之前已经有了 或者今天刚买入
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[prices.length][0];
    }
}
