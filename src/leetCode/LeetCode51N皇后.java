package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/6
 */
public class LeetCode51N皇后 {

    /**
     * 第j行是否有皇后
     */
    boolean[] colHave;

    /**
     * 结果数组
     */
    List<List<String>> result = new ArrayList<>();

    /**
     * 棋盘大小
     */
    int size;

    /**
     * 斜向有没有 从左下角开始 到右上角的 从左到右的斜线
     */
    boolean[] leftToRightDiagonalHave;

    /**
     * 斜向有没有 从右下角开始 到左上角的 从右到左的斜线
     */
    boolean[] rightToLeftDiagonalHave;

    /**
     * N皇后 经典DFS题目
     * 有n个皇后 说明棋盘就是n*n大小的棋盘
     * 皇后之间不能相互攻击 即同一行 同一列 斜向都没有其他皇后
     *
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        if (n == 1){
            result.add(Arrays.asList("Q"));
            return result;
        }
        size = n;
        colHave = new boolean[n + 1];
        leftToRightDiagonalHave = new boolean[n * 2];
        rightToLeftDiagonalHave = new boolean[n * 2];
        dfs(0, new ArrayList<>());
        return result;
    }

    /**
     * dfs
     *
     * @param row
     * @param path
     */
    public void dfs(int row, List<String> path) {
        // 如何判断已经放置完成了？path.size == 4即可
        if (path.size() == size) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < size; i++) {
            int leftToRight = i - row + size - 1;
            int rightToLeft = row + i;
            if (!colHave[i] && !leftToRightDiagonalHave[leftToRight] && !rightToLeftDiagonalHave[rightToLeft]) {
                StringBuilder current = new StringBuilder();
                for (int j = 1; j <= size; j++) {
                    if (j == i + 1) {
                        current.append("Q");
                    } else {
                        current.append(".");
                    }
                }
                path.add(current.toString());
                colHave[i] = true;
                leftToRightDiagonalHave[leftToRight] = true;
                rightToLeftDiagonalHave[rightToLeft] = true;
                dfs(row + 1, path);
                path.remove(path.size() - 1);
                colHave[i] = false;
                leftToRightDiagonalHave[leftToRight] = false;
                rightToLeftDiagonalHave[rightToLeft] = false;
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<String>> result = new LeetCode51N皇后().solveNQueens(n);
        System.out.println("结束了" + result.size());
    }
}
