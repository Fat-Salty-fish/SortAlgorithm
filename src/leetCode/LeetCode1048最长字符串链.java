package leetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/9/20
 */
public class LeetCode1048最长字符串链 {

    /**
     * 动态规划特训
     * 有点最长递增子序列的味道了
     *
     * @param words
     * @return
     */
    public int longestStrChain(String[] words) {
        if (words == null || words.length == 0) {
            return 0;
        }
        if (words.length == 1) {
            return 1;
        }
        // 需要先对字符串数组进行排序
        Arrays.sort(words, Comparator.comparingInt(String::length));
        // 定义dp 表示以i为结尾的单词组成的词链长度为dp[i];
        int[] dp = new int[words.length];
        int maxLength = 0;
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (checkPre(words[j], words[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    /**
     * 判断a字符串是否为b字符串的前身
     * 在a字符串上插入任意字符 能够成为b字符串
     * 即a字符串是否为b字符串的子序列
     *
     * @param str1
     * @param str2
     * @return
     */
    public boolean checkPre(String str1, String str2) {
        if (str2.length() - str1.length() != 1) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        while (index1 < str1.length() && index2 < str2.length()) {
            // 相同时 两指针同时向前
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index1++;
                index2++;
            } else {
                // 否则 index2向前
                index2++;
            }
        }
        return index1 == str1.length();
    }

    public static void main(String[] args) {
        String[] array = {"wnyxmflkf", "xefx", "usqhb", "ttmdvv", "hagmmn", "tmvv", "pttmdvv", "nmzlhlpr", "ymfk", "uhpaglmmnn", "zckgh", "hgmmn", "isqxrk", "isqrk", "nmzlhpr", "uysyqhxb", "haglmmn", "xfx", "mm", "wymfkf", "tmdvv", "uhaglmmn", "mf", "uhaglmmnn", "mfk", "wnymfkf", "powttkmdvv", "kwnyxmflkf", "xx", "rnqbhxsj", "uysqhb", "pttkmdvv", "hmmn", "iq", "m", "ymfkf", "zckgdh", "zckh", "hmm", "xuefx", "mv", "iqrk", "tmv", "iqk", "wnyxmfkf", "uysyqhb", "v", "m", "pwttkmdvv", "rnqbhsj"};
        int result = new LeetCode1048最长字符串链().longestStrChain(array);
        System.out.println("结果" + result);
    }
}
