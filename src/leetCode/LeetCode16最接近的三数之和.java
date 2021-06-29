package leetCode;

import java.util.Arrays;

/**
 * @author acer
 * @Date 2019/7/30 23:03
 */
public class LeetCode16最接近的三数之和 {
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

    /**
     * 最接近的三数之和 二刷
     * 双指针
     * 注意点：因为涉及到了3个数 所以必须定住一个数字而移动另外两个数字 另外两个构成双指针
     * @param nums    数组
     * @param target 目标值
     * @return
     */
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        // 结果初始值
        int result = nums[0] + nums[1] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (current == target) {
                    return target;
                }
                if (Math.abs(target - result) > Math.abs(target - current)) {
                    result = current;
                }
                if (current < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,0,5,-5,3,3,0,-4,-5};
        int target = -4;
        new LeetCode16最接近的三数之和().threeSumClosest2(array, target);
    }
}
