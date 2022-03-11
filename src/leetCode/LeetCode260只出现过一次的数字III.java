package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/3/11
 */
public class LeetCode260只出现过一次的数字III {

    /**
     * 有两个数只出现过一次
     *
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        int xorAWithB = 0;
        for (int temp : nums) {
            xorAWithB ^= temp;
        }
        int rightFirstOne = xorAWithB & (~xorAWithB + 1);
        int single = 0;
        for (int temp : nums) {
            if ((temp & rightFirstOne) != 0) {
                single ^= temp;
            }
        }
        int[] result = new int[2];
        result[0] = single ^ xorAWithB;
        result[1] = single;
        return result;
    }
}
