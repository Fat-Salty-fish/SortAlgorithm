package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/14
 */
public class LeetCode198打家劫舍 {

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            // 第i家选择: nums[i-1] + dp[i-2]
            // 第i家不选择: dp[i-1]
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }

    /**
     * 空间优化
     * 动态规划时 只和dp[i-1]和dp[i-2]有关
     *
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int firstNum = 0;
        int secondNum = nums[0];
        int currentNum = secondNum;
        for (int i = 2; i <= nums.length; i++) {
            currentNum = Math.max(secondNum, firstNum + nums[i - 1]);
            firstNum = secondNum;
            secondNum = currentNum;
        }
        return currentNum;
    }
}
