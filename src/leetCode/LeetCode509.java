package leetCode;

import java.util.Currency;
import java.util.regex.Pattern;

/**
 * @author acer
 * @Date 2019/8/24 13:57
 */
public class LeetCode509 {
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

    public static void main(String[] args) {
        System.out.println(new LeetCode509().fib2(4));
    }
}
