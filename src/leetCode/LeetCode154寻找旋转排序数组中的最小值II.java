package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/27
 */
public class LeetCode154寻找旋转排序数组中的最小值II {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[right]) {
                if (mid == 0 || nums[mid - 1] > nums[mid]) {
                    return nums[mid];
                }
                right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = right - 1;
            }
        }
        return nums[left];
    }
}
