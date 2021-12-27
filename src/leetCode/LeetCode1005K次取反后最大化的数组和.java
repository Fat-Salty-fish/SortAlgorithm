package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/3
 */
public class LeetCode1005K次取反后最大化的数组和 {


    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 还需要反转
            if (k > 0) {
                if (nums[i] < 0) {
                    result -= nums[i];
                    k--;
                    smallest = Math.min(smallest, -nums[i]);
                } else if (nums[i] == 0) {
                    // 这里直接将所有k用完 因为是0
                    k = 0;
                } else {
                    // k有偶数个 相当于用完并且此数还是正的
                    if (k % 2 == 0) {
                        result += nums[i];
                    } else {
                        // k有奇数个 则此时需要减一个这种情况下 最小的正数(包括之前已经反转过后的) 如果是之前已经反转过的 需要减两次（因为之前加多了一次
                        if (smallest < nums[i]) {
                            result -= 2 * smallest;
                            result += nums[i];
                        } else {
                            result -= nums[i];
                        }
                        k = 0;
                    }
                }
            } else {
                result += nums[i];
            }
        }
        if (k > 0) {
            // 说明之前已经反转过了 现在是正数
            if (nums[nums.length - 1] < 0) {
                // 如果k不为偶数 则需要再变回去
                if (k % 2 != 0) {
                    result += 2 * nums[nums.length - 1];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{-4, -3, -2};
        int result = new LeetCode1005K次取反后最大化的数组和().largestSumAfterKNegations(array, 4);
        System.out.println(result);
    }
}
