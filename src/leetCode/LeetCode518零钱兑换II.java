package leetCode;

import java.util.Arrays;

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
                } else {
                    dp[i][j] = dp[i - 1][j];
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

    /**
     * 二刷零钱兑换2
     * 动态规划
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }
        int coinNum = coins.length;
        Arrays.sort(coins);
        // 总值小于硬币的最小值 肯定无法实现
        if (amount < coins[0]) {
            return 0;
        }
        // 表示在使用coinNum下 并且凑金额为amount时 有dp[coinNum][amount]种方案
        int[][] dp = new int[coinNum][amount + 1];
        // amount = 1时 方法数为1
        for (int i = 0; i < coinNum; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < coinNum; i++) {
            int currentCoin = coins[i];
            for (int j = 1; j <= amount; j++) {
                if (currentCoin <= j) {
                    dp[i][j] = i > 0 ? dp[i - 1][j] + dp[i][j - currentCoin] : dp[i][j - currentCoin];
                } else {
                    dp[i][j] = i > 0 ? dp[i - 1][j] : 0;
                }
            }
        }
        return dp[coinNum - 1][amount];
    }

    /**
     * 零钱兑换
     * 动态规划解决
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change3(int amount, int[] coins) {
        int[] planDp = new int[amount + 1];
        planDp[0] = 1;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 1; i <= amount; i++) {
                int currentCoin = coins[j];
                if (currentCoin <= i) {
                    planDp[i] += planDp[i - currentCoin];
                }
            }
        }
        return planDp[amount];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 5};
        int amount = 5;
        int result = new LeetCode518零钱兑换II().change3(amount, array);
        System.out.println("结果为:" + result);
    }
}
