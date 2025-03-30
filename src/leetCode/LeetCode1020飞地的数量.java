package leetCode;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode1020飞地的数量 {

    public static class Point {

        public int a;

        public int y;

        public Point(int a, int y) {
            this.a = a;
            this.y = y;
        }

    }

    // 四个方向
    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    /**
     * BFS
     *
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Deque<Point> deque = new LinkedList<>();
        // 从上下左右四个边开始向内DFS，处理所有靠边的网格即可
        // 上边 和 下边
        for (int i = 0; i < cols; i++) {
            bfs(0, i, grid, rows, cols);
            bfs(rows - 1, i, grid, rows, cols);
        }
        // 左边 和 右边
        for (int i = 1; i < rows; i++) {
            bfs(i, 0, grid, rows, cols);
            bfs(i, cols - 1, grid, rows, cols);
        }

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }


    /**
     * 从[x,y]点开始bfs，将可以遇到的1都变为0即可
     *
     * @param x
     * @param y
     * @param grid
     * @param rows
     * @param cols
     */
    private void bfs(int x, int y, int[][] grid, int rows, int cols) {
        if (grid[x][y] == 0) return;
        Deque<Point> deque = new LinkedList<>();
        Point first = new Point(x, y);
        deque.offer(first);
        grid[x][y] = 0;
        while (!deque.isEmpty()) {
            Point cur = deque.poll();
            for (int[] direction : directions) {
                int newX = cur.a + direction[0];
                int newY = cur.y + direction[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && grid[newX][newY] == 1) {
                    Point newPoint = new Point(newX, newY);
                    deque.offer(newPoint);
                    grid[newX][newY] = 0;
                }
            }
        }
    }
}
