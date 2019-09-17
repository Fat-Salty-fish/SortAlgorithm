package leetCode;

import sortFunctions.HeapSort;

import java.util.Stack;

/**
 * @author acer
 * @Date 2019/9/4 19:13
 */
public class LeetCode42接雨水 {
    public int trap(int[] height) {
        int ans = 0;
        int i = 0;
        int n = height.length;
        //维护一个单调递增栈
        Stack<Integer> stack = new Stack<>();
        while (i<n){
            //当前高度小于栈顶高度 压栈 栈顶到栈底是递增的 说明有积水
            if(stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i++);
                //当前高度高于栈顶高度 说明要计算积水了
            }else {
                //弹出栈顶元素为坑
                int t = stack.pop();
                if(stack.isEmpty()) {
                    continue;
                }
                //当前元素为右边界
                //此时的栈顶元素为左边界
                ans += ((Math.min(height[i],height[stack.peek()]) - height[t]) * (i - stack.peek() - 1));
            }
        }
        return ans;
    }
}
