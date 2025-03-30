package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1162地图分析 {


    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * BFS
     *
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int length = grid.length;
        int width = grid[0].length;
        boolean[][] visited = new boolean[length][width];
        int seas = 0;
        int lands = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});
                    lands++;
                } else {
                    seas++;
                }
            }
        }
        if (seas == 0 || lands == 0) {
            return -1;
        }
        int step = 0;
        while (!queue.isEmpty()) {
            if (seas == 0) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX >= 0 && newX < length && newY >= 0 && newY < width && !visited[newX][newY]) {
                        grid[newX][newY] = step;
                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY});
                        seas--;
                    }
                }
            }
            step++;
        }
        return step;
    }
}
