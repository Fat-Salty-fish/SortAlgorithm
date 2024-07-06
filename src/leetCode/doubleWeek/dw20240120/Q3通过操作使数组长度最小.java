package leetCode.doubleWeek.dw20240120;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/21
 */
public class Q3通过操作使数组长度最小 {

    /**
     * 看上去永远选数组中最大的和第二大的，用第二大的对最大的取余
     * 莫非是用优先队列？
     *
     * @param nums
     * @return
     */
    public int minimumArrayLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        boolean flag = false;
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }

        for (int num : nums) {
            if (num % min != 0) {
                flag = true;
            }
        }

        if (flag) {
            return 1;
        } else {
            int num = 0;
            for (int x : nums) {
                if (x == min) {
                    num++;
                }
            }
            return (num + 1) / 2;
        }
    }

}
