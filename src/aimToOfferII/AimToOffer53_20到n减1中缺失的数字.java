package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/4/6
 */
public class AimToOffer53_20到n减1中缺失的数字 {


    public int missingNumber(int[] nums) {
        for (int i = 0;i<nums.length;i++){
            if (nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }
}
