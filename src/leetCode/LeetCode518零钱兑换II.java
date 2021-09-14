package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/13
 */
public class LeetCode518零钱兑换II {

    /**
     * 定义dp[i][j]
     * 状态i:当前总和
     * 状态j:前j个金币
     * 选择:各个金币
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int[][] dp = new int[coins.length + 1][amount + 1];
        // 初始化 amount为0时 有1种办法可以凑齐
        // coin index = 0时 均为0
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                }
            }
        }
        return dp[coins.length][amount];
    }

    /**
     * 回溯法解决
     * 有个问题是可能会出现路径重复的情况
     * 暂时看来无法解决
     *
     * @param amount
     * @param coins
     * @return
     */
    public int changeWithDeep(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        deep(amount, coins);
        return result;
    }

    public int result = 0;

    public void deep(int currentAmount, int[] coins) {
        if (currentAmount == 0) {
            result++;
            return;
        }
        for (int coin : coins) {
            if (coin <= currentAmount) {
                deep(currentAmount - coin, coins);
            }
        }
    }
}
