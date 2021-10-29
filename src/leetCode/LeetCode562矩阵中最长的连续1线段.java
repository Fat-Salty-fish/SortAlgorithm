package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/26
 */
public class LeetCode562矩阵中最长的连续1线段 {

    /**
     * 动态规划特训
     * 连续1线段 可以由左上角 右上角 左 右 得来
     * 定义dp[i][j] 表示以dp[i][j]的1为结尾时 最长的连续1线段
     *
     * @param mat
     * @return
     */
    public int longestLine(int[][] mat) {
        int rowNum = mat.length;
        int columnNum = mat[0].length;
        int[][] leftDp = new int[rowNum][columnNum];
        int[][] upDp = new int[rowNum][columnNum];
        int[][] leftUpDp = new int[rowNum][columnNum];
        int[][] rightUpDp = new int[rowNum][columnNum];
        int result = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < columnNum; j++) {
                if (mat[i][j] == 0) {
                    leftDp[i][j] = 0;
                    upDp[i][j] = 0;
                    leftUpDp[i][j] = 0;
                    rightUpDp[i][j] = 0;
                } else {
                    leftDp[i][j] = j > 0 ? leftDp[i][j - 1] + 1 : 1;
                    upDp[i][j] = i > 0 ? upDp[i - 1][j] + 1 : 1;
                    leftUpDp[i][j] = i > 0 && j > 0 ? leftUpDp[i - 1][j - 1] + 1 : 1;
                    rightUpDp[i][j] = i > 0 && j < columnNum - 1 ? rightUpDp[i - 1][j + 1] + 1 : 1;
                    result = Math.max(result, Math.max(Math.max(leftDp[i][j], upDp[i][j]), Math.max(leftUpDp[i][j], rightUpDp[i][j])));
                }
            }
        }
        return result;
    }
}
