package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
            result = Math.max(result, right - left);
        }
        return result;
    }

    /**
     * 二刷
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = Integer.MIN_VALUE;
        while (right < s.length()) {
            Character currentRight = s.charAt(right);
            right++;
            charMap.put(currentRight, charMap.getOrDefault(currentRight, 0) + 1);
            while (charMap.get(currentRight) > 1) {
                Character currentLeftChar = s.charAt(left);
                charMap.put(currentLeftChar, charMap.get(currentLeftChar) - 1);
                left++;
            }
            length = Math.max(length, right - left);
        }
        return length == Integer.MIN_VALUE ? 0 : length;
    }

    /**
     * 三刷 双指针
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring3(String s) {
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int result = 0;
        while (left < s.length()) {
            while (right < s.length() && !set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                result = Math.max(result, right - left);
            }
            if (right == s.length()){
                break;
            }
            while (left <= right && set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = new LeetCode3无重复字符的最长子串().lengthOfLongestSubstring3(s);
        System.out.println(result);
    }
}
