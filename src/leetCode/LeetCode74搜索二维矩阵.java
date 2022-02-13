package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/27
 */
public class LeetCode74搜索二维矩阵 {


    /**
     * 类似于二分搜索
     * 可以优化：在行上先进行二分搜索（找到最后一行 行头元素小于target的行） 再对那一行进行二分查找
     * 或者 将每一行的元素拼接成一个数组 再进行二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int up = 0;
        int down = rowNum - 1;
        int finalRow = up;
        // 寻找第一列里 最后一个比target小的数
        while (up <= down) {
            int mid = up + (down - up) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                if (mid + 1 > rowNum - 1 || matrix[mid + 1][0] > target) {
                    finalRow = mid;
                    break;
                }
                up = mid + 1;
            } else if (matrix[mid][0] > target) {
                down = mid - 1;
            }
        }
        int[] rowArray = matrix[finalRow];
        if (exist(rowArray, target)) {
            return true;
        }
        return false;
    }

    public boolean exist(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                return true;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 3};
        int target = 3;
        boolean result = new LeetCode74搜索二维矩阵().exist(array, target);
        System.out.println(result);
    }

}
