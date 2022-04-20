package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/6
 */
public class AimToOffer53_1在排序数组中查找数字1 {

    /**
     * 一看题目就是二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = getIndex(nums, target);
        int result = 0;
        while (start < nums.length && nums[start] == target) {
            result++;
            start++;
        }
        return result;
    }

    /**
     * 寻找左边界
     *
     * @param nums
     * @param target
     * @return
     */
    public int getIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] >= target) {
                right = mid;
            }
        }
        return right;
    }
}
