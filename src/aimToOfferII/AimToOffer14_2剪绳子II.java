package aimToOfferII;

import java.math.BigInteger;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer14_2剪绳子II {

    int mod = 1000000007;

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
        // 这两个题有什么不一样的？
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.valueOf(1);
        dp[2] = BigInteger.valueOf(2);
        dp[3] = BigInteger.valueOf(3);
        dp[4] = BigInteger.valueOf(4);
        for (int i = 5; i <= n; i++) {
            dp[i] = BigInteger.ZERO;
            for (int j = 1; j < i; j++) {
                dp[i] = dp[i].max(dp[j].multiply(dp[i - j]));
            }
        }
        return dp[n].mod(BigInteger.valueOf(mod)).intValue();
    }
}
