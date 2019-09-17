package leetCode;

import java.security.interfaces.ECKey;

/**
 * @author acer
 * @Date 2019/8/25 2:39
 */
public class LeetCode34 {
    //要求时间复杂度是logn级别 肯定是用二分查找了
    //要找两个数 一个是target对应的开头 一个是target对应的结尾
    //对数组进行两次二分查找
    //先找到左边界
    //再找到又边界
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int length = nums.length;
        int left;
        int right;

        int[] ans = new int[2];
        //先对左边界进行二分查找
        left = 0;
        //因为要寻找边界 所以为左闭右开
        right = length;

        //终止条件为 left = right
        while (left < right) {
            //获取中位
            int mid = (left + right) / 2;
            //如果中位的数为目标数 则在[left,mid)中继续寻找
            if (nums[mid] == target) {
                right = mid;
                //如果中位的数比目标数小 则在[mid,right)中继续寻找
            } else if (nums[mid] < target) {
                left = mid + 1;
                //如果中位的数比目标数大 则在[left,mid)中继续寻找
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == length) {
            ans[0] = -1;
        }
        else {
            ans[0] = nums[left] == target ? left : -1;
        }


        //对右边界进行二分查找
        left = 0;
        right = length;
        while (left < right) {
            int mid = (left + right) / 2;
            //如果中位的数等于目标数 则在[mid,right)中继续寻找
            if (nums[mid] == target) {
                left = mid + 1;
                //如果中位的数比目标数小 则在[mid,right)中继续寻找
            } else if (nums[mid] < target) {
                left = mid + 1;
                //如果中位的数比目标数大 则在[left,mid)中继续寻找
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {
            ans[1] = -1;
        }else {
            ans[1] = nums[left - 1] == target ? left - 1 : -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        new LeetCode34().searchRange(new int[]{1},0);
    }
}
