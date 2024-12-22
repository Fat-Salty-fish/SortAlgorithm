package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode130被围绕的区域 {

    static class Point<A, B> {

        public A a;

        public B b;

        public Point(A a, B b) {
            this.a = a;
            this.b = b;
        }

    }

    public boolean[][] NotSurrounded;


    /**
     * BFS
     * 从边上的点开始遍历，这些点以及连接的点不是被surround的，其余的，都是surrounded
     *
     * @param board
     */
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        NotSurrounded = new boolean[board.length][board[0].length];
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                NotSurrounded[i][j] = false;
            }
        }

        // 第一行处理
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O' && !NotSurrounded[0][i]) {
                bfs(board, rows, cols, 0, i);
            }
        }

        // 最后一行处理
        for (int i = 0; i < cols; i++) {
            if (board[rows - 1][i] == 'O' && !NotSurrounded[rows - 1][i]) {
                bfs(board, rows, cols, rows - 1, i);
            }
        }

        // 第一列处理
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][0] == 'O' && !NotSurrounded[i][0]) {
                bfs(board, rows, cols, i, 0);
            }
        }

        // 最后一列处理
        for (int i = 1; i < rows - 1; i++) {
            if (board[i][cols - 1] == 'O' && !NotSurrounded[i][cols - 1]) {
                bfs(board, rows, cols, i, cols - 1);
            }
        }

        for (int i = 0 ; i< rows ; i++) {
            for (int j = 0 ; j< cols ; j++) {
                if (!NotSurrounded[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }


    public void bfs(char[][] board, int rowNum, int colNum, int x, int y) {
        Deque<Point<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Point<>(x, y));
        NotSurrounded[x][y] = true;
        while (!queue.isEmpty()) {
            Point<Integer, Integer> point = queue.poll();
            // 上
            if (point.a - 1 >= 0 && board[point.a - 1][point.b] == 'O' && !NotSurrounded[point.a - 1][point.b]) {
                queue.offer(new Point<>(point.a - 1, point.b));
                NotSurrounded[point.a - 1][point.b] = true;
            }

            // 下
            if (point.a + 1 < rowNum && board[point.a + 1][point.b] == 'O' && !NotSurrounded[point.a + 1][point.b]) {
                queue.offer(new Point<>(point.a + 1, point.b));
                NotSurrounded[point.a + 1][point.b] = true;
            }

            // 左
            if (point.b - 1 >= 0 && board[point.a][point.b - 1] == 'O' && !NotSurrounded[point.a][point.b - 1]) {
                queue.offer(new Point<>(point.a, point.b - 1));
                NotSurrounded[point.a][point.b - 1] = true;
            }

            // 右
            if (point.b + 1 < colNum && board[point.a][point.b + 1] == 'O' && !NotSurrounded[point.a][point.b + 1]) {
                queue.offer(new Point<>(point.a, point.b + 1));
                NotSurrounded[point.a][point.b + 1] = true;
            }
        }
    }


}
