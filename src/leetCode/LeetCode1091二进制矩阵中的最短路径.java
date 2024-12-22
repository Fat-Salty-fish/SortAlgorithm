package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1091二进制矩阵中的最短路径 {

    /**
     * 最短路径就是BFS
     * 需要用一个二维数组来记录某个节点是否已经被访问过了
     * 同时，可以维护一个二维数组，来记录从左上角节点到当前节点的最短路径
     *
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0][0] == 1) {
            return -1;
        }
        int length = grid.length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][] shortestPath = new int[grid.length][grid[0].length];
        shortestPath[0][0] = 1;

        Queue<PointTuple<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new PointTuple<>(0, 0));
        visited[0][0] = true;
        while (!queue.isEmpty()) {
            PointTuple<Integer, Integer> currentPoint = queue.poll();
            if (currentPoint.a == length - 1 && currentPoint.b == length - 1) {
                return shortestPath[currentPoint.a][currentPoint.b];
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    int x = i + currentPoint.a;
                    int y = j + currentPoint.b;
                    if (x >= 0 && y >= 0 && x < length && y < length && !visited[x][y] && grid[x][y] == 0) {
                        queue.offer(new PointTuple<>(x, y));
                        visited[x][y] = true;
                        shortestPath[x][y] = shortestPath[currentPoint.a][currentPoint.b] + 1;
                    }
                }
            }
        }
        return shortestPath[grid.length - 1][grid[0].length - 1] == 0 ? -1 : shortestPath[grid.length - 1][grid[0].length - 1];
    }


    public static class PointTuple<A, B> {
        public A a;

        public B b;

        public PointTuple(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        int result = new LeetCode1091二进制矩阵中的最短路径().shortestPathBinaryMatrix(grid);
        System.out.println(result);
    }
}

