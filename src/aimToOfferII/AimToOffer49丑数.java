package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/6
 */
public class AimToOffer49丑数 {

    /**
     * 丑数
     *
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(Math.min(2 * dp[p2], 3 * dp[p3]), 5 * dp[p5]);
            if (dp[i] == 2 * dp[p2]) {
                p2++;
            }
            if (dp[i] == 3 * dp[p3]) {
                p3++;
            }
            if (dp[i] == 5 * dp[p5]) {
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 10;
        int ugly = new AimToOffer49丑数().nthUglyNumber(n);
        System.out.println(ugly);
    }
}
