package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/17
 */
public class LeetCode152乘积最大子数组 {


    /**
     * 动态规划特训
     * 定义dp[i]
     * 表示以i为结尾的子数组的最大乘积
     * 状态转移
     * dp[i] = Math.max(nums[i],dp[i-1]*nums[i])
     *
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dpMax = new int[nums.length];
        dpMax[0] = nums[0];
        int[] dpMin = new int[nums.length];
        dpMin[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i],nums[i]),dpMin[i-1] * nums[i]);
            dpMin[i] = Math.min(Math.min(dpMax[i-1] * nums[i],nums[i]),dpMin[i-1] * nums[i]);
        }
        int result = Integer.MIN_VALUE;
        for (int i = 0;i<nums.length;i++){
            result = Math.max(result,dpMax[i]);
        }
        return result;
    }
}
