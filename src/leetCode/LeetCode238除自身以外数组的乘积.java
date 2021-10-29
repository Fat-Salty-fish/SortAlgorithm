package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/28
 */
public class LeetCode238除自身以外数组的乘积 {

    /**
     * 动态规划特训
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] leftDp = new int[nums.length];
        int[] rightDp = new int[nums.length];
        // 从左往右乘
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                leftDp[i] = 1;
            } else {
                leftDp[i] = nums[i - 1] * leftDp[i - 1];
            }
        }
        // 从右往左乘
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                rightDp[i] = 1;
            } else {
                rightDp[i] = nums[i + 1] * rightDp[i + 1];
            }
        }

        int[] outputs = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            outputs[i] = leftDp[i] * rightDp[i];
        }
        return outputs;
    }

    /**
     * 动态规划特训
     * 如何降低空间复杂度？在常数时间复杂度
     * 可以直接使用outputs数组保存数据
     *
     * @param nums
     * @return
     */
    public int[] productExceptSelf2(int[] nums) {
        int[] outputs = new int[nums.length];
        outputs[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            outputs[i] = outputs[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            outputs[i] *= right;
            right *= nums[i];
        }
        return outputs;
    }
}
