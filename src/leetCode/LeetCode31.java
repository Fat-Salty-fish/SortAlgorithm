package leetCode;

/**
 * @author acer
 * @Date 2019/8/24 20:39
 */
public class LeetCode31 {
    //实现下一个字典序
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //先找到第一个左邻小于右邻的
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        int j = nums.length - 1;
        //找到i后面比nums[i]大的最下的数
        if (i >= 0) {
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }

    public void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
