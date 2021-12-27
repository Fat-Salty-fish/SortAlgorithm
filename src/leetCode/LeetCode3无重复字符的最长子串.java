package leetCode;

import java.util.HashMap;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/11/25
 */
public class LeetCode3无重复字符的最长子串 {


    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int result = 0;
        HashMap<Character, Integer> mapCount = new HashMap<>();
        while (right < s.length()) {
            Character current = s.charAt(right);
            if (mapCount.containsKey(current)) {
                mapCount.put(current, mapCount.get(current) + 1);
            } else {
                mapCount.put(current, 1);
            }
            while (mapCount.get(current) > 1) {
                mapCount.put(s.charAt(left), mapCount.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
            result = Math.max(result,right-left);
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = new LeetCode3无重复字符的最长子串().lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
