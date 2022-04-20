package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer10_1斐波那契数列 {

    int mod = 1000000007;

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int first = 0;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = (first + second) % mod;
            first = second;
            second = temp;
        }
        return second;
    }
}
