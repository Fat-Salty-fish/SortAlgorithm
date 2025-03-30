package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode1554只有一个不同字符的字符串 {

    /**
     * 对每个字符更换一下，然后加到一个set里，看看有没有重复
     *
     * @param dict
     * @return
     */
    public boolean differByOne(String[] dict) {
        int stringLength = dict[0].length();

        for (int i = 0; i < stringLength; i++) {
            for (int j = 0; j < 26; j++) {
                char current = (char) ('a' + j);
                Set<String> set = new HashSet<>();
                for (String s : dict) {
                    StringBuilder builder = new StringBuilder(s);
                    builder.setCharAt(i, current);
                    if (set.contains(builder.toString())) {
                        return true;
                    }
                    set.add(builder.toString());
                }
            }
        }

        return false;

    }

    /**
     * 需要用到字符串哈希和滚动哈希的算法
     * 坑爹呀
     *
     * @param dict
     * @return
     */
    private static final long BASE = 31; // 哈希基数
    private static final long MOD = (long) 1e9 + 7; // 哈希模数

    public boolean differByOne2(String[] dict) {
        int n = dict.length;
        int m = dict[0].length();

        // 预计算 BASE 的幂次
        long[] power = new long[m];
        power[0] = 1;
        for (int i = 1; i < m; i++) {
            power[i] = (power[i - 1] * BASE) % MOD;
        }

        // 计算每个字符串的哈希值
        long[] hash = new long[n];
        for (int i = 0; i < n; i++) {
            long h = 0;
            for (int j = 0; j < m; j++) {
                h = (h * BASE + (dict[i].charAt(j) - 'a')) % MOD;
            }
            hash[i] = h;
        }

        // 检查每个可能的掩码位置
        for (int j = 0; j < m; j++) {
            Map<Long, Integer> seen = new HashMap<>();
            for (int i = 0; i < n; i++) {
                // 计算去掉第 j 个字符后的哈希值
                long newHash = (hash[i] - (dict[i].charAt(j) - 'a') * power[m - 1 - j] % MOD + MOD) % MOD;

                if (seen.containsKey(newHash)) {
                    // 二次验证：检查实际字符串是否只有一个字符不同
                    int prevIndex = seen.get(newHash);
                    if (isOneCharDiff(dict[prevIndex], dict[i], j)) {
                        return true;
                    }
                }
                seen.put(newHash, i);
            }
        }
        return false;
    }

    // 检查两个字符串是否只有第 j 个字符不同
    private boolean isOneCharDiff(String s1, String s2, int j) {
        for (int i = 0; i < s1.length(); i++) {
            if (i == j) continue; // 跳过被掩码的位置
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
