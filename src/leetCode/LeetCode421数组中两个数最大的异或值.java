package leetCode;

import java.util.HashSet;
import java.util.Set;

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
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int result = 0;
        // mask只是为了取前面的位数
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int temp : nums) {
                set.add(temp & mask);
            }
            int target = result | (1 << i);
            for (Integer test : set) {
                if (set.contains(target ^ test)) {
                    result = target;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 获取数组中最大的异或值
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR2(int[] nums) {
        int result = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for (int temp : nums) {
                set.add(temp & mask);
            }
            int target = result | (1 << i);
            for (int temp : set) {
                if (set.contains(target ^ temp)) {
                    result = target;
                    break;
                }
            }
        }
        return result;
    }
}
