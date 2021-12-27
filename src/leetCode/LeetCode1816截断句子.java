package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/6
 */
public class LeetCode1816截断句子 {

    public String truncateSentence(String s, int k) {
        Map<String, Integer> wordsMap = new HashMap<>();
        StringBuilder builder = new StringBuilder();
        int wordNum = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                wordNum++;
                if (wordNum == k) {
                    return s.substring(0, i);
                }
            } else if (i == s.length() - 1) {
                return s;
            }
        }
        return "";
    }
}
