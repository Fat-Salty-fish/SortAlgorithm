package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/27
 */
public class AimToOffer14_1剪绳子 {
    /**
     * 初级动态规划
     *
     * @param n
     * @return
     */
    public int cuttingRope(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        if (n == 4) {
            return 4;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 4;
        for (int i = 5; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(Math.max(j * (i - j), j * dp[i - j]), dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int result = new AimToOffer14_1剪绳子().cuttingRope(n);
        System.out.println(result);
    }
}
