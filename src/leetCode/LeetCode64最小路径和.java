package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/6/21
 */
public class LeetCode64最小路径和 {

    /**
     * 最小路径和 动态规划
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        // 用来记录 停留在i,j时 最小路径和是多少
        int[][] minPathMap = new int[grid.length][grid[0].length];
        // 从左上角走到右下角 只能向右和向下行进 不会向左和向上行进 所以每走一步只有两种情况
        // 从左往右遍历 从上往下遍历
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 取上一个空格 和左一个空格 如果是墙则不能参与比较
                if (i == 0 && j == 0) {
                    minPathMap[0][0] = grid[0][0];
                    continue;
                }
                int up = i > 0 ? minPathMap[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? minPathMap[i][j - 1] : Integer.MAX_VALUE;
                int min = Math.min(up, left);
                minPathMap[i][j] = min + grid[i][j];
            }
        }
        return minPathMap[grid.length - 1][grid[0].length - 1];
    }


    /**
     * 动态规划特训
     * 最小路径和
     *
     * @param grid
     * @return
     */
    public int minPathSum2(int[][] grid) {
        // 行数
        int rowNum = grid.length;
        // 列数
        int columnNum = grid[0].length;
        int[][] dp = new int[rowNum + 1][columnNum + 1];
        for (int i = 1; i <= rowNum; i++) {
            for (int j = 1; j <= columnNum; j++) {
                if (i == 1 && j == 1) {
                    dp[i][j] = grid[0][0];
                    continue;
                }
                // 从上往下 如果遇到墙 则不能选择 变成Integer.MaxValue即可
                int up = i == 1 ? Integer.MAX_VALUE : dp[i - 1][j];
                // 从左往右
                int left = j == 1 ? Integer.MAX_VALUE : dp[i][j - 1];
                dp[i][j] = Math.min(up, left) + grid[i - 1][j - 1];
            }
        }
        return dp[rowNum][columnNum];
    }

    /**
     * 三刷
     *
     * @param grid
     * @return
     */
    public int minPathSum3(int[][] grid) {
        int rowNum = grid.length;
        int columnNum = grid[0].length;
        int[][] dp = new int[rowNum][columnNum];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < rowNum; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < columnNum; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < rowNum; i++) {
            for (int j = 1; j < columnNum; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[rowNum - 1][columnNum - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int result = new LeetCode64最小路径和().minPathSum2(grid);
        System.out.println(result);
    }
}
