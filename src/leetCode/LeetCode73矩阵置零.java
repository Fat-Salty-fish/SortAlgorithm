package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode73矩阵置零 {

    /**
     * 如果一个元素是0 那么将整个行和整个列都置为0
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        Set<Integer> rowNeedToSet = new HashSet<>();
        Set<Integer> colNeedToSet = new HashSet<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rowNeedToSet.add(i);
                    colNeedToSet.add(j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rowNeedToSet.contains(i) || colNeedToSet.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
