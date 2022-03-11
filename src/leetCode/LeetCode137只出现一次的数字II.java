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
     *
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

    /**
     * 二刷 如果一系列数字 在数组中都出现过k次 那么 这些数在k进制下的无进位和 就是0
     * 那么所有数字无进位和后 就是三进制下的唯一出现过的数字
     * 本题是三进制 那么就取三进制下的数即可
     *
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            set(bits, nums[i]);
        }
        return getNormal(bits);
    }

    /**
     * 三进制下的无进制和
     *
     * @param bits
     * @param value
     */
    public void set(int[] bits, int value) {
        int[] currentNum = getNumKey(value);
        for (int i = 0; i < currentNum.length; i++) {
            bits[i] = (bits[i] + currentNum[i]) % 3;
        }
    }

    /**
     * 获取一个数的三进制
     *
     * @param value
     * @return
     */
    public int[] getNumKey(int value) {
        int[] result = new int[32];
        int index = 0;
        while (value != 0) {
            result[index++] = value % 3;
            value /= 3;
        }
        return result;
    }

    /**
     * 将三进制数组转换成正常值
     *
     * @param bits
     * @return
     */
    public int getNormal(int[] bits) {
        int result = 0;
        int temp = 1;
        for (int i = 0; i < bits.length; i++) {
            result += bits[i] * temp;
            temp *= 3;
        }
        return result;
    }


    /**
     * 和上面方法类似 就是想不清楚为什么这个不用考虑符号....
     *
     * @param nums
     * @return
     */
    public int singleNumber3(int[] nums) {
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int total = 0;
            for (int temp : nums) {
                total += ((temp >> i) & 1);
            }
            if (total % 3 != 0) {
                result |= (i << i);
            }
        }
        return result;
    }
}
