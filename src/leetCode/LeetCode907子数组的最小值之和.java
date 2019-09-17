package leetCode;

import sun.print.PeekGraphics;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/4 23:43
 */
public class LeetCode907子数组的最小值之和 {
    class pair {
        int val;
        int count;

        pair(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }

    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        Stack<pair> stack = new Stack<>();
        int length = A.length;
        int ans = 0;
        int dot = 0;
        //维护一个递减栈
        for (int j = 0; j < length; j++) {
            int count = 1;
            while (!stack.isEmpty() && stack.peek().val >= A[j]) {
                pair node = stack.pop();
                count += node.count;
                dot -= node.val * node.count;
            }
            stack.push(new pair(A[j], count));
            dot += A[j] * count;
            ans += dot;
            ans %= MOD;
        }
        return ans;
    }
}
