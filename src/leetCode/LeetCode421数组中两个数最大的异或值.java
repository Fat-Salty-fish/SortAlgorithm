package leetCode;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/5/17
 */
public class LeetCode421数组中两个数最大的异或值 {
    /**
     * 直接双指针试试
     * 思路有问题 既不能直接找最大值后求异或 也不能双重for循环
     * 只能针对每一位进行运算 或者使用前缀树实现
     * 先使用位运算实现 二刷使用前缀树实现吧
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        return 0;
    }
}
