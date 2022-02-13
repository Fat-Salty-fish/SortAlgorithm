package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2022/1/7
 */
public class LeetCode242有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charToNum = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            charToNum.put(temp, charToNum.getOrDefault(temp, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            if (!charToNum.containsKey(temp)) {
                return false;
            }
            if (charToNum.get(temp) == 1) {
                charToNum.remove(temp);
            } else {
                charToNum.put(temp, charToNum.get(temp) - 1);
            }
        }
        return charToNum.isEmpty();
    }

    public static void main(String[] args) {
        String a = "cat";
        String b = "rat";
        boolean result = new LeetCode242有效的字母异位词().isAnagram(a, b);
    }
}
