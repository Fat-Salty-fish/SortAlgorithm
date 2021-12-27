package leetCode;

import java.util.ArrayList;
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


    /**
     * 2刷三数之和
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            result.addAll(sumTwoNum(nums, -nums[i], i + 1, nums[i]));
            int currentNum = nums[i];
            // 这里其实会少加一 但是运行成功是因为for循环里最后还要i++
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }


    /**
     * 两数之和
     * 数组已经提前排序过
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> sumTwoNum(int[] nums, int target, int startIndex, int currentFather) {
        int left = startIndex;
        int right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int low = nums[left];
            int high = nums[right];
            if (sum == target) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                list.add(currentFather);
                result.add(list);
                while (left < right && nums[left] == low) {
                    left++;
                }
                while (left < right && nums[right] == high) {
                    right--;
                }
            } else if (sum < target) {
                while (left < right && nums[left] == low) {
                    left++;
                }
            } else {
                while (left < right && nums[right] == high) {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = new LeetCode15三数之和().threeSum2(array);
        System.out.println("运行结束了" + result);
    }
}
