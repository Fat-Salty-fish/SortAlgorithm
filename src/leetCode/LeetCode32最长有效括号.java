package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/21
 */
public class LeetCode32最长有效括号 {

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int max = 0;
        // 以s[i]为结尾的字符串的最长有效括号
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                continue;
            }
            if (s.charAt(i - 1) == '(') {
                dp[i] = (i == 1 ? 0 : dp[i - 2]) + 2;
            } else if (s.charAt(i - 1) == ')' && i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                // 这种情况下如何确定前面有左括号可以匹配呢？ 必须要再加判断
                dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * 用栈模拟解决
     *
     * @param s
     * @return
     */
    public int longestValidParenthesesWithStack(String s) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '(') {
                deque.push(i);
            } else {
                deque.pop();
                if (deque.isEmpty()) {
                    deque.push(i);
                } else {
                    result = Math.max(result, i - deque.peek());
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a = ")()())";
        int result = new LeetCode32最长有效括号().longestValidParentheses(a);
        System.out.println(result);
    }
}
