package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/27
 */
public class LeetCode36有效的数独 {


    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        // 第i行的9位数字
        int[][] rowNum = new int[n][10];
        // 第j列第9位数字
        int[][] colNum = new int[n][10];
        // 方块矩阵
        int[][][] boxNum = new int[3][3][10];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int currentNum = board[i][j] - '0';
                if (rowNum[i][currentNum]++ == 1) {
                    return false;
                }
                if (colNum[j][currentNum]++ == 1) {
                    return false;
                }
                if (boxNum[i / 3][j / 3][currentNum]++ == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
