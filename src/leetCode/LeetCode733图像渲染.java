package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author acer
 * @Date 2019/7/28 18:38
 */
public class LeetCode733图像渲染 {
    private class Node {
        int sr;
        int sc;

        public Node(int sr, int sc) {
            this.sr = sr;
            this.sc = sc;
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int newColor) {
        //用于储存要修改的像素
        List<Node> list = new ArrayList<>();
        int nowColor = image[sr][sc];
        if (sr != 0 && image[sr - 1][sc] == nowColor && image[sr - 1][sc] != newColor)
            list.add(new Node(sr - 1, sc));
        if (sc != 0 && image[sr][sc - 1] == nowColor && image[sr][sc - 1] != newColor) {
            list.add(new Node(sr, sc - 1));
        }
        if (sr != image.length - 1 && image[sr + 1][sc] == nowColor && image[sr + 1][sc] != newColor) {
            list.add(new Node(sr + 1, sc));
        }
        if (sc != image[0].length - 1 && image[sr][sc + 1] == nowColor && image[sr][sc + 1] != newColor) {
            list.add(new Node(sr, sc + 1));
        }
        image[sr][sc] = newColor;
        for (int i = 0; i < list.size(); i++) {
            fill(image, list.get(i).sr, list.get(i).sc, newColor);
        }
    }


    public int originalColor;

    public int targetColor;

    public int row;

    public int col;

    /**
     * 二刷
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    public int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        originalColor = image[sr][sc];
        targetColor = newColor;
        // 如果原来的颜色和目标要修改的颜色相同 则直接返回即可 不需要任何修改
        if (originalColor == newColor) {
            return image;
        }
        row = image.length;
        col = image[0].length;
        dfs(image, sr, sc);
        return image;
    }


    public void dfs(int[][] image, int x, int y) {
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (image[x][y] == originalColor) {
            image[x][y] = -1;
            dfs(image, x + 1, y);
            dfs(image, x - 1, y);
            dfs(image, x, y - 1);
            dfs(image, x, y + 1);
            image[x][y] = targetColor;
        }
    }


    /**
     * 点类
     */
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 三刷
     * bfs
     *
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill3(int[][] image, int sr, int sc, int color) {
        int currentColor = image[sr][sc];
        int rows = image.length;
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(sr, sc);
        queue.offer(point);
        visited[sr][sc] = true;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            int currentX = currentPoint.x;
            int currentY = currentPoint.y;
            for(int[] direction: dirs){
                int newX = currentX + direction[0];
                int newY = currentY + direction[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols && image[newX][newY] == currentColor && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new Point(newX, newY));
                }
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j]) {
                    image[i][j] = color;
                }
            }
        }
        return image;
    }


    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        System.out.println(new LeetCode733图像渲染().floodFill(array, sr, sc, newColor));
    }
}
