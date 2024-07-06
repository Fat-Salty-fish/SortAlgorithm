package leetCode;

import java.util.Arrays;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2024/1/21
 */
public class LeetCode100192输入单词需要的最少按键次数II {

    /**
     * 可以有重复字母，感觉要对字母根据数量进行排序
     *
     * @param word
     * @return
     */
    public int minimumPushes(String word) {
        if (word == null || word.isEmpty()) {
            return 0;
        }
        int[] count = new int[26];
        for (char ch : word.toCharArray()) {
            count[ch - 'a']++;
        }
        Arrays.sort(count);
        int result = 0;
        int posi = 1;
        int samphor = 8;
        for (int i = 25; i >= 0; i--) {
            if (count[i] == 0) {
                break;
            }
            result += count[i] * posi;
            samphor--;
            if (samphor == 0) {
                posi++;
                samphor = 8;
            }
        }
        return result;
    }
}
