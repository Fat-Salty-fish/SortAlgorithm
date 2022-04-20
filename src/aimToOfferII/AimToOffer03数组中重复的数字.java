package aimToOfferII;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/26
 */
public class AimToOffer03数组中重复的数字 {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int temp:nums){
            if (set.contains(temp)){
                return temp;
            }
            set.add(temp);
        }
        return -1;
    }
}
