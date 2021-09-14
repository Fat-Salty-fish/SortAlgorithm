package leetCode;

/**
 * @author acer
 * @Date 2019/8/24 13:57
 */
public class LeetCode509斐波那契数 {
    public int fib(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (N == 1) {
            return 2;
        } else {
            return fib(N - 1) + fib(N - 2);
        }
    }

    public int fib2(int N) {
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return 1;
        } else if (N == 2) {
            return 1;
        } else {
            return fromBottom(N, 1, 1, 3);
        }
    }

    public int fromBottom(int N, int N1, int N2, int current) {
        if (current < N) {
            return fromBottom(N, N2, N1 + N2, ++current);
        } else {
            return N1 + N2;
        }
    }

    /**
     * 三刷斐波那契数
     * 带dp数组
     *
     * @param n
     * @return
     */
    public int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode509斐波那契数().fib2(4));
    }
}
