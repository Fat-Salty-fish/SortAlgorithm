package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/5
 */
public class LeetCode372超级次方 {

    public int mod = 1337;

    /**
     * 超级次方
     *
     * @param a
     * @param b
     * @return
     */
    public int superPow(int a, int[] b) {
        if (a == 0) {
            if (b[b.length - 1] == 0) {
                return 1;
            }
            return 0;
        }
        if (a == 1) {
            return 1;
        }
        int last = b[b.length - 1];
        int lastPow = (int) powHelp(a, last) % mod;
        if (b.length == 1) {
            return lastPow;
        }
        int[] frontArray = Arrays.copyOf(b, b.length - 1);
        int frontPow = superPow(a, frontArray);
        int frontPow2 = (int) powHelp(frontPow, 10) % mod;
        return (frontPow2 * lastPow) % mod;
    }

    /**
     * 快速幂
     *
     * @param a
     * @param b
     * @return
     */
    public long powHelp(long a, long b) {
        if (a == 0) {
            return 1;
        }
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a;
        }
        long help = powHelp(a, b / 2);
        return b % 2 == 0 ? ((help % mod) * (help % mod)) % mod : ((help % mod) * (help % mod) * a % mod) % mod;
    }

    public static void main(String[] args) {
        int a = 2147483647;
        int[] array = new int[]{2, 0, 0};
        int result = new LeetCode372超级次方().superPow(a, array);
        System.out.println(result);
    }
}
