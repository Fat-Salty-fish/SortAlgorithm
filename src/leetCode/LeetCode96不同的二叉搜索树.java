package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/10/29
 */
public class LeetCode96不同的二叉搜索树 {

    /**
     * 如何使用动态规划解决？
     * 状态定义 n 节点数量
     * 状态转移方程？
     * 思路 假设有n个节点时 需要遍历(1,n)作为i 假设i为树根 则(1,i-1)组成的树为左子树 (i+1,n)作为右子树
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int current = 1; current <= i; current++) {
                int left = current - 1;
                int right = i - current;
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}
