package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/21
 */
public class LeetCode87扰乱字符串 {

    String s1;

    String s2;

    // 0表示未计算 -1表示false 1表示true
    int[][][] memo;

    /**
     * 一个map好像解决不了问题
     * 看起来像是分治思想
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        int length = s1.length();
        memo = new int[length][length][length + 1];
        return dfs(0, 0, length);
    }

    public boolean dfs(int s1Index, int s2Index, int length) {
        if (memo[s1Index][s2Index][length] != 0) {
            return memo[s1Index][s2Index][length] == 1;
        }
        if (s1.substring(s1Index, s1Index + length).equals(s2.substring(s2Index, s2Index + length))) {
            memo[s1Index][s2Index][length] = 1;
            return true;
        }
        if (!check(s1Index, s2Index, length)) {
            memo[s1Index][s2Index][length] = -1;
            return false;
        }

        // 枚举分割的情况
        for (int i = 1; i < length; i++) {
            // 不交换的情况
            if (dfs(s1Index, s2Index, i) && dfs(s1Index + i, s2Index + i, length - i)) {
                memo[s1Index][s2Index][length] = 1;
                return true;
            }
            // 交换的情况
            if (dfs(s1Index, s2Index + length - i, i) && dfs(s1Index + i, s2Index, length - i)) {
                memo[s1Index][s2Index][length] = 1;
                return true;
            }
        }
        memo[s1Index][s2Index][length] = -1;
        return false;
    }

    /**
     * 检查两个字符串内的字符是否相同
     *
     * @param s1Index
     * @param s2Index
     * @param length
     * @return
     */
    public boolean check(int s1Index, int s2Index, int length) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = s1Index; i < s1Index + length; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        for (int i = s2Index; i < s2Index + length; i++) {
            if (!map.containsKey(s2.charAt(i))) {
                return false;
            }
            map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
            if (map.get(s2.charAt(i)) == 0) {
                map.remove(s2.charAt(i));
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        String a = "great";
        String b = "rgeat";
        boolean result = new LeetCode87扰乱字符串().isScramble(a, b);
    }
}
