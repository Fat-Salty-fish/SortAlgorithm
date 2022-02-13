package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/10
 */
public class LeetCode1335工作计划的最低难度 {


    /**
     * 工作难度
     * 感觉像是滑动窗口 用一天完成最多的任务 然后把剩下来的工作均摊到每一天即可
     * 完了 bbq了 是动态规划
     *
     * @param jobDifficulty
     * @param d
     * @return
     */
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) {
            return -1;
        }
        if (jobDifficulty.length == d) {
            return Arrays.stream(jobDifficulty).sum();
        }
        // 动态规划 dp[i][j]表示第i天完成前j项任务的最小难度
        int[][] dp = new int[d + 1][jobDifficulty.length + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= d; i++) {
            dp[i][0] = Integer.MAX_VALUE / 2;
        }
        for (int j = 1; j <= jobDifficulty.length; j++) {
            dp[0][j] = Integer.MAX_VALUE / 2;
        }
        for (int i = 1; i <= d; i++) {
            for (int j = i; j <= jobDifficulty.length; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
                int maxDifficulty = jobDifficulty[j - 1];
                // 需要从后往前遍历
                for (int k = j - 1; k >= i - 1; k--) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[k]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + maxDifficulty);
                }
            }
        }
        return dp[d][jobDifficulty.length];
    }

    public static void main(String[] args) {
        int[] array = {6, 5, 4, 3, 2, 1};
        int d = 2;
        int result = new LeetCode1335工作计划的最低难度().minDifficulty(array, d);
        System.out.println(result);
    }

}
