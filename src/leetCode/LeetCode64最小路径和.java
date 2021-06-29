package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/6/21
 */
public class LeetCode64最小路径和 {

    /**
     * 最小路径和 动态规划
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
                if (i == 0 && j == 0){
                    minPathMap[0][0] = grid[0][0];
                    continue;
                }
                int up = i > 0 ? minPathMap[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? minPathMap[i][j - 1] : Integer.MAX_VALUE;
                int min = Math.min(up,left);
                minPathMap[i][j] = min + grid[i][j];
            }
        }
        return minPathMap[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        new LeetCode64最小路径和().minPathSum(grid);
    }
}
