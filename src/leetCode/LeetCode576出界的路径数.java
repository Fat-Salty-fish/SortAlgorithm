package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/29
 */
public class LeetCode576出界的路径数 {

    /**
     * 对此数求余数
     */
    public int mod = 1000000007;

    /**
     * 行数
     */
    public int row;

    /**
     * 列数
     */
    public int col;

    /**
     * 记忆化
     * -1表示未计算过此处
     */
    public int[][][] mem;

    public int maxMove;

    /**
     * 动态规划特训
     *
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        row = m;
        col = n;
        mem = new int[row][col][maxMove + 1];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                Arrays.fill(mem[i][j], -1);
            }
        }
        return dfs(startRow, startColumn, maxMove);
    }

    /**
     * dfs处理
     *
     * @param currentRow
     * @param currentCol
     * @param leftMove
     * @return
     */
    public int dfs(int currentRow, int currentCol, int leftMove) {
        if (mem[currentRow][currentCol][leftMove] != -1) {
            return mem[currentRow][currentCol][leftMove];
        }
        // 当前没有步数时 没办法出去格子里了 返回0
        if (leftMove == 0) {
            mem[currentRow][currentCol][leftMove] = 0;
            return 0;
        }
        int step = 0;
        // 上下左右处理 如果处于边界 则直接加一
        // 上
        if (currentRow - 1 < 0) {
            step += 1;
        } else {
            step += dfs(currentRow - 1, currentCol, leftMove - 1);
        }
        step %= mod;
        // 下
        if (currentRow + 1 >= row) {
            step += 1;
        } else {
            step += dfs(currentRow + 1, currentCol, leftMove - 1);
        }
        step %= mod;
        // 左
        if (currentCol - 1 < 0) {
            step += 1;
        } else {
            step += dfs(currentRow, currentCol - 1, leftMove - 1);
        }
        step %= mod;
        // 右
        if (currentCol + 1 >= col) {
            step += 1;
        } else {
            step += dfs(currentRow, currentCol + 1, leftMove - 1);
        }
        step %= mod;
        mem[currentRow][currentCol][leftMove] = step;
        return step;
    }


    /**
     * 方向
     */
    public int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


    /**
     * 动态规划 优化dfs为dp
     * 从下到上处理
     *
     * @param m
     * @param n
     * @param maxMove
     * @param startRow
     * @param startColumn
     * @return
     */
    public int findPaths2(int m, int n, int maxMove, int startRow, int startColumn) {
        row = m;
        col = n;
        if (maxMove == 0) {
            return 0;
        }
        int[][][] dp = new int[row][col][maxMove + 1];
        for (int i = 0; i < row; i++) {
            dp[i][0][1] += 1;
            dp[i][col - 1][1] += 1;
        }
        for (int i = 0; i < col; i++) {
            dp[0][i][1] += 1;
            dp[row - 1][i][1] += 1;
        }
        for (int k = 2; k <= maxMove; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int step = 0;
                    for (int[] direction : directions) {
                        int currentRow = i + direction[0];
                        int currentCol = j + direction[1];
                        if (currentRow >= 0 && currentRow < row && currentCol >= 0 && currentCol < col) {
                            step += dp[currentRow][currentCol][k - 1];
                        } else {
                            step += 1;
                        }
                        step %= mod;
                    }
                    dp[i][j][k] = step;
                }
            }
        }
        return dp[startRow][startColumn][maxMove];
    }

    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int maxMove = 0;
        int startRow = 5;
        int startCol = 5;
        int result = new LeetCode576出界的路径数().findPaths2(m, n, maxMove, startRow, startCol);
        System.out.println("结果为" + result);
    }
}
