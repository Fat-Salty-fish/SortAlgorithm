package aimToOfferII;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/5
 */
public class AimToOffer39数组中出现次数超过一半的数字 {


    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    /**
     * 选举法
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int result = 0;
        int count = 0;
        for (int temp : nums) {
            if (count <= 0) {
                result = temp;
                count = 1;
            } else if (temp == result) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }

}
