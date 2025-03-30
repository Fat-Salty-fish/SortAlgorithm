package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1306跳跃游戏III {


    /**
     * BFS
     *
     * @param arr
     * @param start
     * @return
     */
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            // 当前位置
            int current = queue.poll();
            if (arr[current] == 0) {
                return true;
            }
            int nextPlus = current + arr[current];
            int nextMinus = current - arr[current];
            if (nextPlus < arr.length && !visited[nextPlus]) {
                if (arr[nextPlus] == 0) {
                    return true;
                }
                queue.offer(nextPlus);
                visited[nextPlus] = true;
            }
            if (nextMinus >= 0 && !visited[nextMinus]) {
                if (arr[nextMinus] == 0) {
                    return true;
                }
                queue.offer(nextMinus);
                visited[nextMinus] = true;
            }
        }
        return false;
    }
}
