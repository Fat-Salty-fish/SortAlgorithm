package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/3
 */
public class LeetCode50PowXN {

    /**
     * 实现x的n次幂
     * 从右到左 快速幂
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? helpPow(x, N) : 1.0 / helpPow(x, -N);
    }

    public double helpPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = helpPow(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    /**
     * 从左到右
     * n的二进制划分 表示x的几次方相乘
     * 快速幂
     */
    public double helpPow2(double x,long N){
        double result = 1.0;
        double X = x;
        while (N > 0) {
            if (N % 2 == 1) {
                result *= X;
            }
            X *= X;
            N /= 2;
        }
        return result;
    }
}
