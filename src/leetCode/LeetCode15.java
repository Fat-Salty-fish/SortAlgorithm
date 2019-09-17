package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/25 0:04
 */
public class LeetCode15 {
    //给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    //
    //注意：答案中不可以包含重复的三元组。
    //
    //例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    //
    //满足要求的三元组集合为：
    //[
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    //]
    //
    //先对数组进行排序 排序之后通过三个指针来完成 确定一个指针对应的数字 移动另外两个指针 相加来判断是否有结果

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);      //先对数组进行排序
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;  //如果当前的数字为0(此时代表的是左边的数字) 则三数之和一定大于0 结束循环
            if (i > 0 && nums[i] == nums[i - 1])
                continue;//用来去重

            int left = i + 1;     //左指针 位于当前数字的右一单位
            int right = len - 1;  //右指针 位于数组的末尾

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) left++;
                else if (sum > 0) right--;
            }
        }
        return ans;
    }
}
