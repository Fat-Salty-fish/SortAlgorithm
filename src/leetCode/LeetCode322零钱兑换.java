package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/13
 */
public class LeetCode322零钱兑换 {

    /**
     * 状态：当前金币之和
     * 选择：每一个金币都可以被选择
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 动态规划 二刷
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        // 用于检查是否更新了结果
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    /**
     * 零钱兑换
     * 动态规划
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                // 为什么这里过滤了dp[i-coins[j]] != Integer.MAX_VALUE? 因为dp[i-coins[j]] 已经是无法得到了 就不必要再计算了 这里所谓的得不到，是指这个数已经被计算过了，那么不用拾取这个硬币的前提下这个amount已经计算过了，必定有更优的解
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    /**
     * BFS
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange4(int[] coins, int amount) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(amount);
        boolean[] visited = new boolean[amount + 1];
        visited[amount] = true;
        int used = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentAmount = queue.poll();
                if (currentAmount == 0) {
                    return used;
                }
                for (int temp : coins) {
                    if (currentAmount - temp >= 0 && !visited[currentAmount - temp]) {
                        queue.offer(currentAmount - temp);
                        visited[currentAmount - temp] = true;
                    }
                }
            }
            used++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int result = new LeetCode322零钱兑换().coinChange4(coins, amount);
        System.out.println(result);
    }
}
