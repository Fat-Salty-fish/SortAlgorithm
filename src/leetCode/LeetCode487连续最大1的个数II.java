package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/17
 */
public class LeetCode487连续最大1的个数II {

    /**
     * 动态规划 特训
     * 比较难的点在于有一个0可以反转为1 需要知道这个反转机会是否已经被使用
     * 还有个点在于 知道当前数字是0或1 如何判断能否与前一个数字连接起来？
     * 定义dp[i][j] 表示以i-1为结尾时 dp[i][0]表示机会未被使用
     * dp[i][1]表示机会已经被使用
     * 如果nums[i]为0 则dp[i][0] 直接等于0 因为dp[i][j]用来表示nums[i]为1时最长的字符
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0] == 1 ? 1 : 0;
        // 这里 无论nums[0]是否为1 都可以是1
        dp[0][1] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = dp[i - 1][1] + 1;
            } else {
                dp[i][0] = 0;
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
        }
        return max;
    }
}
