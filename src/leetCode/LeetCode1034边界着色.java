package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/7
 */
public class LeetCode1034边界着色 {

    public static class Point {
        public int x;

        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int targetColor = grid[row][col];
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        boolean[][] targetToChange = new boolean[rows][cols];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(row, col));
        visited[row][col] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int x = point.x;
            int y = point.y;
            boolean isBorder = false;
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) {
                    isBorder = true;
                }
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    if (grid[newX][newY] != targetColor) {
                        isBorder = true;
                    } else if (!visited[newX][newY] && grid[newX][newY] == targetColor) {
                        queue.offer(new Point(newX, newY));
                        visited[newX][newY] = true;
                    }
                }
            }
            if (isBorder) {
                targetToChange[x][y] = true;
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (targetToChange[i][j]) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }
}
