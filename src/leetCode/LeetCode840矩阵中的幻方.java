package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/14
 */
public class LeetCode840矩阵中的幻方 {

    /**
     * 前缀和尝试
     * 不用前缀和 直接暴力求解
     * @param grid
     * @return
     */
    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        // 遍历grid 寻找符合条件的
        for (int i = 0; i <= grid.length - 3; i++) {
            for (int j = 0; j <= grid[0].length - 3; j++) {
                if (grid[i + 1][j + 1] != 5) {
                    continue;
                }
                if (check(grid, i, j)) {
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 检查是否符合条件
     *
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public boolean check(int[][] grid, int x, int y) {
        Set<Integer> have = new HashSet<>();
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                if (grid[i][j] >= 10 || grid[i][j] <= 0 || have.contains(grid[i][j])){
                    return false;
                }
                have.add(grid[i][j]);
            }
        }
        int firstRow = grid[x][y] + grid[x][y + 1] + grid[x][y + 2];
        int secondRow = grid[x + 1][y] + grid[x + 1][y + 1] + grid[x + 1][y + 2];
        int thirdRow = grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2];
        int firstCol = grid[x][y] + grid[x + 1][y] + grid[x + 2][y];
        int secondCol = grid[x][y + 1] + grid[x + 1][y + 1] + grid[x + 2][y + 1];
        int thirdCol = grid[x][y + 2] + grid[x + 1][y + 2] + grid[x + 2][y + 2];
        int leftToRightCorner = grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2];
        int rightToLeftCorner = grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y];
        return firstRow == 15 && secondRow == 15 && thirdRow == 15 && firstCol == 15 && secondCol == 15 && thirdCol == 15 && leftToRightCorner == 15 && rightToLeftCorner == 15;
    }
}
