package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/29
 */
public class LeetCode329矩阵中的最长递增路径 {

    /**
     * 方向键 上下左右
     */
    public int dir[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int matrixRowNum = 0;

    public int matrixColNum = 0;

    /**
     * 动态规划特训
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        matrixRowNum = matrix.length;
        matrixColNum = matrix[0].length;
        // pathDp[i][j] 表示matrix[i][j]为首的节点的最长递增路径是多少
        int[][] pathDp = new int[matrixRowNum][matrixColNum];
        int result = 0;
        for (int i = 0; i < matrixRowNum; i++) {
            for (int j = 0; j < matrixColNum; j++) {
                result = Math.max(result, dfs(i,j,matrix,pathDp));
            }
        }
        return result;
    }

    /**
     * @param x
     * @param y
     * @param matrix
     * @return
     */
    public int dfs(int x, int y, int[][] matrix, int[][] pathDp) {
        if (pathDp[x][y] != 0) {
            return pathDp[x][y];
        }
        pathDp[x][y]++;
        for (int[] currentDir : dir) {
            int newX = x + currentDir[0];
            int newY = y + currentDir[1];
            if (newX >= 0 && newX < matrixRowNum && newY >= 0 && newY < matrixColNum && matrix[newX][newY] > matrix[x][y]) {
                pathDp[x][y] = Math.max(pathDp[x][y], dfs(newX, newY, matrix, pathDp) + 1);
            }
        }
        return pathDp[x][y];
    }
}
