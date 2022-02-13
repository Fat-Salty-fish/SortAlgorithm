package interviewGuide;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/25
 */
public class InterviewGuide101单调栈结构 {

    /**
     * 获得数组左边和右边离当前位置最近的最小元素
     * 递减栈
     * 原数组没有重复元素
     * 最简单：n的平方 解决
     * 优化时间复杂度：单调栈
     * 如果需要返回的是位置 则stack里记录位置即可
     * 可以优化：单次遍历实现
     * @param nums
     * @return
     */
    public int[][] getLeftAndRightMinNum(int[] nums) {
        int[][] result = new int[nums.length][2];
        Deque<Integer> deque = new ArrayDeque<>();
        // 递减栈
        // 从左到右
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() > nums[i]) {
                deque.pop();
            }
            result[i][0] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(nums[i]);
        }
        deque = new ArrayDeque<>();
        // 从右到左
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && deque.peek() > nums[i]) {
                deque.pop();
            }
            result[i][1] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(nums[i]);
        }
        return result;
    }

}
