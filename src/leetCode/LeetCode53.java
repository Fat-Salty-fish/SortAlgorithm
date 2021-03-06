package leetCode;

/**
 * @author acer
 * @Date 2019/7/24 21:48
 */
public class LeetCode53 {
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
        for(int num:nums){
            if(result > 0){
                result += num;
            }else {
                result = num;
            }
            ans = Math.max(result,ans);
        }
        return ans;
    }
}
