package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/15
 */
public class LeetCode256粉刷房子 {

    /**
     * 粉刷房子
     * 动态规划特训
     * 尝试定义dp:dp[i][j] 表示 前i个房子 当第i个房子为j颜色时 粉刷出来成本最低值
     * 状态：第i个房子 和 第j个颜色
     * 选择：三种颜色
     * 状态转移方程：
     * dp[i][j] = min(k:0->1)dp[i-1][k]
     *
     * @param costs
     * @return
     */
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] dp = new int[costs.length + 1][3];
        // i == 0 时 没有房子可以粉刷
        // i == 1 时 随便刷
        for (int i = 0; i <= 2; i++) {
            dp[1][i] = costs[0][i];
        }
        // 由此可看到 dp只与上一行的三个数有关 可以压缩为一行
        for (int i = 2; i <= costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i - 1][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i - 1][1];
            dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]) + costs[i - 1][2];
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= 2; i++) {
            result = Math.min(result, dp[costs.length][i]);
        }
        return result;
    }

    /**
     * 压缩dp数组
     *
     * @param costs
     * @return
     */
    public int minCost2(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int first = costs[0][0];
        int second = costs[0][1];
        int third = costs[0][2];
        for (int i = 1; i < costs.length; i++) {
            int tempFirst = Math.min(second,third) + costs[i][0];
            int tempSecond = Math.min(first,third) + costs[i][1];
            int tempThird = Math.min(first,second) + costs[i][2];
            first = tempFirst;
            second = tempSecond;
            third = tempThird;
        }
        int min = Math.min(first,second);
        min = Math.min(min,third);
        return min;
    }

    public static void main(String[] args) {
        int[][] costs = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        int result = new LeetCode256粉刷房子().minCost2(costs);
        System.out.println(result);
    }
}
