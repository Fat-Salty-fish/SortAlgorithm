package leetCode;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/3 19:28
 */
public class LeetCode503下一个更大元素II {
    public int[] nextGreaterElements(int[] nums) {
        //环状的数组 可以认为是将原来的一个数组复制一次拼接过来
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            //栈顶元素小于当前元素时 弹出 这是递减栈？
            while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                ans[i % nums.length] = -1;
            } else {
                ans[i % nums.length] = stack.peek();
            }
            stack.push(nums[i % nums.length]);
        }
        return ans;
    }

    public static void main(String[] args) {
        new LeetCode503下一个更大元素II().nextGreaterElements(new int[]{1, 2, 1, 3, 1, 4, 5, 3, 5, 7, 3});
    }
}
