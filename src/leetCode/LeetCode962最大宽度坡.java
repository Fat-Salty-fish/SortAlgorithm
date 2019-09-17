package leetCode;

import java.sql.SQLOutput;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/4 18:50
 */
public class LeetCode962最大宽度坡 {
    public int maxWidthRamp(int[] A) {
        //最大宽度的坡 寻找一个i和j 使得i<j并且A[i] < A[j]
        Stack<Integer> stack = new Stack<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]){
                ans = ans > i-stack.peek()? ans:i-stack.peek();
                stack.pop();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode962最大宽度坡().maxWidthRamp(new int[]{9, 8, 1, 0, 1, 9, 4, 0, 4, 1}));
    }
}
