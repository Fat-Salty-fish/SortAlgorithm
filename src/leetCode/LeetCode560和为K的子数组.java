package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/27
 */
public class LeetCode560和为K的子数组 {


    /**
     * 感觉像是动态规划
     * 但其实不是 是前缀和
     *
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        // 保存 在target为key时 有value种情况
        Map<Integer, Integer> map = new HashMap<>();
        // sum=0时有1种方法
        map.put(0, 1);
        // 统计所有的前缀和
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(preSum[i] - k)) {
                result += map.get(preSum[i] - k);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        return result;
    }
}
