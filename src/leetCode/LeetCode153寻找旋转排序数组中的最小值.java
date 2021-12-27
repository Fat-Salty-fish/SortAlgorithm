package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/26
 */
public class LeetCode153寻找旋转排序数组中的最小值 {

    /**
     * 感觉是二分查找
     * 先遍历一次 找到直到不是省序的第一个值 否则返回数组的第一个
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    /**
     * 二分查找 但是二分查找的精髓好像很难理解...
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midNum = nums[mid];
            if (midNum < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }
}
