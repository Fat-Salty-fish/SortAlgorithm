package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/6/23
 */
public class LeetCode63不同路径II {
    /**
     * 和不同路径1类似 但是遇到墙时 当前空格的路径数应该变为0
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        result[0][0] = 1;
        for (int i = 1; i < m; i++) {
            result[i][0] = obstacleGrid[i][0] == 1 ? 0 : result[i-1][0];
        }
        for (int j = 1; j < n; j++) {
            result[0][j] = obstacleGrid[0][j] == 1 ? 0 : result[0][j-1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = obstacleGrid[i][j] == 1 ? 0 : result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }
}
