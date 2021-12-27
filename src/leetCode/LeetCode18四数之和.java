package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author acer
 * @Date 2019/8/21 18:07
 */
public class LeetCode18四数之和 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                ans.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return ans;
        }
        //先对数组进行排序
        Arrays.sort(nums);
        int length = nums.length;
        //然后使用双指针法 因为是四个数 则先确定两个数
        for (int i = 0; i < length - 3; i++) {
//            用来去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if (nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j - i > 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }
                int left = j + 1;
                int right = length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        List<Integer> current = Arrays.asList(nums[i], nums[j], nums[left], nums[right]);
                        ans.add(current);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }


    /**
     * 四数之和
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum2(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 0, 4);
    }


    public List<List<Integer>> nSum(int[] nums, int target, int startIndex, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (n > 3) {
            for (int i = startIndex; i < nums.length; i++) {
                List<List<Integer>> oneShot = nSum(nums, target - nums[i], i + 1, n - 1);
                for (List<Integer> one : oneShot) {
                    one.add(nums[i]);
                }
                result.addAll(oneShot);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        } else {
            for (int i = startIndex; i < nums.length; i++) {
                List<List<Integer>> oneShot = sumTowNum(nums, target - nums[i], i + 1);
                for (List<Integer> single : oneShot) {
                    single.add(nums[i]);
                }
                result.addAll(oneShot);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
        return result;
    }


    /**
     * 回归到两数之和
     * 调用之前一定要排序
     * 如果parentNum不为-1 就添加到结果里去
     *
     * @param nums
     * @param target
     * @param startIndex
     * @return
     */
    public List<List<Integer>> sumTowNum(int[] nums, int target, int startIndex) {
        int left = startIndex;
        int right = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (left < right) {
            int sum = nums[left] + nums[right];
            int low = nums[left];
            int high = nums[right];
            if (sum == target) {
                List<Integer> currentAns = new ArrayList<>();
                currentAns.add(low);
                currentAns.add(high);
                result.add(currentAns);
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
        int[] nums = new int[]{1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = new LeetCode18四数之和().fourSum2(nums, 0);
        System.out.println("结果为" + result);
    }
}
