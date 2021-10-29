package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/28
 */
public class LeetCode343整数拆分 {

    /**
     * 动态规划特训
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n == 2) {
            // 2 只能被分解为 1+1
            return 1;
        }
        if (n == 3) {
            // 3 只能被分解为 1+2
            return 2;
        }
        // 可以缩减为只有2个int 保存dp[i-2]和dp[i-3]的值
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] * 2, dp[i - 3] * 3);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("结果" + new LeetCode343整数拆分().integerBreak(n));
    }
}
