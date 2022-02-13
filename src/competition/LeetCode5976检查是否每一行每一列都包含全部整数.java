package competition;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/9
 */
public class LeetCode5976检查是否每一行每一列都包含全部整数 {

    /**
     * 边长
     */
    int n;

    /**
     * 每一行有哪些数
     */
    Set[] rowNums;

    /**
     * 每一列有哪些数
     */
    Set[] colNums;

    public boolean checkValid(int[][] matrix) {
        n = matrix.length;
        rowNums = new Set[n];
        colNums = new Set[n];
        for (int i = 0; i < n; i++) {
            rowNums[i] = new HashSet();
            colNums[i] = new HashSet();
        }
        return dfs(matrix, 0, 0);
    }

    public boolean dfs(int[][] matrix, int x, int y) {
        if (x >= n || y >= n) {
            return true;
        }
        int nextX = y == n - 1 ? x + 1 : x;
        int nextY = y == n - 1 ? 0 : y + 1;
        if (rowNums[x].contains(matrix[x][y]) || colNums[y].contains(matrix[x][y])) {
            return false;
        }
        rowNums[x].add(matrix[x][y]);
        colNums[y].add(matrix[x][y]);
        return dfs(matrix, nextX, nextY);
    }
}
