package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/13
 */
public class LeetCode523连续的子数组和 {

    /**
     * 同余定理：如果 a 和 b 对c取余的结果相同 那么a和b同余
     * a和b同余-》a-b为c的整数倍
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        // 保存前缀和对k的余数 现在求的是 是否存在a和b 使得a-b为k的整数 并且a-b的长度超过2
        Map<Integer, Integer> presToIndex = new HashMap<>();
        // 余数为0时 是符合条件的
        presToIndex.put(0, -1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            int mod = pre % k;
            if (presToIndex.containsKey(mod)) {
                int targetIndex = presToIndex.get(mod);
                if (i - targetIndex >= 2) {
                    return true;
                }
            } else {
                presToIndex.put(mod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {0,0};
        int k = 1;
        boolean result = new LeetCode523连续的子数组和().checkSubarraySum(array, k);
    }
}
