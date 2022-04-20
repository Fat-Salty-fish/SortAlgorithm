package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer16数值的整数次方 {

    /**
     * pow函数
     * x的n次方 把n看作二进制之后
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        boolean minus = n < 0;
        if (minus) {
            n = -n;
        }
        double result = 1;
        for (int i = 0; i <= 31; i++) {
            int bit = (n >> i) & 1;
            if (bit == 1) {
                result *= x;
            }
            x = x * x;
        }
        return minus? 1/result : result;
    }
}
