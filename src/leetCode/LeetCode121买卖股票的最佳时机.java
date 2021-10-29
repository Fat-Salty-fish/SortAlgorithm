package leetCode;

/**
 * @author acer
 * @Date 2019/7/3 1:26
 */
public class LeetCode121买卖股票的最佳时机 {
    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     * <p>
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
     * <p>
     * 注意你不能在买入股票前卖出股票。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
     * 示例 2:
     * <p>
     * 输入: [7,6,4,3,1]
     * 输出: 0
     * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > profit) {
                profit = prices[i] - minPrice;
            }
        }
        return profit;
    }


    /**
     * 动态规划特训
     * 二刷最大利润
     * 考虑动态规划？
     * 定义dp[i] 用于记录第i天(包含)之前 价格的最低点
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] dp = new int[prices.length + 1];
        dp[0] = 0;
        dp[1] = prices[0];
        int result = Integer.MIN_VALUE;
        for (int i = 2; i <= prices.length; i++) {
            // 记录最小价格
            dp[i] = Math.min(dp[i-1],prices[i-1]);
            // 计算最大利润 如何计算最大利润？应该要记录一个最大值吧？其实也不用 尝试用每一天的钱减去之前的最小值 然后判断即可
            result = Math.max(result,prices[i-1] - dp[i]);
        }
        if (result <= 0){
            return 0;
        }
        return result;
    }
}
