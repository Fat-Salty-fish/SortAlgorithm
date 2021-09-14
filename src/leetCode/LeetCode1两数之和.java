package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author acer
 * @Date 2019/7/25 0:09
 */
public class LeetCode1两数之和 {
    //两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num = 0; num < nums.length; num++) {
            //获取匹配当前数值的数是多少
            int complement = target - nums[num];
            //查询map中是否存在这样的数字
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), num};
            }
            //存放时 key为自己的数字 value为下标。
            map.put(nums[num], num);
        }
        return null;
    }

    /**
     * 二刷两数之和
     * 双指针法
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        // 做几数之和时 如果要所有可能的情况 则建议排序 但是现在要的是数字的位置 所以不能排序 也不能跳过所有相同的数字
        // 看来只能用第一种方法 用map来解决
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int sum = 0;
        int[] result = new int[2];
        while (left < right) {
            sum = nums[left] + nums[right];
            if (sum < target) {
                do {
                    left++;
                } while (left < right && nums[left] == nums[left - 1]);
            } else if (sum > target) {
                do {
                    right--;
                } while (nums[right] == nums[right + 1] && right > left);
            } else {
                result[0] = left;
                result[1] = right;
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {3,2,4};
        int target = 6;
        int[] result = new LeetCode1两数之和().twoSum2(array, target);
        System.out.println(result);
    }
}
