package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/7
 */
public class LCP28采购方案 {


    int mod = 1000000007;

    /**
     * 微软模拟面试
     *
     * @param nums
     * @param target
     * @return
     */
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int numLength = nums.length;
        int result = 0;
        int left = 0;
        int right = numLength - 1;
        while (left < right) {
            // 如果数比较大 说明right需要缩小了
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] <= target) {
                // 此时 left+[left,right]之间的任意数都可以
                result = result + (right - left);
                result %= mod;
                left++;
            }
        }
        return result;
    }
}
