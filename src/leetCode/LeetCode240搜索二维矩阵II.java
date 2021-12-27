package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/5
 */
public class LeetCode240搜索二维矩阵II {

    /**
     * 搜索二维矩阵II
     * 矩阵从左到右 从上到下 元素增序排序
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;

        for (int i = 0; i < rowNum; i++) {
            // 再在此行中进行寻找
            int left = 0;
            int right = colNum - 1;
            while (left <= right) {
                int colMid = left + (right - left) / 2;
                if (matrix[i][colMid] == target) {
                    return true;
                } else if (matrix[i][colMid] < target) {
                    left = colMid + 1;
                } else if (matrix[i][colMid] > target) {
                    right = colMid - 1;
                }
            }
        }
        return false;
    }

    /**
     * Z字形遍历 从右上角开始遍历 向左下角遍历
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        int row = 0;
        int col = colNum - 1;
        while (row < rowNum && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                // 当前行的所有元素都小于target 舍弃此行
                row++;
            } else if (matrix[row][col] > target) {
                // 当前列的所有元素都大于target 舍弃此列
                col--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        boolean result = new LeetCode240搜索二维矩阵II().searchMatrix(matrix, target);
        System.out.println("结果为" + result);
    }
}
