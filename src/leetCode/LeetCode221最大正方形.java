package leetCode;

public class LeetCode221最大正方形 {

    public int maximalSquare(char[][] matrix) {
        int result = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int temp = check(matrix, i, j);
                result = Math.max(result, temp);
            }
        }
        return result;
    }


    public int check(char[][] matrix, int x, int y) {
        if (matrix[x][y] == '0') {
            return 0;
        }
        //System.out.println("x:" + x + " y:" + y);
        int maxLength = Math.min(matrix.length - x, matrix[0].length - y);
        int result = 1;
        for (int i = 2; i <= maxLength; i++) {
            for (int startX = x; startX <= x + i - 1; startX++) {
                for (int startY = y; startY <= y + i - 1; startY++) {
                    if (matrix[startX][startY] == '0') {
                        return result * result;
                    }
                }
            }
            result = i;
        }
        return result * result;
    }

    /**
     * 动态规划
     *
     * @param matrix
     * @return
     */
    public int maximalSquare2(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        int result = new LeetCode221最大正方形().maximalSquare2(matrix);
        System.out.println(result);
    }
}
