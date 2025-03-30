package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/1
 */
public class LeetCode279完全平方数 {

    /**
     * 动态规划特训
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        // 遍历从1-i的平方根的所有数
        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                min = Math.min(min, dp[i - j * j]);
            }
            // 加1是因为选中了一个当前元素
            dp[i] = min + 1;
        }
        return dp[n];
    }

    /**
     * 二刷
     * 抽象成BFS
     * 一个疑问：如何知道小于n的所有完全平方数？
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {
        int result = 0;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visited[n] = true;
        // 最大的完全平方数的因子
        int maxNumber = (int) Math.sqrt(n);
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            result++;
            for (int j = 0; j < currentSize; j++) {
                int current = queue.poll();
                for (int i = 1; i <= maxNumber; i++) {
                    int temp = current - i * i;
                    if (temp == 0) {
                        return result;
                    } else if (temp > 0 && !visited[temp]) {
                        queue.offer(temp);
                        visited[temp] = true;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 12;
        int result = new LeetCode279完全平方数().numSquares(n);
    }
}
