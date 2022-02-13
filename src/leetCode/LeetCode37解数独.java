package leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/5
 */
public class LeetCode37解数独 {
    /**
     * 每一行内 还可以使用的数字
     */
    Set[] rowNums;

    /**
     * 每一列内 还可以使用的数字
     */
    Set[] colNums;

    /**
     * 每一个小方块内 还可以使用的数字
     */
    Set[][] areaNums;

    /**
     * 是否已经符合条件
     */
    boolean valid = false;

    /**
     * 行数
     */
    int rowNum;

    /**
     * 列数
     */
    int colNum;

    /**
     * 解数独
     * 感觉是dfs
     *
     * @param board
     */
    public void solveSudoku(char[][] board) {
        rowNum = board.length;
        colNum = board[0].length;
        rowNums = new Set[rowNum];
        colNums = new Set[colNum];
        areaNums = new Set[rowNum / 3][colNum / 3];
        // 初始化visited
        for (int i = 0; i < rowNum; i++) {
            rowNums[i] = new HashSet<Integer>();
            for (int j = 0; j < colNum; j++) {
                if (colNums[j] == null) {
                    colNums[j] = new HashSet<Integer>();
                }
                if (areaNums[i / 3][j / 3] == null) {
                    areaNums[i / 3][j / 3] = new HashSet<Integer>();
                }
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    rowNums[i].add(num);
                    colNums[j].add(num);
                    areaNums[i / 3][j / 3].add(num);
                }
            }
        }
        dfs(0, 0, board);
    }

    public void dfs(int x, int y, char[][] board) {
        // 这里需要判断是否已经符合了条件
        if (x == rowNum) {
            valid = true;
            return;
        }
        // 下一个要处理的数字
        int nextRow = y == rowNum - 1 ? x + 1 : x;
        int nextCol = y == rowNum - 1 ? 0 : y + 1;
        if (board[x][y] != '.') {
            dfs(nextRow, nextCol, board);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (!rowNums[x].contains(i) && !colNums[y].contains(i) && !areaNums[x / 3][y / 3].contains(i)) {
                rowNums[x].add(i);
                colNums[y].add(i);
                areaNums[x / 3][y / 3].add(i);
                board[x][y] = (char) ('0' + i);
                dfs(nextRow, nextCol, board);
                // 如果在遍历完成后已经符合条件了 就可以停止了
                if (valid) {
                    return;
                }
                // 需要再设置回去
                rowNums[x].remove(i);
                colNums[y].remove(i);
                areaNums[x / 3][y / 3].remove(i);
                board[x][y] = '.';
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new LeetCode37解数独().solveSudoku(board);
        System.out.println(board[0][0]);

        int a = 0;
        int b = 1;
    }
}
