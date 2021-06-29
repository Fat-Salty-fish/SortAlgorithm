package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/4/30
 */
public class LeetCode137只出现一次的数字II {
    /**
     * 只出现一次的数字II
     * 有一个数字只出现过一次 剩余的数字都出现过三次
     * 尝试寻找规律
     * 通过真值表来实现
     * 如果把所有的数换成二进制 并加起来对三取余数 则一定会是0或者1
     * 真值表运算
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i++) {
            int tempA = (~a & b & nums[i]) | (a & ~b & ~nums[i]);
            int tempB = (~a) & (b ^ nums[i]);
            a = tempA;
            b = tempB;
        }
        return b;
    }
}
