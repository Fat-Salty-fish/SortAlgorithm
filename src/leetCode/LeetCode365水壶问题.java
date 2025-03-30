package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode365水壶问题 {

    public static class Pair {

        public int x;

        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 这题能想到用BFS也是摊上了
     *
     * @param x
     * @param y
     * @param target
     * @return
     */
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) {
            return false;
        }
        boolean[][] visited = new boolean[x + 1][y + 1];
        Pair pair = new Pair(0, 0);
        visited[0][0] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(pair);
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int currentX = p.x;
            int currentY = p.y;
            // 可以对currentX 和 currentY进行的所有操作，无非就是把x倒掉，或者把x加满，或者把y倒掉，或者把y加满
            if (!visited[x][currentY]){
                if (x + currentY == target){
                    return true;
                }
                Pair temp = new Pair(x, currentY);
                queue.offer(temp);
                visited[x][currentY] = true;
            }
            if (!visited[currentX][y]){
                if (currentX + y == target){
                    return true;
                }
                Pair temp = new Pair(currentX, y);
                queue.offer(temp);
                visited[currentX][y] = true;
            }
            if (!visited[0][currentY]){
                if (currentY == target){
                    return true;
                }
                Pair temp = new Pair(0, y);
                queue.offer(temp);
                visited[0][currentY] = true;
            }
            if (!visited[currentX][0]){
                if (currentX == target){
                    return true;
                }
                Pair temp = new Pair(currentX, 0);
                queue.offer(temp);
                visited[currentX][0] = true;
            }
            // 把 x 倒进 y 下面的场景下就不可能满足
            int tempSum = currentX + currentY;
            if (tempSum >= y){
                int tempX = tempSum - y;
                if (!visited[tempX][y]){
                    Pair temp = new Pair(tempX, y);
                    queue.offer(temp);
                    visited[tempX][y] = true;
                }
            }else {
                if (!visited[0][tempSum]){
                    Pair temp = new Pair(0, tempSum);
                    queue.offer(temp);
                    visited[0][tempSum] = true;
                }
            }
            // 把 y 倒进 x里
            if (tempSum >= x){
                int tempY = tempSum - x;
                if (!visited[x][tempY]){
                    Pair temp = new Pair(x, tempY);
                    queue.offer(temp);
                    visited[x][tempY] = true;
                }
            }else {
                if (!visited[tempSum][0]){
                    Pair temp = new Pair(tempSum, 0);
                    queue.offer(temp);
                    visited[tempSum][0] = true;
                }
            }
        }
        return false;
    }
}
