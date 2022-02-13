package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/17
 */
public class LeetCode1542找出最长的超赞字符串 {

    /**
     * 感觉也是动态规划
     * 类似于最长回文子序列？
     *
     * @param s
     * @return
     */
    public int longestAwesome(String s) {
        // key 序列 value 坐标
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int sequence = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';
            // 表示当前0-i的数字序列
            sequence ^= (1 << temp);
            if (map.containsKey(sequence)) {
                // 如果前后两个序列相同 那么必定可以构成一个结果 并且不能更新value（因为要找的是最长的序列）
                ans = Math.max(ans, i - map.get(sequence));
            } else {
                map.put(sequence, i);
            }
            for (int j = 0; j < 10; j++) {
                // 如果在0-i的序列中存在一个序列 使得两个序列只差1位 那么就可以构成一个结果
                if (map.containsKey(sequence ^ (1 << j))) {
                    ans = Math.max(ans, i - map.get(sequence ^ (1 << j)));
                }
            }
        }
        return ans;
    }
}
