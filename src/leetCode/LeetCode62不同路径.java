package leetCode;

/**
 * @author acer
 * @Date 2019/8/11 18:53
 */
public class LeetCode62不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            ans[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            ans[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                ans[i][j] = ans[i - 1][j] + ans[i][j - 1];
            }
        }
        return ans[m - 1][n - 1];
    }


    /**
     * 不同路径 二刷
     * 动态规划
     * 有一个数组来维护 从左上角走到这个点 有多少种方法
     * 如何计数？最左上角的空格应该是0
     * 怎么计算从左上角到 i,j 空格的值呢
     * 结果就是 当前格 只要上边和左边不是墙 那到这个格的路径数量就是上格和左格的和
     * 挨墙的上边和左边 都是1 因为从左上角只能一直向右或者向下
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePath2(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        // 第一行和第一列已经处理完了 直接从1开始 即第二行和第二列
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }

    /**
     * 动态规划特训
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths2(int m, int n) {
        // 定义dp[][] 表示以第(i,j)格为最后一格时 有多少条路径
        int[][] dp = new int[m][n];
        // 第一行和第一列的 都只有一条方法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 只和上一行有关 可以降低空间复杂度
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 三刷不同路径
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePath3(int m, int n) {
        // 定义dp 表示以(i,j)格子为结尾时 有多少种方法可以达到
        // 只能往右或者往下 所以base case 第一行或第一列只有一种方法可以达到
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode62不同路径().uniquePaths(3, 2));
    }


}
