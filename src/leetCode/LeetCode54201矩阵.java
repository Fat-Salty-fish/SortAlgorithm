package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode54201矩阵 {

    private static int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * BFS
     * 从0的点位开始遍历
     *
     * @param mat
     * @return
     */
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> queue = new LinkedList<>();
        int length = mat.length;
        int width = mat[0].length;
        int[][] res = new int[length][width];
        boolean[][] visited = new boolean[length][width];
        int numToBeChanged = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    res[i][j] = 0;
                } else {
                    numToBeChanged++;
                }
            }
        }
        int step = 1;
        while (!queue.isEmpty()) {
            if (numToBeChanged == 0) {
                break;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currentNode = queue.poll();
                int x = currentNode[0];
                int y = currentNode[1];
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX >= 0 && newX < length && newY >= 0 && newY < width && !visited[newX][newY]) {
                        res[newX][newY] = step;
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
            step++;
        }
        return res;
    }
}
