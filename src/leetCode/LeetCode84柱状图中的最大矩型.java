package leetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/22
 */
public class LeetCode84柱状图中的最大矩型 {

    /**
     * 遍历每一个高度 计算以当前高度为高度时的最大面积是多少
     * 确定了高度后需要确定宽度 所以就需要向左右遍历枚举宽度
     * 向左向又遍历找到第一个比当前高度严格小的高度 之间围住的就是符合条件的宽度
     * 如何找到比当前高度小的第一个元素？ 用单调栈
     * 并用一个数组进行记录
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Deque<Integer> leftToRight = new ArrayDeque<>();
        Deque<Integer> rightToLeft = new ArrayDeque<>();
        int[] leftToRightArray = new int[heights.length];
        int[] rightToLeftArray = new int[heights.length];
        // 从左到右遍历时 形成的是单调递增栈 那么在遍历到当前高度时向左看 就是一个递减栈
        for (int i = 0; i < heights.length; i++) {
            while (!leftToRight.isEmpty() && heights[i] <= heights[leftToRight.peek()]) {
                leftToRight.pop();
            }
            if (leftToRight.isEmpty()) {
                leftToRightArray[i] = -1;
            } else {
                leftToRightArray[i] = leftToRight.peek();
            }
            leftToRight.push(i);
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            while (!rightToLeft.isEmpty() && heights[i] <= heights[rightToLeft.peek()]) {
                rightToLeft.pop();
            }
            if (rightToLeft.isEmpty()) {
                rightToLeftArray[i] = heights.length;
            } else {
                rightToLeftArray[i] = rightToLeft.peek();
            }
            rightToLeft.push(i);
        }
        for (int i = 0; i < heights.length; i++) {
            int size = heights[i] * (rightToLeftArray[i] - leftToRightArray[i] - 1);
            result = Math.max(size, result);
        }
        return result;
    }

    /**
     * 一次遍历单调栈
     * 对于单调增栈 遍历到height[i] 如果当前元素比栈顶元素大 则直接push
     * 否则 弹出栈顶元素 并且 弹出的栈顶元素 向后找的第一个小于它的数 就是height[i]
     * 弹出的栈顶元素 向前找的第一个小于它的数 就是当前栈顶元素
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int result = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> heightList = new ArrayList<>();
        for (int a : heights) {
            heightList.add(a);
        }
        // 为了强制在序列本身就递增的时候计算
        heightList.add(0);
        Integer[] array = heightList.toArray(new Integer[heightList.size()]);
        for (int i = 0; i < array.length; i++) {
            while (!deque.isEmpty() && array[i] < array[deque.peek()]) {
                int currentHeight = array[deque.pop()];
                int currentWidth = deque.isEmpty() ? i : i - deque.peek() - 1;
                result = Math.max(result, currentHeight * currentWidth);
            }
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 1};
        int result = new LeetCode84柱状图中的最大矩型().largestRectangleArea(array);
        System.out.println(result);
    }
}
