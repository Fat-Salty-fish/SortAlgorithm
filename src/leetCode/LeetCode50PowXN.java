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
    public double helpPow2(double x, long N) {
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

    /**
     * 微软模拟面试 后面想到的 对n进行除以2计算
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        return n < 0 ? (1.0 / help2(x, -n)) : help2(x, n);
    }

    public double help(double x, int n) {
        double result = 1.0;
        int now = n;
        double base = x;
        while (now > 0) {
            if (now % 2 == 1) {
                result = result * base;
            }
            base *= base;
            now /= 2;
        }
        return result;
    }

    public double help2(double x, int n) {
        double result = 1.0;
        double current = x;
        for (int i = 0; i <= 31; i++) {
            int yes = (n >> i) & 1;
            if (yes == 1) {
                result *= current;
            }
            current *= current;
        }
        return result;
    }

    public static void main(String[] args) {
        double x = 2.0;
        int n = 10;
        System.out.println(new LeetCode50PowXN().myPow2(x, n));
    }
}
