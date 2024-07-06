package leetCode.doubleWeek.dw20240120;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/21
 */
public class Q1将数组分成最小总代价的子数组I {
    public int minimumCost(int[] nums) {
        if (nums.length == 3) {
            return Arrays.stream(nums).sum();
        }
        // 第一个数组一定是以数组的第一个元素为开头的
        // 剩下的两个，需要从剩下的元素里找到，两个元素和为最小的情况
        // 最差情况，双指针 On2
        // 用二维数组，能否可行？
        int result = nums[0];
        int temp = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] < temp) {
                    temp = nums[i] + nums[j];
                }
            }
        }

        result += temp;
        return result;
    }
}
