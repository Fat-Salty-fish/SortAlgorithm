package leetCode;

/**
 * @author acer
 * @Date 2019/7/24 21:48
 */
public class LeetCode53最大子序和 {
    //    给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
//    示例:
//
//    输入: [-2,1,-3,4,-1,2,1,-5,4],
//    输出: 6
//    解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//    进阶:
//
//    如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
    public int maxSubArray(int[] nums) {
        int result = 0;
        int ans = nums[0];
        //动态规划
        for (int num : nums) {
            if (result > 0) {
                result += num;
            } else {
                result = num;
            }
            ans = Math.max(result, ans);
        }
        return ans;
    }

    /**
     * 二刷最大子序和
     * 动态规划
     * 拆解问题 以第i个数字为结尾的子串的最大子序和为dp[i]
     * 状态定义 i 即前i位数字
     * 递推公式 f(i) = Math.max(f(i-1)+num[i],num[i])
     * 然后遍历整个dp即可得出最大子序和
     * 可见可以缩减动态规划dp大小
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 缩减状态规模
//        int[] dp = new int[nums.length];
        int dp = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            max = Math.max(max,dp);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = new LeetCode53最大子序和().maxSubArray2(nums);
        System.out.println(result);
    }
}
