package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/4 16:15
 */
public class LeetCode739每日温度 {
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return ans;
    }

    /**
     * 二刷
     * 寻找下一个比当前值更大的数 单调栈 单调递增
     *
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            // 因为是递增栈 所以如果当前元素值大于等于栈顶元素时 栈顶元素就需要pop
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if (stack.isEmpty()){
                result[i] = 0;
            }else {
                result[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return result;
    }
}
