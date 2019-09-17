package leetCode;

import sun.security.util.Length;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * @author acer
 * @Date 2019/8/26 23:12
 */
public class LeetCode91 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put(String.valueOf(i + 1), (char) ('A' + i));
        }
        return caculate(map, s, 0);
    }

    public int caculate(Map map, String s, int position) {
        if (position == s.length()) {
            return 1;
        }
        if (s.charAt(position) == '0') {
            return 0;
        }

        int a = caculate(map, s, position + 1);
        int b = 0;
        if (position < s.length() - 1) {
            int ten = (s.charAt(position) - '0') * 10;
            int one = (s.charAt(position + 1) - '0');
            if (ten + one <= 26) {
                b = caculate(map, s, position + 2);
            }
        }
        return a + b;
    }

    public int dp1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int[] dp = new int[s.length() + 1];
        dp[length] = 1;
        if (s.charAt(length - 1) != '0') {
            dp[length - 1] = 1;
        } else {
            dp[length - 1] = 0;
        }

        for (int i = length - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            int sub = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
            if (sub <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public int dp2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();

        int dp1 = 1;

        int dp2 = 0;

        if (s.charAt(length - 1) != '0') {
            dp2 = 1;
        }

        for (int i = length - 2; i >= 0; i--) {
            //当前字符为 0
            if (s.charAt(i) == '0') {
                //只移动指针
                dp1 = dp2;

                dp2 = 0;

                continue;
            }
            //当前字符与下一个字符可以组成一个字母
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                int temp = dp1;

                dp1 = dp2;

                dp2 = temp+dp2;

                //当前字符只能单独组成一个字母
            } else {

                dp1 = dp2;

            }
        }
        return dp2;
    }


    public static void main(String[] args) {
        System.out.println(new LeetCode91().dp2("226"));
    }
}
