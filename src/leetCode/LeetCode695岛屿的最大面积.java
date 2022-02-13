package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/13
 */
public class LeetCode695岛屿的最大面积 {

    /**
     * 行数
     */
    int rowNum;

    /**
     * 列数
     */
    int colNum;

    /**
     * dfs
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        rowNum = grid.length;
        colNum = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                ans = Math.max(ans, dfs(grid,i,j));
            }
        }
        return ans;
    }

    /**
     * dfs
     *
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public int dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) {
            return 0;
        }
        int tempAns = 1;
        grid[x][y] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            if (nextX >= 0 && nextX < rowNum && nextY >= 0 && nextY < colNum && grid[nextX][nextY] == 1) {
                tempAns += dfs(grid, nextX, nextY);
            }
        }
        return tempAns;
    }
}
