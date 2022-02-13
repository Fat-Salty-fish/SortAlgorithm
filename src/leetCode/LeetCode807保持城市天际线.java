package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/14
 */
public class LeetCode807保持城市天际线 {

    /**
     * 只需要记录每一行和每一列的最大值即可 然后每一个方块最大值等于这一行和这一列的最大值的最小值即可
     * @param grid
     * @return
     */
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] rowsMax = new int[grid.length];
        int[] colsMax = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                rowsMax[i] = Math.max(rowsMax[i], grid[i][j]);
                colsMax[j] = Math.max(colsMax[j], grid[i][j]);
            }
        }
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result += Math.min(rowsMax[i], colsMax[j]) - grid[i][j];
            }
        }
        return result;
    }
}
