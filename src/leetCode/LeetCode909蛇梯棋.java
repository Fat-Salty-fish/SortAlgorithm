package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode909蛇梯棋 {

    public static class Point {
        int x;
        int y;
        int pointNum;

        int n;

        public Point(int num, int n) {
            this.pointNum = num;
            this.n = n;
            convert();
        }

        // 转换方向
        // 把num-1会好计算一些嘛？
        public void convert() {
            int convertedNum = pointNum - 1;
            int rows = convertedNum / n;
            int cols = convertedNum % n;
            // 方向 false是从左往右，true是从右往左
            boolean direction = rows % 2 == 0;
            x = n - rows - 1;
            y = direction ? cols : n - cols - 1;
        }
    }


    /**
     * BFS，但是什么情况下走不到终点呢？
     *
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        int min = Math.min(6, target);
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.offer(new Point(1, n));
        visited[n - 1][0] = true;
        while (!queue.isEmpty()) {
            int num = queue.size();
            result++;
            for (int i = 0; i < num; i++) {
                Point point = queue.poll();
                for (int j = 1; j <= min; j++) {
                    Point temp = new Point(point.pointNum + j, n);
                    //System.out.println("Number: " + temp.pointNum + " X: " + temp.x + " Y: " + temp.y);
                    if (temp.pointNum == target) {
                        return result;
                    }
                    int tempValue = board[temp.x][temp.y];
                    if (tempValue == -1) {
                        if (!visited[temp.x][temp.y]){
                            queue.offer(temp);
                            visited[temp.x][temp.y] = true;
                        }
                    } else {
                        if (tempValue == target) {
                            return result;
                        }
                        Point nextPoint = new Point(tempValue, n);
                        if (!visited[nextPoint.x][nextPoint.y]) {
                            queue.offer(nextPoint);
                            visited[nextPoint.x][nextPoint.y] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
        int result = new LeetCode909蛇梯棋().snakesAndLadders(nums);
        System.out.println(result);
    }
}
