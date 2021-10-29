package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/28
 */
public class LeetCode650只有两个键的键盘 {

    /**
     * 动态规划
     * 状态定义： n 屏幕上目标字符数量
     * dp[n] 目标字数为n时 需要的最少操作数
     * 状态转移方程
     *
     * @param n
     * @return
     */
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        // 笔记本上本来就有一个字符
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            // 遍历 寻找适合的因数
            for (int j = 1; j < i; j++) {
                if (i % j == 0) {
                    // -1是因为已经有了j个数 +1 是因为需要复制一次
                    dp[i] = Math.min(dp[i], dp[j] + i / j - 1 + 1);
                }
            }
        }
        return dp[n];
    }
}
