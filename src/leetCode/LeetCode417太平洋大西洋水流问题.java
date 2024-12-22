package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode417太平洋大西洋水流问题 {


    boolean[][] eligibleToAtlantic;
    boolean[][] visitedToAtlantic;

    boolean[][] eligibleToPacific;
    boolean[][] visitedToPacific;

    int length;

    int height;

    /**
     * bfs？还可以用一个二维数组来维护可以流向两个大洋的位置
     * 正向搜索：从每一个点检查可否到太平洋和大西洋
     * 反向搜索：从边缘向每个点进发 显然更容易进行计算
     *
     * @param heights
     * @return
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }
        length = heights.length;
        height = heights[0].length;
        eligibleToAtlantic = new boolean[length][height];
        eligibleToPacific = new boolean[length][height];

        visitedToAtlantic = new boolean[length][height];
        visitedToPacific = new boolean[length][height];

        List<List<Integer>> result = new ArrayList<>();
        // 第一行
        for (int i = 0; i < height; i++) {
            bfsForPacific(heights, 0, i);
        }
        // 第一列
        for (int i = 0; i < length; i++) {
            bfsForPacific(heights, i, 0);
        }
        // 最后一行
        for (int i = 0; i < height; i++) {
            bfsForAtlantic(heights, length - 1, i);
        }
        // 最后一列
        for (int i = 0; i < length; i++) {
            bfsForAtlantic(heights, i, height - 1);
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < height; j++) {
                if (eligibleToAtlantic[i][j] && eligibleToPacific[i][j]) {
                    List<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    result.add(point);
                }
            }
        }

        return result;
    }


    public void bfsForPacific(int[][] heights, int x, int y) {
        Queue<Point<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Point<>(x, y));
        visitedToPacific[x][y] = true;
        eligibleToPacific[x][y] = true;
        while (!queue.isEmpty()) {
            Point<Integer, Integer> current = queue.poll();
            int currentX = current.a;
            int currentY = current.b;
            if (currentX + 1 < length && heights[currentX + 1][currentY] >= heights[currentX][currentY] && !visitedToPacific[currentX + 1][currentY]) {
                visitedToPacific[currentX + 1][currentY] = true;
                eligibleToPacific[currentX + 1][currentY] = true;
                queue.offer(new Point<>(currentX + 1, currentY));
            }
            if (currentY + 1 < height && heights[currentX][currentY + 1] >= heights[currentX][currentY] && !visitedToPacific[currentX][currentY + 1]) {
                visitedToPacific[currentX][currentY + 1] = true;
                eligibleToPacific[currentX][currentY + 1] = true;
                queue.offer(new Point<>(currentX, currentY + 1));
            }
            if (currentX - 1 >= 0 && heights[currentX - 1][currentY] >= heights[currentX][currentY] && !visitedToPacific[currentX - 1][currentY]) {
                visitedToPacific[currentX - 1][currentY] = true;
                eligibleToPacific[currentX - 1][currentY] = true;
                queue.offer(new Point<>(currentX - 1, currentY));
            }
            if (currentY - 1 >= 0 && heights[currentX][currentY - 1] >= heights[currentX][currentY] && !visitedToPacific[currentX][currentY - 1]) {
                visitedToPacific[currentX][currentY - 1] = true;
                eligibleToPacific[currentX][currentY - 1] = true;
                queue.offer(new Point<>(currentX, currentY - 1));
            }
        }
    }

    public void bfsForAtlantic(int[][] heights, int x, int y) {
        Queue<Point<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Point<>(x, y));
        visitedToAtlantic[x][y] = true;
        eligibleToAtlantic[x][y] = true;
        while (!queue.isEmpty()) {
            Point<Integer, Integer> current = queue.poll();
            int currentX = current.a;
            int currentY = current.b;
            if (currentX + 1 < length && heights[currentX + 1][currentY] >= heights[currentX][currentY] && !visitedToAtlantic[currentX + 1][currentY]) {
                visitedToAtlantic[currentX + 1][currentY] = true;
                eligibleToAtlantic[currentX + 1][currentY] = true;
                queue.offer(new Point<>(currentX + 1, currentY));
            }
            if (currentY + 1 < height && heights[currentX][currentY + 1] >= heights[currentX][currentY] && !visitedToAtlantic[currentX][currentY + 1]) {
                visitedToAtlantic[currentX][currentY + 1] = true;
                eligibleToAtlantic[currentX][currentY + 1] = true;
                queue.offer(new Point<>(currentX, currentY + 1));
            }
            if (currentX - 1 >= 0 && heights[currentX - 1][currentY] >= heights[currentX][currentY] && !visitedToAtlantic[currentX - 1][currentY]) {
                visitedToAtlantic[currentX - 1][currentY] = true;
                eligibleToAtlantic[currentX - 1][currentY] = true;
                queue.offer(new Point<>(currentX - 1, currentY));
            }
            if (currentY - 1 >= 0 && heights[currentX][currentY - 1] >= heights[currentX][currentY] && !visitedToAtlantic[currentX][currentY - 1]) {
                visitedToAtlantic[currentX][currentY - 1] = true;
                eligibleToAtlantic[currentX][currentY - 1] = true;
                queue.offer(new Point<>(currentX, currentY - 1));
            }
        }
    }


    public static class Point<A, B> {
        public A a;

        public B b;

        public Point(A a, B b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        List<List<Integer>> result = new LeetCode417太平洋大西洋水流问题().pacificAtlantic(heights);
        System.out.println(result.size());
    }
}
