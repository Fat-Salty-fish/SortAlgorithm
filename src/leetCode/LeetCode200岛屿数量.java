package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode200岛屿数量 {

    public int result = 0;

    public int length;

    public int width;

    /**
     * 尝试dfs
     * 遍历所有的数 如果遇到1 则dfs这个数旁边的四个数 并将旁边的数都置为1
     * YUDAO YU
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        length = grid.length;
        width = grid[0].length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    /**
     * 深度优先搜索整个数组
     * 向四个方向遍历 把相邻为1的数变为0
     *
     * @param grid
     * @param x
     * @param y
     */
    public void dfs(char[][] grid, int x, int y) {
        if (x < 0 || x >= length || y < 0 || y >= width) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
        }
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);
    }
}
