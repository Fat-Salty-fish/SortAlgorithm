package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode994腐烂的橘子 {

    private static int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * 多源BFS
     *
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int goodOranges = 0;
        int steps = 0;
        int goodOrangesChanged = 0;
        int length = grid.length;
        int width = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    goodOranges++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // 不需要变化
        if (goodOranges == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean shouldAdd = false;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int newX = current[0] + direction[0];
                    int newY = current[1] + direction[1];
                    if (newX >= 0 && newX < length && newY >= 0 && newY < width && !visited[newX][newY]) {
                        if (grid[newX][newY] == 1) {
                            shouldAdd = true;
                            grid[newX][newY] = 2;
                            queue.offer(new int[]{newX, newY});
                            goodOrangesChanged++;
                        }
                    }
                }
            }
            if (shouldAdd){
                steps++;
            }
        }

        if (goodOrangesChanged != goodOranges) {
            return -1;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(new LeetCode994腐烂的橘子().orangesRotting(array));
    }
}
