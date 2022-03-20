package codingInterview;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/12
 */
public class CodingInterview1009排序矩阵查找 {

    /**
     * 不用二分查找
     * 从右上角或者左下角开始查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int row = 0;
        int col = matrix[0].length-1;
        boolean find = false;
        while (row < matrix.length && col >= 0){
            if (matrix[row][col] == target){
                find = true;
                break;
            }else if (matrix[row][col] < target){
                row++;
            }else if (matrix[row][col] > target){
                col--;
            }
        }
        return find;
    }
}
