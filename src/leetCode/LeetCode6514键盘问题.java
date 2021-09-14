package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/8
 */
public class LeetCode6514键盘问题 {

    /**
     * 4键问题
     * 先考虑状态 i 表示当前剩余按键次数 j 表示当前屏幕上的A字符数量 k表示当前粘贴板上的A字符数量
     *
     * @param n
     * @return
     */
    public int maxA(int n) {
        return dp(n, 0, 0);
    }


    public int dp(int n, int screen, int board) {
        if (n <= 0) {
            return screen;
        }
        int a = dp(n - 1, screen + 1, board);
        int cv = dp(n - 1, screen + board, board);
        int cc = dp(n - 2, screen, screen);
        int max = Math.max(a, cv);
        max = Math.max(max, cc);
        return max;
    }

    /**
     * 调整状态数量和选择
     * 只有一个状态 就是剩余的按键数量
     * 定义dp[n] 表示剩余n次按键数量时的屏幕上最大的A字符数量
     * 选择只有两种情况 连续按A和在按了几次A之后 按C-A C-C 和不停地C-V
     *
     * @param n
     * @return
     */
    public int maxA2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // dp[i]如何计算？ 连续按A的情况下 dp[i]=i
        // 另外一种情况下 需要定位到什么时候复制可以达到A字符最大化
        for (int i = 2; i <= n; i++) {
            // 第i次直接按A
            dp[i] = dp[i - 1] + 1;
            for (int j = 2; j < i; j++) {
                // 如果从第j次开始c-v 则连续复制后的值为dp[j-2]*(i-j)还有原来的dp[j-2] 共dp[j-2][i-j+1]个A
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }
        return dp[n];
    }
}
