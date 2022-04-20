package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/30
 */
public class AimToOffer21调整数组顺序使奇数位于偶数前面 {

    /**
     * 双指针
     *
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int left = 0;
        while (left < nums.length && nums[left] % 2 != 0) {
            left++;
        }
        int right = nums.length - 1;
        while (right >= 0 && nums[right] % 2 == 0) {
            right--;
        }
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
            while (left < nums.length && nums[left] % 2 != 0) {
                left++;
            }
            while (right >= 0 && nums[right] % 2 == 0) {
                right--;
            }
        }
        return nums;
    }

    public void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
