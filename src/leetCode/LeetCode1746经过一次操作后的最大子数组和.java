package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/17
 */
public class LeetCode1746经过一次操作后的最大子数组和 {

    /**
     * 动态规划特训
     *
     * @param nums
     * @return
     */
    public int maxSumAfterOperation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return Math.max(nums[0],nums[0] * nums[0]);
        }
        // 以i为结尾的子数组的和 dp[i][0]表示没有使用转换 dp[i][1]表示已经使用了转换
        int[][] dp = new int[nums.length][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0] * nums[0];
        int maxValue = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(nums[i], dp[i - 1][0] + nums[i]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][0] + nums[i] * nums[i], dp[i - 1][1] + nums[i]), nums[i] * nums[i]);
            maxValue = Math.max(Math.max(dp[i][0],dp[i][1]),maxValue);
        }
        return maxValue;
    }
}
