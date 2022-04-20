package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/5
 */
public class AimToOffer42连续子数组的最大和 {

    /**
     * 连续子数组的最大和
     * dp
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], i == 0 ? Integer.MIN_VALUE : (dp[i - 1] + nums[i]));
            result = Math.max(result,dp[i]);
        }
        return result;
    }
}
