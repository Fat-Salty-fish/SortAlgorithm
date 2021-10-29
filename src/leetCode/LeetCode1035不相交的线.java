package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/20
 */
public class LeetCode1035不相交的线 {

    /**
     * 动态规划特训
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return 0;
        }
        // 定义dp 表示nums1前i位和nums2前j位下 没有相交的线有dp[i][j]条
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // base case i 或 j为0时 无法生成线 所以dp值在i==1或者j==1时均为0
        // 不需要初始化
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                // 如果nums[i] == nums[j] 则起码可以连成一条线
                // 如何判断新连成的线与原来的线是否相交？
                // 其实就是最长公共子序列
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
