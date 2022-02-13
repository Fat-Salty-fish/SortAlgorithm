package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/27
 */
public class LeetCode1239串联字符串的最大长度 {

    int result = 0;

    /**
     * 感觉又是一个动态规划
     * 先用暴力尝试吧
     * 或者 这是一个 拓扑排序？
     *
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        List<Integer> mask = new ArrayList<>();
        for (String a : arr) {
            int currentNum = 0;
            for (Character currentChar : a.toCharArray()) {
                int bit = currentChar - 'a';
                if ((currentNum >> bit & 1) != 0) {
                    currentNum = 0;
                    break;
                }
                currentNum |= 1 << bit;
            }
            if (currentNum > 0) {
                mask.add(currentNum);
            }
        }
        dfs(mask, 0, 0);
        return result;
    }

    public void dfs(List<Integer> nums, int pos, int currentNum) {
        if (pos == nums.size()) {
            result = Math.max(result, Integer.bitCount(currentNum));
            return;
        }
        if ((currentNum & nums.get(pos)) == 0) {
            dfs(nums, pos + 1, currentNum | nums.get(pos));
        }
        dfs(nums, pos + 1, currentNum);
    }
}
