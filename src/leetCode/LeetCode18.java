package leetCode;

import jdk.nashorn.internal.objects.NativeNumber;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author acer
 * @Date 2019/8/21 18:07
 */
public class LeetCode18 {
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
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[length-1]+nums[length-2]+nums[length-3] < target){
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j-i> 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2] >target){
                    break;
                }
                if(nums[i]+nums[j]+nums[length-1]+nums[length-2] <target){
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

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        new LeetCode18().fourSum(nums,-1);
    }
}
