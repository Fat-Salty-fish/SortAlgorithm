package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/19
 */
public class LeetCode918环形子数组的最大和 {

    /**
     * 子数组最大和加了一个环形
     *
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        int min = nums[0];
        int dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp = Math.max(nums[i], dp + nums[i]);
            max = Math.max(max, dp);
        }
        dp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.min(nums[i], dp + nums[i]);
            min = Math.min(dp, min);
        }
        return sum - min == 0 ? max : Math.max(max, sum - min);
    }

    public static void main(String[] args) {
        int[] nums = {-3, -2, -3};
        int result = new LeetCode918环形子数组的最大和().maxSubarraySumCircular(nums);
        System.out.println(result);
    }
}
