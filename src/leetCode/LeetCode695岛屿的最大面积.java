package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/13
 */
public class LeetCode695岛屿的最大面积 {

    /**
     * 行数
     */
    int rowNum;

    /**
     * 列数
     */
    int colNum;

    /**
     * dfs
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        rowNum = grid.length;
        colNum = grid[0].length;
        int ans = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    /**
     * dfs
     *
     * @param grid
     * @param x
     * @param y
     * @return
     */
    public int dfs(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) {
            return 0;
        }
        int tempAns = 1;
        grid[x][y] = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < dirs.length; i++) {
            int nextX = x + dirs[i][0];
            int nextY = y + dirs[i][1];
            if (nextX >= 0 && nextX < rowNum && nextY >= 0 && nextY < colNum && grid[nextX][nextY] == 1) {
                tempAns += dfs(grid, nextX, nextY);
            }
        }
        return tempAns;
    }

    /**
     * 之前用dfs 现在用bfs
     *
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int rowNum = grid.length;
        int colNum = grid[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        int result = 0;
        for (int i = 0; i < rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                result = Math.max(result, bfs(i, j, grid, visited, rowNum, colNum));
            }
        }
        return result;
    }

    /**
     * bfs
     * 检查这个位置并且向四周验证
     *
     * @param x
     * @param y
     * @param grid
     * @param visited
     * @return
     */
    public int bfs(int x, int y, int[][] grid, boolean[][] visited, int rowNum, int colNum) {
        if (visited[x][y] || grid[x][y] == 0) {
            return 0;
        }
        Queue<PointTuple<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new PointTuple<>(x, y));
        visited[x][y] = true;
        int result = 1;
        while (!queue.isEmpty()) {
            PointTuple<Integer, Integer> current = queue.poll();
            int currentX = current.first;
            int currentY = current.second;
            if (currentX - 1 >= 0 && !visited[currentX - 1][currentY] && grid[currentX - 1][currentY] == 1) {
                queue.offer(new PointTuple<>(currentX - 1, currentY));
                visited[currentX - 1][currentY] = true;
                result += 1;
            }
            if (currentX + 1 < rowNum && !visited[currentX + 1][currentY] && grid[currentX + 1][currentY] == 1) {
                queue.offer(new PointTuple<>(currentX + 1, currentY));
                visited[currentX + 1][currentY] = true;
                result += 1;
            }
            if (currentY - 1 >= 0 && !visited[currentX][currentY - 1] && grid[currentX][currentY - 1] == 1) {
                queue.offer(new PointTuple<>(currentX, currentY - 1));
                visited[currentX][currentY - 1] = true;
                result += 1;
            }
            if (currentY + 1 < colNum && !visited[currentX][currentY + 1] && grid[currentX][currentY + 1] == 1) {
                queue.offer(new PointTuple<>(currentX, currentY + 1));
                visited[currentX][currentY + 1] = true;
                result += 1;
            }
        }
        return result;
    }

    public static class PointTuple<A, B> {
        public final A first;

        public final B second;

        public PointTuple(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}};
        int result = 0;
        result = new LeetCode695岛屿的最大面积().maxAreaOfIsland2(grid);
        System.out.println(result);
    }
}
