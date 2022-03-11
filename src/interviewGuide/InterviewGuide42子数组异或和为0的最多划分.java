package interviewGuide;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/2/25
 */
public class InterviewGuide42子数组异或和为0的最多划分 {

    /**
     * 计算异或结果为0的最多子数组数量
     *
     * @param array
     * @return
     */
    public int numOfZeroXORSubArray(int[] array) {
        int[] dp = new int[array.length + 1];
        Map<Integer, Integer> preXORMap = new HashMap<>();
        preXORMap.put(0, -1);
        int current = 0;

        for (int i = 0; i < array.length; i++) {
            current ^= array[i];
            // 自己异或自己的时候即为0
            if (preXORMap.containsKey(current)) {
                dp[i + 1] = Math.max(dp[i], dp[preXORMap.get(current) + 1] + 1);
            } else {
                dp[i + 1] = dp[i];
            }
            preXORMap.put(current, i);
        }
        return dp[array.length];
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 9, 0, 7, 0, 2, 1, 3};
        int result = new InterviewGuide42子数组异或和为0的最多划分().numOfZeroXORSubArray(array);
        System.out.println(result);
    }
}
