package leetCode;

import com.sun.org.apache.xpath.internal.operations.Bool;
import sortFunctions.HeapSort;
import sun.plugin.liveconnect.OriginNotAllowedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        while (i < n) {
            //当前高度小于栈顶高度 压栈 栈顶到栈底是递增的 说明有积水
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i++);
                //当前高度高于栈顶高度 说明要计算积水了
            } else {
                //弹出栈顶元素为坑
                int t = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                //当前元素为右边界
                //此时的栈顶元素为左边界
                ans += ((Math.min(height[i], height[stack.peek()]) - height[t]) * (i - stack.peek() - 1));
            }
        }
        return ans;
    }

    /**
     * 重做42
     * 按行求 先求第1行 再求第2行
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0;
        boolean over = Boolean.FALSE;
        int level = 1;
        int left = 0;
        int right = 0;
        int heightest = Arrays.stream(height).max().getAsInt();
        while (level <= heightest) {
            while (left < height.length && right < height.length) {
                while (height[left] < level && left < height.length) {
                    left++;
                }
                while (height[right] < level && right < height.length) {
                    right++;
                }
                if (left < height.length && right < height.length) {
                    res += right - left - 1;
                    left++;
                    right++;
                }
            }
            level++;
        }
        return res;
    }


    /**
     * 重做42
     * 按列求 找到当前列的左边最高的列和右边最高的列 然后即可求出当前列的储水量
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;
            for (int j = i - 1; j >= 0; j--) {
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int m = i + 1; m < height.length; m++) {
                rightMax = Math.max(rightMax, height[m]);
            }
            int min = Math.min(leftMax, rightMax);
            if (height[i] < min) {
                res += min - height[i];
            }
        }
        return res;
    }

    /**
     * 重做42 动态规划
     * leftMax[i] 表示第i列左边最高的
     * rightMax[i] 表示第i列右边最高的
     *
     * @param height
     * @return
     */
    public int trap4(int[] height) {
        int res = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }
        for (int j = height.length - 2; j >= 0; j--) {
            rightMax[j] = Math.max(rightMax[j + 1], height[j + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            if (min > height[i]) {
                res += min - height[i];
            }
        }
        return res;
    }

    /**
     * 重做42 左右指针
     * 优化动态规划
     *
     * @param height
     * @return
     */
    public int trap5(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 1;
        int right = height.length - 2;
        for (int i = 1; i < height.length - 1; i++) {
            if (height[left - 1] < height[right + 1]) {
                leftMax = Math.max(leftMax, height[left - 1]);
                int min = leftMax;
                if (min > height[left]) {
                    res += min - height[left];
                }
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right + 1]);
                int min = rightMax;
                if (min > height[right]) {
                    res += min - height[right];
                }
                right--;
            }
        }
        return res;
    }

    /**
     * 继续左右指针
     *
     * @param height
     * @return
     */
    public int trap6(int[] height) {
        int res = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            if (height[left] < height[right]) {
                if (leftMax > height[left]) {
                    res += leftMax - height[left];
                }
                leftMax = Math.max(height[left], leftMax);
                left++;
            } else {
                if (rightMax > height[right]) {
                    res += rightMax - height[right];
                }
                rightMax = Math.max(height[right], rightMax);
                right--;
            }
        }
        return res;
    }

}
