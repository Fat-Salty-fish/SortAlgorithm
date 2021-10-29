package leetCode;

import com.sun.xml.internal.xsom.impl.util.SchemaTreeTraverser;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/5
 */
public class LeetCode931下降路径最小和 {

    /**
     * 动态规划特训
     *
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length==1){
            return matrix[0][0];
        }
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            dp[0][j] = matrix[0][j];
        }
        // 值之和上一行有关 可以降低空间复杂度
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                } else if (j == matrix[0].length-1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }else {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0;i<matrix.length;i++){
            result = Math.min(result,dp[matrix.length-1][i]);
        }
        return result;
    }
}
