package aimToOfferII;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/5
 */
public class AimToOffer45把数组排成最小的数 {

    /**
     * 其实就是对数字进行排序
     * @param nums
     * @return
     */
    public String minNumber(int[] nums) {
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder builder = new StringBuilder();
        for (String temp : array) {
            builder.append(temp);
        }
        return builder.toString();
    }
}
