package aimToOfferII;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/5/10
 */
public class AimToOffer56_1数组中数字出现的次数 {


    public int[] singleNumbers(int[] nums) {
        // 有两个数字出现两次
        int[] result = new int[2];
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int bit = 0;
        while (bit <= 31 && (xor & (1 << bit)) == 0) {
            bit++;
        }
        int x = 1 << bit;
        for (int temp : nums) {
            if ((temp & x) == 0) {
                result[0] = result[0] ^ temp;
            } else {
                result[1] = result[1] ^ temp;
            }
        }
        return result;
    }
}
