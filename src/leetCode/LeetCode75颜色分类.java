package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/24
 */
public class LeetCode75颜色分类 {

    /**
     * 太tricky了
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    /**
     * 双指针
     *
     * @param nums
     */
    public void sortColors2(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        for (int i = left; i <= right; i++) {
            while (i >= left && i <= right && (nums[i] == 2 || nums[i] == 0)) {
                if (nums[i] == 0) {
                    nums[i] = nums[left];
                    nums[left] = 0;
                    left++;
                } else if (nums[i] == 2) {
                    nums[i] = nums[right];
                    nums[right] = 2;
                    right--;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 0, 2};
        new LeetCode75颜色分类().sortColors2(array);
        System.out.println(array);
    }
}
