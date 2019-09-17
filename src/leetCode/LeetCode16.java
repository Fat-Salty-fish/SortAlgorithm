package leetCode;

import org.omg.CORBA.MARSHAL;

import java.util.Arrays;

/**
 * @author acer
 * @Date 2019/7/30 23:03
 */
public class LeetCode16 {
    //三数之和
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        //先对数组进行排序
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[n - 1];
        for (int i = 0; i < n - 2; i++) {
            //用来去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //双指针法
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if( sum == target)
                    return target;
                if (Math.abs((sum - target)) < Math.abs(ans - target))
                    ans = sum;
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 2, 1, -3};
        int target = 1;
        new LeetCode16().threeSumClosest(array, target);
    }
}
