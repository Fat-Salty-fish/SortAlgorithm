package leetCode;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/4 16:28
 */
public class LeetCode1124表现良好的最长时间段 {
    public int longestWPI(int[] hours) {
        //明确结果： 是为了获取一个区间的 这个区间是保证努力工作的最大长度 也就是 努力工作的时间比不努力工作的时间在这个区间内是严格大于的
        int[] one = new int[hours.length];
        //转换为 在这个区间内1是比-1大的 或者在这个区间内的和是严格大于0的
        for (int i = 0; i < hours.length; i++) {
            one[i] = hours[i] > 8 ? 1 : -1;
        }
        //用前缀和来表示
        int[] preArray = new int[hours.length + 1];
        //获取前缀序列 继续转换问题为 在前缀和序列中寻找i和j j-i最大 同时前缀和[j] - 前缀和[j] > 0
        //先获取前缀和数组
        preArray[0] = 0;
        for (int i = 1; i < preArray.length; i++) {
            preArray[i] = preArray[i - 1] + one[i - 1];
        }
        //维护一个单调栈 转换问题为求preArray中最长的一个上坡
        //栈中的元素单调递减
        //这一步是为了找到
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < preArray.length; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (preArray[i] < preArray[stack.peek()]) {
                    stack.push(i);
                }
            }
        }
        int ans = 0;
        //从后往前遍历数组 如果和栈顶元素相减为负 则表明这一段是负 无法作为结果
        for (int i = preArray.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && preArray[stack.peek()] < preArray[i]) {
                ans = ans > i - stack.peek() ? ans : i - stack.peek();
                stack.pop();
            }
        }

        return ans;
    }
}
