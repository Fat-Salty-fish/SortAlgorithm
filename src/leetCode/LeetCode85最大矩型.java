package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/22
 */
public class LeetCode85最大矩型 {

    /**
     * 因为数字只包含0和1 所以感觉可以使用二维矩阵前缀和解决
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int result = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int[] cols = new int[col];
            for (int j = i; j < row; j++) {
                int dp = 0;
                for (int k = 0; k < col; k++) {
                    cols[k] += matrix[j][k] == '1' ? 1 : 0;
                    if (cols[k] == j - i + 1) {
                        dp += cols[k];
                    } else {
                        result = Math.max(result, dp);
                        dp = 0;
                    }
                }
                result = Math.max(result, dp);
            }
        }
        return result;
    }

    /**
     * 单调栈解决
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle2(char[][] matrix) {
        int result = 0;
        int[] array = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[j] = matrix[i][j] == '0' ? 0 : (array[j] + 1);
            }
            result = Math.max(result, findMaxArea(array));
        }
        return result;
    }

    /**
     * 从数组中寻找最大矩型
     * 方法：使用单调栈
     * 可以从左到右遍历一次和从右到左遍历一次 也可以从左到右只遍历一次
     * 本次采用遍历一次的办法
     * 以当前位置的高度为高度 向左向右遍历 找到第一个比当前数小的位置
     *
     * @param array
     * @return
     */
    public int findMaxArea(int[] array) {
        int result = 0;
        // 单调递减栈 栈顶元素为最大
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];
            while (!deque.isEmpty() && array[deque.peek()] > currentNum) {
                int currentIndex = deque.poll();
                int currentHeight = array[currentIndex];
                int leftIndex = (deque.isEmpty() ? -1 : deque.peek()) + 1;
                int rightIndex = i - 1;
                result = Math.max(result, currentHeight * (rightIndex - leftIndex + 1));
            }
            deque.push(i);
        }
        // 这种办法在处理完之后 deque里会有存留元素 需要都清理完 清理时 右边的元素都为-1（即右边没有低于/大于当前元素的值)
        while (!deque.isEmpty()) {
            int currentIndex = deque.poll();
            int currentHeight = array[currentIndex];
            int leftIndex = (deque.isEmpty() ? -1 : deque.peek()) + 1;
            int rightIndex = array.length - 1;
            result = Math.max(result, currentHeight * (rightIndex - leftIndex + 1));
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int result = new LeetCode85最大矩型().maximalRectangle2(matrix);
        System.out.println(result);
    }
}
