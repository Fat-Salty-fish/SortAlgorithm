package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/5
 */
public class LeetCode1289下降路径最小和II {

    /**
     * 动态规划特训
     *
     * @param grid
     * @return
     */
    public int minFallingPathSum(int[][] grid) {
        int rowNum = grid.length;
        int columnNum = grid[0].length;
        int[][] dp = new int[rowNum][columnNum];
        for (int i = 0; i < columnNum; i++) {
            dp[0][i] = grid[0][i];
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                int currentIndexNum = grid[i][j];
                dp[i][j] = Integer.MAX_VALUE;
                for (int m = 0; m < columnNum; m++) {
                    if (m == j) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][m] + currentIndexNum);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < columnNum; i++) {
            result = Math.min(result, dp[rowNum - 1][i]);
        }
        return result;
    }
}
