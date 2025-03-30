package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1254统计封闭岛屿的数目 {

    public static class Point {

        public int x;

        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static boolean[][] visited;

    /**
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && visited[i][j] == false) {
                    result += bfs(grid, i, j, row, col);
                }
            }
        }

        return result;
    }


    public int bfs(int[][] grid, int x, int y, int rows, int cols) {
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(x, y);
        queue.offer(point);
        visited[x][y] = true;
        boolean eligible = true;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int currX = point.x;
            int currY = point.y;
            for (int[] d : directions) {
                int newX = currX + d[0];
                int newY = currY + d[1];
                if (newX < 0 || newX >= rows || newY < 0 || newY >= cols) {
                    eligible = false;
                }
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && !visited[newX][newY] && grid[newX][newY] == 0) {
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        return eligible ? 1 : 0;
    }
}
