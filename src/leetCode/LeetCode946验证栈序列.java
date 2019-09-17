package leetCode;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/4 23:24
 */
public class LeetCode946验证栈序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pointer = 0;
        for (int i = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[pointer]) {
                stack.pop();
                pointer++;
            }
        }
        return stack.isEmpty();
    }
}
