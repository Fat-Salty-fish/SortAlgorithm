package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer10_2青蛙跳台阶问题 {

    int mod = 1000000007;


    public int numWays(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int temp = (first+second) % mod;
            first = second;
            second = temp;
        }
        return second;
    }
}
