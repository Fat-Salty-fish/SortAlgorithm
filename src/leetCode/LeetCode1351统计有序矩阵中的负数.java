package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/14
 */
public class LeetCode1351统计有序矩阵中的负数 {

    /**
     * 这个题暴力解法可以解决 但是更好的办法是用二分搜索 查询每一行中的第一个负数的位置 时间复杂度会变成nlogn
     *
     * @param grid
     * @return
     */
    public int countNegatives(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * 二分搜索
     *
     * @param grid
     * @return
     */
    public int countNegatives2(int[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            int negativeIndex = findFirstNegativeNum(grid[i]);
            if (negativeIndex == -1){
                continue;
            }
            num+= grid[0].length-negativeIndex;
        }
        return num;
    }

    /**
     * 查询数组中第一个负数的index
     * 数组是递减的 所以大于0的数都在左边 小于0的数都在右边
     *
     * @param array
     * @return
     */
    public int findFirstNegativeNum(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] >= 0) {
                left = mid + 1;
            } else {
                if (mid - 1 < 0 || array[mid - 1] >= 0) {
                    return mid - 1;
                }
                right = mid - 1;
            }
        }
        return -1;
    }

}
