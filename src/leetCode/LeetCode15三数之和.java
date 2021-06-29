package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/25 0:04
 */
public class LeetCode15三数之和 {

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

    // 二刷三数之和 总体思路：双指针
    // 其实和923题类似 只不过是目标和为0 相当于target为0
//    public List<List<Integer>> threeSum2(int nums[]){
//
//    }
}
